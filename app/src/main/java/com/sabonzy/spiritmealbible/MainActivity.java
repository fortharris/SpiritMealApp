package com.sabonzy.spiritmealbible;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.SearchManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sabonzy.tabadapter.ArrayHelper;
import com.sabonzy.tabadapter.SpiriteMealDbOpenHelper;

public class MainActivity extends ActionBarActivity implements OnClickListener,
		MultiChoiceModeListener {
	
	int mPosition = -1;
	int currentBookIndex;
	String[] bibleBooks;
	private DrawerLayout mDrawerLayout;
	private ListView slideDrawerList, chapterListView;
	private ActionBarDrawerToggle mDrawerToggle;	
	private LinearLayout mDrawer, mainLayout;
	private List<HashMap<String, String>> mList;
	private SimpleAdapter mAdapter;
	final private String COUNTRY = "country";
	ArrayHelper defaultBook, myColor;
	private ImageView next, prev;
	private static String DB_NAME;
	private static String TABLE_NAME;
	// private static final String ID = "_id";
	private static final String BOOK_CHAPTER = "chapter";
	private static final String BOOK_VERSE = "verse";
	private SQLiteDatabase database;
	private Cursor cursor;
	private int iterate;
	private SpiriteMealDbOpenHelper dbOpenHelper;
	private int totalChapterCount;
	ArrayList<String> list, colorList;
	private int scrollto;
	private ArrayList<String> array;
	protected float size = 16;
	private ArrayAdapter<String> adapter;
	private String chapterView_bgColor;
	private String chapterView_textColor;
	private ImageView centerNavButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		findviewById();

		// Getting an array of bible books
		bibleBooks = getResources().getStringArray(R.array.newtestament);
		list = new ArrayList<String>();
		slideDrawerList.setBackgroundColor(Color.argb(100, 0, 0, 0));
		defaultBook = new ArrayHelper(this);
		list = defaultBook.getArray("dbname");
		DB_NAME = list.get(0);
		TABLE_NAME = list.get(1);
		iterate = Integer.parseInt(list.get(2));
		totalChapterCount = Integer.parseInt(list.get(3));
		array = defaultBook.getVerseIndex("verse");
		scrollto = Integer.parseInt(array.get(0));
		getSupportActionBar().setTitle(TABLE_NAME);
		myColor = new ArrayHelper(this);
		colorList = new ArrayList<String>();
		colorList = myColor.getColor("color");
		chapterView_bgColor = colorList.get(0);
		chapterView_textColor = colorList.get(1);
		mainLayout.setBackgroundColor(Color.parseColor(chapterView_bgColor));

		TABLE_NAME = TABLE_NAME.replace(" ", "");
		if (TABLE_NAME.startsWith("1")) {
			TABLE_NAME = TABLE_NAME.replace("1", "first_");
		} else if (TABLE_NAME.startsWith("2")) {
			TABLE_NAME = TABLE_NAME.replace("2", "second_");
		} else if (TABLE_NAME.startsWith("3")) {
			TABLE_NAME = TABLE_NAME.replace("3", "third_");
		}
		// Each row in the list stores country name, count and flag
		mList = new ArrayList<HashMap<String, String>>();

        
		for (int i = 0; i < bibleBooks.length; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put(COUNTRY, bibleBooks[i]);
			mList.add(hm);
		}

        // Keys used in Hashmap
		String[] from = { COUNTRY };

        // Ids of views in listview_layout
		int[] to = { R.id.country };
		mAdapter = new SimpleAdapter(this, mList, R.layout.drawer_layout, from,
				to) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				View v = super.getView(position, convertView, parent);
				TextView tv = (TextView) v.findViewById(R.id.country);
				if (position > 38) {
					tv.setTextColor(Color.parseColor("#EB6C6C"));
				} else {
					tv.setTextColor(Color.parseColor("#ffffff"));
				}
				// tv.setTextSize(20);
				return v;
			}

		};
        

        
        // Creating a ToggleButton for NavigationDrawer with drawer event listener
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer , R.string.drawer_open,R.string.drawer_close){
        	
        	 /** Called when drawer is closed */
            public void onDrawerClosed(View view) {               
				highlightSelectedBook();
				supportInvalidateOptionsMenu();
            }

            /** Called when a drawer is opened */
            public void onDrawerOpened(View drawerView) {            	
				// getSupportActionBar().setTitle("Select a Book");
				highlightSelectedBook();
            	supportInvalidateOptionsMenu();                
            }
        };
        
        // Setting event listener for the drawer
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        // ItemClick event handler for the drawer items
        slideDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				launchChapterVerseSelect(position);
			}
		});
        
        
        // Enabling Up navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);     
        getSupportActionBar().setDisplayShowHomeEnabled(true);        

        // Setting the adapter to the listView
		slideDrawerList.setAdapter(mAdapter);
		slideDrawerList.setTextFilterEnabled(true);
		dbOpenHelper = new SpiriteMealDbOpenHelper(this, DB_NAME);
		database = dbOpenHelper.openDataBase();
		loadChapterContents(iterate,TABLE_NAME);
		chapterListView.setMultiChoiceModeListener(this);
		chapterListView.setDivider(null);
		chapterListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		next.setOnClickListener(this);
		prev.setOnClickListener(this);
		centerNavButton.setOnClickListener(this);
	}
	
	private void findviewById() {
		slideDrawerList = (ListView) findViewById(R.id.drawer_list);
		mDrawer = (LinearLayout) findViewById(R.id.drawer);
		mainLayout = (LinearLayout) findViewById(R.id.content_frame);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		chapterListView = (ListView) findViewById(R.id.listView1);
		next = (ImageView) findViewById(R.id.ibnext);
		centerNavButton = (ImageView) findViewById(R.id.centerNavButton);
		prev = (ImageView) findViewById(R.id.ibprev);

	}
	
	public void launchChapterVerseSelect(int bookIndex) {
		
		String bookName = bibleBooks[bookIndex];
		Bundle bundle = new Bundle();
		bundle.putString("chapter", bookName);

		if (bookIndex > 38) {
			DB_NAME = "newtestament.sqlite3";
		} else {
			DB_NAME = "oldtestament.sqlite3";
		}
		bundle.putString("dbname", DB_NAME);
		Intent i = new Intent(MainActivity.this, TabActivity.class);
		i.putExtras(bundle);
		startActivity(i);
		mDrawerLayout.closeDrawer(mDrawer);
		String[] verseTab = { bookName, "0" };
		ArrayHelper ha = new ArrayHelper(getBaseContext());
		ArrayList<String> array = new ArrayList<String>();
		for (String s : verseTab) {
			array.add(s);
		}
		ha.saveArray("versetab", array);
		
	}

	public void loadChapterContents(int chapterNum, String bookName) {
		TABLE_NAME = bookName;
		String queryDB = "select " + BOOK_VERSE + " from " + bookName
				+ " where " + BOOK_CHAPTER + " = " + chapterNum;
		cursor = database.rawQuery(queryDB, null);
		if (!(cursor == null)) {
			cursor.moveToFirst();
			int verseIndex = cursor.getColumnIndex(BOOK_VERSE);
			String verseText = cursor.getString(verseIndex);
			String[] n = verseText.split("\\n\\n");
			adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_activated_1, n) {

				@Override
				public View getView(int position, View convertView,
						ViewGroup parent) {
					// TODO Auto-generated method stub
					View view = super.getView(position, convertView, parent);
					TextView tv = (TextView) view.findViewById(android.R.id.text1);
					tv.setTextColor(Color.parseColor(chapterView_textColor));
					tv.setTextSize(size);
					
					return view;
				}

			};
			
			chapterListView.setAdapter(adapter);
			chapterListView.setSelection(scrollto);
			// mainList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
			cursor.close();

		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	    }
		switch (item.getItemId()) {
		case R.id.zoomIn:
			if (size > 36) {
				item.setEnabled(false);
			} else {
				item.setEnabled(true);
				size += 2;
				// getVerse();
				adapter.notifyDataSetChanged();
			}

			break;
		case R.id.zoomOut:
if(size<8) {
	item.setEnabled(false);
			} else {
				item.setEnabled(true);
				size -= 2;
				adapter.notifyDataSetChanged();
			}
			break;

		case R.id.search:

			break;
		case R.id.contrast:
			if (chapterView_bgColor.equalsIgnoreCase("#FFFFFF")) {
				chapterView_bgColor = "#1A1A1A";
				chapterView_textColor = "#9C9C9C";
				mainLayout.setBackgroundColor(Color.parseColor(chapterView_bgColor));
				adapter.notifyDataSetChanged();
			} else {
				chapterView_bgColor = "#FFFFFF";
				chapterView_textColor = "#000000";
				mainLayout.setBackgroundColor(Color.parseColor(chapterView_bgColor));
				adapter.notifyDataSetChanged();
			}
			ArrayHelper mycolo = new ArrayHelper(getBaseContext());
			ArrayList<String> coList = new ArrayList<String>();
			coList.add(chapterView_bgColor);
			coList.add(chapterView_textColor);
			mycolo.saveArray("color", coList);
			break;
		case R.id.feedback:
			Intent feedback = new Intent(MainActivity.this, FeedBack.class);
			startActivity(feedback);
			break;
		}
		return super.onOptionsItemSelected(item);
	}	
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));

		return super.onCreateOptionsMenu(menu);
	}
	
	
	public void highlightSelectedBook(){
		int selectedItem = slideDrawerList.getCheckedItemPosition();
		slideDrawerList.setItemChecked(mPosition, true);
		mPosition = selectedItem;
    	
		if (mPosition != -1)
			getSupportActionBar().setTitle(bibleBooks[mPosition]);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.ibnext:

			if (iterate >= 1 && iterate < totalChapterCount) {
				scrollto = 0;
				iterate += 1;
				loadChapterContents(iterate,TABLE_NAME);
			}
			break;
		case R.id.ibprev:

			if (iterate > 1) {
				scrollto = 0;
				iterate -= 1;
				loadChapterContents(iterate,TABLE_NAME);
			}
			break;
			
		case R.id.centerNavButton:

			launchChapterVerseSelect(currentBookIndex);
			break;

		}
	}



	// private void getToast(String s) {
	// // TODO Auto-generated method stub
	// Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
	// }
	public void onPause() {
		super.onPause();
		database.close();
		ArrayHelper fontsize = new ArrayHelper(getBaseContext());
		ArrayList<String> array = new ArrayList<String>();

		array.add(String.valueOf(size));
		fontsize.saveArray("font", array);
	}

	public void onDestroy() {
		super.onDestroy();
		database.close();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	public void onResume() {
		super.onResume();
		mDrawerLayout.closeDrawer(mDrawer);
		ArrayHelper getfont = new ArrayHelper(getBaseContext());
		ArrayList<String> fontList = new ArrayList<String>();
		fontList = getfont.getfontsize("font");
		size = Float.parseFloat(fontList.get(0));
		adapter.notifyDataSetChanged();
		dbOpenHelper = new SpiriteMealDbOpenHelper(this, DB_NAME);
		database = dbOpenHelper.openDataBase();

	}


	@Override
	public boolean onActionItemClicked(ActionMode arg0, MenuItem arg1) {
		// TODO Auto-generated method stub
		SparseBooleanArray items = chapterListView.getCheckedItemPositions();
		String s = "";
		for (int i = 0; i < adapter.getCount() - 1; i++) {
			if (items.get(i)) {
				s += adapter.getItem(i) + "\n";

			}

		}
		switch (arg1.getItemId()) {

		case R.id.copy:

			ClipboardManager clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			ClipData data = ClipData.newPlainText("lebel", s);
			clip.setPrimaryClip(data);
			Toast.makeText(getBaseContext(), "Copy", Toast.LENGTH_LONG).show();
			break;
		case R.id.share:
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, s);
			startActivity(Intent.createChooser(intent, "Share Via"));
			break;
		}
		arg0.finish();
		return true;

	}

	@Override
	public boolean onCreateActionMode(ActionMode arg0, Menu arg1) {
		// TODO Auto-generated method stub
		arg0.getMenuInflater().inflate(R.menu.action_mode, arg1);
		return true;
	}

	@Override
	public void onDestroyActionMode(ActionMode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onPrepareActionMode(ActionMode arg0, Menu arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onItemCheckedStateChanged(ActionMode arg0, int arg1, long arg2,
			boolean arg3) {
		// TODO Auto-generated method stub
		int count = chapterListView.getCheckedItemCount();
		arg0.setTitle(String.format("%d Selected", count));

	}


}