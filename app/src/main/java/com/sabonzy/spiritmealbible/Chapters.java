package com.sabonzy.spiritmealbible;

import java.util.ArrayList;
import java.util.Locale;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sabonzy.tabadapter.ArrayHelper;

public class Chapters extends Fragment {


	GridView chapter;
	private String Books;
	private ArrayAdapter<String> adapter;
	private ArrayHelper arrayHelper;
	private ArrayList<String> list;
	private String DB;
	private String background_color;
	private String list_textcolor;
	private ArrayHelper myColor;
	private ArrayList<String> colorList;
	LinearLayout layout;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.chapters, container, false);
		chapter = (GridView) v.findViewById(R.id.gridView1);
		layout = (LinearLayout) v.findViewById(R.id.chapter);
		arrayHelper = new ArrayHelper(getActivity());
		list = new ArrayList<String>();
		myColor = new ArrayHelper(getActivity());
		colorList = new ArrayList<String>();
		colorList = myColor.getColor("color");
		background_color = colorList.get(0);
		list_textcolor = colorList.get(1);
		layout.setBackgroundColor(Color.parseColor(background_color));
		chapter.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				String TabOfGameFragment = ((TabActivity) getActivity())
						.getTabFragmentB();

				VerseNumber fragmentB = (VerseNumber) getActivity()
						.getSupportFragmentManager().findFragmentByTag(
								TabOfGameFragment);

				String data = arg0.getItemAtPosition(pos).toString();
				
				fragmentB.setUpVerseNumbers(Books, pos);
				getActivity().getActionBar().setSelectedNavigationItem(1);
				int count = chapter.getCount();
				String counts = String.valueOf(count);

				String[] spList = { DB, Books, data, counts };
				for (String a : spList) {
					list.add(a);
				}
				arrayHelper.saveArray("dbname", list);
			}
		});

		Bundle b = getActivity().getIntent().getExtras();
		Books = b.getString("chapter");
		DB = b.getString("dbname");

		getActivity().getActionBar().setTitle(Books);
		LoadChapters();
		return v;
	}

	private void LoadChapters() {
		String checkBook = Books.toLowerCase(Locale.ENGLISH);
		if (checkBook.contains("matthew")) {

			setChapterNumber(28);
		} else if (checkBook.contains("mark")) {

			setChapterNumber(16);
		} else if (checkBook.contains("luke")) {

			setChapterNumber(24);
		} else if (checkBook.equalsIgnoreCase("john")) {

			setChapterNumber(21);
		} else if (checkBook.contains("acts")) {

			setChapterNumber(28);
		} else if (checkBook.contains("romans")) {

			setChapterNumber(16);
		} else if (checkBook.contains("1 corinthians")) {

			setChapterNumber(16);
		} else if (checkBook.contains("2 corinthians")) {

			setChapterNumber(13);
		} else if (checkBook.contains("galatians")) {

			setChapterNumber(6);
		} else if (checkBook.contains("ephesians")) {

			setChapterNumber(6);
		} else if (checkBook.contains("philippians")) {

			setChapterNumber(4);
		} else if (checkBook.contains("colossians")) {

			setChapterNumber(4);
		} else if (checkBook.contains("1 thessalonians")) {

			setChapterNumber(5);
		} else if (checkBook.contains("2 thessalonians")) {

			setChapterNumber(3);
		} else if (checkBook.contains("1 timothy")) {

			setChapterNumber(6);
		} else if (checkBook.contains("2 timothy")) {

			setChapterNumber(4);
		} else if (checkBook.contains("titus")) {

			setChapterNumber(3);
		} else if (checkBook.contains("philemon")) {

			setChapterNumber(1);
		} else if (checkBook.contains("hebrews")) {

			setChapterNumber(13);
		} else if (checkBook.contains("james")) {

			setChapterNumber(5);
		} else if (checkBook.contains("1 peter")) {

			setChapterNumber(5);
		} else if (checkBook.contains("2 peter")) {

			setChapterNumber(3);
		} else if (checkBook.contains("1 john")) {

			setChapterNumber(5);
		} else if (checkBook.contains("2 john")) {

			setChapterNumber(1);
		} else if (checkBook.contains("3 john")) {

			setChapterNumber(1);
		} else if (checkBook.contains("jude")) {

			setChapterNumber(1);
		} else if (checkBook.contains("revelation")) {
			setChapterNumber(22);
		} else if (checkBook.contains("genesis")) {
			setChapterNumber(50);
		} else if (checkBook.contains("exodus")) {
			setChapterNumber(40);
		} else if (checkBook.contains("leviticus")) {
			setChapterNumber(26);
		} else if (checkBook.contains("numbers")) {
			setChapterNumber(36);
		} else if (checkBook.contains("deuteronomy")) {
			setChapterNumber(34);
		} else if (checkBook.contains("joshua")) {
			setChapterNumber(24);
		} else if (checkBook.contains("judges")) {
			setChapterNumber(21);
		} else if (checkBook.contains("ruth")) {

			setChapterNumber(4);
		} else if (checkBook.contains("1 samuel")) {

			setChapterNumber(31);
		} else if (checkBook.contains("2 samuel")) {

			setChapterNumber(24);
		} else if (checkBook.contains("1 kings")) {

			setChapterNumber(22);
		} else if (checkBook.contains("2 kings")) {

			setChapterNumber(25);
		} else if (checkBook.contains("1 chronicles")) {

			setChapterNumber(29);
		} else if (checkBook.contains("2 chronicles")) {

			setChapterNumber(36);
		} else if (checkBook.contains("ezra")) {

			setChapterNumber(10);
		} else if (checkBook.contains("nehemiah")) {

			setChapterNumber(13);
		} else if (checkBook.contains("esther")) {

			setChapterNumber(10);
		} else if (checkBook.contains("job")) {

			setChapterNumber(42);
		} else if (checkBook.contains("psalms")) {

			setChapterNumber(150);
		} else if (checkBook.contains("proverbs")) {

			setChapterNumber(31);
		} else if (checkBook.contains("ecclesiastes")) {

			setChapterNumber(12);
		} else if (checkBook.contains("song of solomon")) {
			setChapterNumber(8);

		} else if (checkBook.contains("isaiah")) {

			setChapterNumber(66);
		} else if (checkBook.contains("jeremiah")) {

			setChapterNumber(52);
		} else if (checkBook.contains("lamentations")) {

			setChapterNumber(5);
		} else if (checkBook.contains("ezekiel")) {

			setChapterNumber(48);
		} else if (checkBook.contains("daniel")) {

			setChapterNumber(12);
		} else if (checkBook.contains("hosea")) {

			setChapterNumber(14);
		} else if (checkBook.contains("joel")) {

			setChapterNumber(3);
		} else if (checkBook.contains("amos")) {

			setChapterNumber(9);
		} else if (checkBook.contains("obadiah")) {

			setChapterNumber(1);
		} else if (checkBook.contains("jonah")) {

			setChapterNumber(4);
		} else if (checkBook.contains("micah")) {
			;
			setChapterNumber(7);
		} else if (checkBook.contains("nahum")) {

			setChapterNumber(3);
		} else if (checkBook.contains("habakkuk")) {

			setChapterNumber(3);
		} else if (checkBook.contains("zephaniah")) {

			setChapterNumber(3);
		} else if (checkBook.contains("haggai")) {

			setChapterNumber(2);
		} else if (checkBook.contains("zechariah")) {

			setChapterNumber(14);
		} else if (checkBook.contains("malachi")) {

			setChapterNumber(4);
		}

		chapter.setAdapter(adapter);
	}

	private void setChapterNumber(int verse) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= verse; i++) {
			String s = String.valueOf(i);
			list.add(s);
		}
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, list) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				View v = super.getView(position, convertView, parent);
				TextView tv = (TextView) v.findViewById(android.R.id.text1);
				tv.setTextColor(Color.parseColor(list_textcolor));
				return v;
			}

		};
		// return adapter;

	}
}
