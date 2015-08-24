package com.sabonzy.spiritmealbible;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Locale;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sabonzy.tabadapter.ArrayHelper;
import com.sabonzy.tabadapter.SpiriteMealDbOpenHelper;

public class SearchResultsActivity extends Activity implements
		OnItemClickListener {

	Cursor c;
	private ListView txtQuery;
	SpiriteMealDbOpenHelper helper;
	SQLiteDatabase database;
	private String select;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> list;
	private String query;
	private ActionBar bar;
	private String background_color;
	private String list_textcolor;
	private ArrayHelper myColor;
	private ArrayList<String> colorList;
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// txtQuery = new ListView(this);
		setContentView(R.layout.activity_search_results);
		layout = (LinearLayout) findViewById(R.id.Mysearch);
		bar = getActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayShowHomeEnabled(true);
		myColor = new ArrayHelper(this);
		colorList = new ArrayList<String>();
		colorList = myColor.getColor("color");
		background_color = colorList.get(0);
		list_textcolor = colorList.get(1);
		layout.setBackgroundColor(Color.parseColor(background_color));
		list = new ArrayList<String>();
		txtQuery = (ListView) findViewById(R.id.txtQuery);
		handleIntent(getIntent());
		//txtQuery.setOnItemClickListener(this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		setIntent(intent);
		handleIntent(intent);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	private void handleIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			query = intent.getStringExtra(SearchManager.QUERY);
			bar.setTitle("Search Result for " + "'" + query + "'");
			new Search().execute();
		}

	}

	private void fillStuff(String book) {
		c.moveToFirst();
		if (!c.isAfterLast()) {

			do {
				String s = c.getString(c.getColumnIndex("verse"));
				// txtQuery.setText(s);
				String[] ss = s.split("\n\n");
				for (String a : ss) {

					if (a.toLowerCase(Locale.getDefault()).contains(
							query.toLowerCase(Locale.getDefault()))) {
						a = book + "\n" + a;
						list.add(a);

					}
				}

			} while (c.moveToNext());
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// database.close();
	}

	private class Search extends AsyncTask<Void, Void, Void> {

		private ProgressDialog PD;

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			performQuery();
			closeThings();
			return null;
		}

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			PD = new ProgressDialog(SearchResultsActivity.this);
			PD.setTitle("Please Wait..");
			PD.setMessage("Loading...");
			PD.setCancelable(false);
			PD.show();

		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			fillMyList();
			PD.dismiss();

		}
	}

	public void fillMyList() {
		// TODO Auto-generated method stub
		adapter = new ArrayAdapter<String>(getBaseContext(),
				android.R.layout.simple_list_item_1, list) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				View v = super.getView(position, convertView, parent);
				TextView tv = (TextView) v.findViewById(android.R.id.text1);
				tv.setTextColor(Color.parseColor(list_textcolor));
				String item = adapter.getItem(position);
					tv.setText(highlight(query, item));

				return v;
			}

		};
		txtQuery.setAdapter(adapter);

	}

	public void performQuery() {
		// TODO Auto-generated method stub
		String[] db = { "newtestament.sqlite3", "oldtestament.sqlite3" };
		String[] old = getResources().getStringArray(R.array.oldT);
		String[] newT = getResources().getStringArray(R.array.newT);
		for (String dbs : db) {
			helper = new SpiriteMealDbOpenHelper(getBaseContext(), dbs);
			database = helper.openDataBase();
			if (dbs.equals("newtestament.sqlite3")) {
				for (String newt : newT) {
					String book = newt;
					newt = newt.replace(" ", "");
					if (newt.startsWith("1")) {
						newt = newt.replace("1", "first_");
					} else if (newt.startsWith("2")) {
						newt = newt.replace("2", "second_");
					} else if (newt.startsWith("3")) {
						newt = newt.replace("3", "third_");
					}
					select = "select * from " + newt + " where verse like '%"
							+ query + "%';";
					c = database.rawQuery(select, null);
					fillStuff(book);
				}
				database.close();
				c.close();
			} else if (dbs.equals("oldtestament.sqlite3")) {
				for (String oldt : old) {
					String book = oldt;
					oldt = oldt.replace(" ", "");
					if (oldt.startsWith("1")) {
						oldt = oldt.replace("1", "first_");
					} else if (oldt.startsWith("2")) {
						oldt = oldt.replace("2", "second_");
					} else if (oldt.startsWith("3")) {
						oldt = oldt.replace("3", "third_");
					}
					select = "select * from " + oldt + " where verse like '%"
							+ query + "%';";
					c = database.rawQuery(select, null);
					fillStuff(book);
				}

			}
		}

	}

	public void closeThings() {
		// TODO Auto-generated method stub
		c.close();
		database.close();
	}

	public static CharSequence highlight(String search, String originalText) {
	    // ignore case and accents
	    // the same thing should have been done for the search text
		String normalizedText = Normalizer
				.normalize(originalText, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
				.toLowerCase(Locale.getDefault());

	    int start = normalizedText.indexOf(search);
	    if (start < 0) {
	        // not found, nothing to to
	        return originalText;
	    } else {
	        // highlight each appearance in the original text
	        // while searching in normalized text
	        Spannable highlighted = new SpannableString(originalText);
	        while (start >= 0) {
	            int spanStart = Math.min(start, originalText.length());
	            int spanEnd = Math.min(start + search.length(), originalText.length());

				highlighted.setSpan(new ForegroundColorSpan(Color.RED),
						spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

	            start = normalizedText.indexOf(search, spanEnd);
	        }

	        return highlighted;
	    }
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		String item = adapter.getItem(position);
		String[] arr = item.split("\n");
		
			// sf.subSequence(0, 1);
		String verse = arr[0];
		verse = verse.replace(" ",	 "");
		if (verse.startsWith("1")) {
			verse = verse.replace("1", "first_");
		} else if (verse.startsWith("2")) {
			verse = verse.replace("2", "second_");
		} else if (verse.startsWith("3")) {
			verse = verse.replace("3", "third_");
		}
			String iterate = arr[1];
			iterate = iterate.subSequence(0, 2).toString();
			 if(iterate.endsWith(":"))
				 iterate = iterate.replace(":", "");
			 Intent intent = new Intent(SearchResultsActivity.this, MainActivity.class);
			 MainActivity MA = new MainActivity();
			 MA.loadChapterContents(Integer.parseInt(iterate),verse);
			 startActivity(intent);
			Toast.makeText(getBaseContext(),iterate ,
					Toast.LENGTH_LONG).show();
		
	}
}


