package com.sabonzy.spiritmealbible;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Intent;
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

public class VerseNumber extends Fragment implements OnItemClickListener {
	private GridView chapter;
	// private String Books;

	ArrayHelper ah;
	String DB_Name;
	private int position;
	ArrayAdapter<String> adapter;
	private String background_color;
	private String list_textcolor;
	private ArrayHelper myColor;
	private ArrayList<String> colorList;
	LinearLayout layout;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.verse_number, container, false);
		chapter = (GridView) v.findViewById(R.id.gridView1);
		layout = (LinearLayout) v.findViewById(R.id.verse);
		String myTag = getTag();

		myColor = new ArrayHelper(getActivity());
		colorList = new ArrayList<String>();
		colorList = myColor.getColor("color");
		background_color = colorList.get(0);
		list_textcolor = colorList.get(1);
		layout.setBackgroundColor(Color.parseColor(background_color));

		((TabActivity) getActivity()).setTabFragmentB(myTag);
		ArrayHelper ha = new ArrayHelper(getActivity());
		ArrayList<String> list = new ArrayList<String>();
		list = ha.getVerseTab("versetab");

		setUpVerseNumbers(list.get(0), Integer.parseInt(list.get(1)));

		ah = new ArrayHelper(getActivity());
		chapter.setOnItemClickListener(this);
		return v;
	}

	public void setUpVerseNumbers(String data, int pos) {
		position = pos;
		getActivity().getActionBar().setTitle((data + " " + (position + 1)));
		String checkBook = data.toLowerCase(Locale.ENGLISH);
		if (checkBook.contains("matthew")) {
			switch (position) {
			case 0:
				setVerseNumber(25);
				break;
			case 1:
				setVerseNumber(23);
				break;
			case 2:
				setVerseNumber(17);
				break;
			case 3:
				setVerseNumber(25);
				break;
			case 4:
				setVerseNumber(48);
				break;
			case 5:
				setVerseNumber(34);
				break;
			case 6:
				setVerseNumber(29);
				break;
			case 7:
				setVerseNumber(34);
				break;
			case 8:
				setVerseNumber(38);
				break;
			case 9:
				setVerseNumber(42);
				break;
			case 10:
				setVerseNumber(30);
				break;
			case 11:
				setVerseNumber(50);
				break;
			case 12:
				setVerseNumber(58);
				break;
			case 13:
				setVerseNumber(36);
				break;
			case 14:
				setVerseNumber(39);
				break;
			case 15:
				setVerseNumber(28);
				break;
			case 16:
				setVerseNumber(27);
				break;
			case 17:
				setVerseNumber(35);
				break;
			case 18:
				setVerseNumber(30);
				break;
			case 19:
				setVerseNumber(34);
				break;
			case 20:
				setVerseNumber(46);
				break;
			case 21:
				setVerseNumber(46);
				break;
			case 22:
				setVerseNumber(39);
				break;
			case 23:
				setVerseNumber(51);
				break;
			case 24:
				setVerseNumber(46);
				break;
			case 25:
				setVerseNumber(75);
				break;
			case 26:
				setVerseNumber(66);
				break;
			case 27:
				setVerseNumber(20);
				break;
			}

		} else if (checkBook.contains("mark")) {
			switch (position) {
			case 0:
				setVerseNumber(45);
				break;
			case 1:
				setVerseNumber(28);
				break;
			case 2:
				setVerseNumber(35);
				break;
			case 3:
				setVerseNumber(41);
				break;
			case 4:
				setVerseNumber(43);
				break;
			case 5:
				setVerseNumber(56);
				break;
			case 6:
				setVerseNumber(37);
				break;
			case 7:
				setVerseNumber(38);
				break;
			case 8:
				setVerseNumber(50);
				break;
			case 9:
				setVerseNumber(52);
				break;
			case 10:
				setVerseNumber(33);
				break;
			case 11:
				setVerseNumber(44);
				break;
			case 12:
				setVerseNumber(37);
				break;
			case 13:
				setVerseNumber(72);
				break;
			case 14:
				setVerseNumber(47);
				break;
			case 15:
				setVerseNumber(20);
				break;

			}

		} else if (checkBook.contains("luke")) {
			switch (position) {
			case 0:
				setVerseNumber(80);
				break;
			case 1:
				setVerseNumber(52);
				break;
			case 2:
				setVerseNumber(38);
				break;
			case 3:
				setVerseNumber(44);
				break;
			case 4:
				setVerseNumber(39);
				break;
			case 5:
				setVerseNumber(49);
				break;
			case 6:
				setVerseNumber(50);
				break;
			case 7:
				setVerseNumber(56);
				break;
			case 8:
				setVerseNumber(62);
				break;
			case 9:
				setVerseNumber(42);
				break;
			case 10:
				setVerseNumber(54);
				break;
			case 11:
				setVerseNumber(59);
				break;
			case 12:
				setVerseNumber(35);
				break;
			case 13:
				setVerseNumber(35);
				break;
			case 14:
				setVerseNumber(32);
				break;
			case 15:
				setVerseNumber(31);
				break;
			case 16:
				setVerseNumber(37);
				break;
			case 17:
				setVerseNumber(43);
				break;
			case 18:
				setVerseNumber(48);
				break;
			case 19:
				setVerseNumber(47);
				break;
			case 20:
				setVerseNumber(38);
				break;
			case 21:
				setVerseNumber(71);
				break;
			case 22:
				setVerseNumber(56);
				break;
			case 23:
				setVerseNumber(53);
				break;
			}

		} else if (checkBook.equalsIgnoreCase("john")) {

			switch (position) {
			case 0:
				setVerseNumber(51);
				break;
			case 1:
				setVerseNumber(25);
				break;
			case 2:
				setVerseNumber(36);
				break;
			case 3:
				setVerseNumber(54);
				break;
			case 4:
				setVerseNumber(47);
				break;
			case 5:
				setVerseNumber(71);
				break;
			case 6:
				setVerseNumber(53);
				break;
			case 7:
				setVerseNumber(59);
				break;
			case 8:
				setVerseNumber(41);
				break;
			case 9:
				setVerseNumber(42);
				break;
			case 10:
				setVerseNumber(57);
				break;
			case 11:
				setVerseNumber(50);
				break;
			case 12:
				setVerseNumber(38);
				break;
			case 13:
				setVerseNumber(31);
				break;
			case 14:
				setVerseNumber(27);
				break;
			case 15:
				setVerseNumber(33);
				break;
			case 16:
				setVerseNumber(26);
				break;
			case 17:
				setVerseNumber(40);
				break;
			case 18:
				setVerseNumber(42);
				break;
			case 19:
				setVerseNumber(31);
				break;
			case 20:
				setVerseNumber(25);
				break;
			}
		} else if (checkBook.contains("acts")) {
			switch (position) {
			case 0:
				setVerseNumber(26);
				break;
			case 1:
				setVerseNumber(47);
				break;
			case 2:
				setVerseNumber(26);
				break;
			case 3:
				setVerseNumber(37);
				break;
			case 4:
				setVerseNumber(42);
				break;
			case 5:
				setVerseNumber(15);
				break;
			case 6:
				setVerseNumber(60);
				break;
			case 7:
				setVerseNumber(40);
				break;
			case 8:
				setVerseNumber(43);
				break;
			case 9:
				setVerseNumber(48);
				break;
			case 10:
				setVerseNumber(30);
				break;
			case 11:
				setVerseNumber(25);
				break;
			case 12:
				setVerseNumber(52);
				break;
			case 13:
				setVerseNumber(28);
				break;
			case 14:
				setVerseNumber(41);
				break;
			case 15:
				setVerseNumber(40);
				break;
			case 16:
				setVerseNumber(34);
				break;
			case 17:
				setVerseNumber(28);
				break;
			case 18:
				setVerseNumber(41);
				break;
			case 19:
				setVerseNumber(38);
				break;
			case 20:
				setVerseNumber(40);
				break;
			case 21:
				setVerseNumber(30);
				break;
			case 22:
				setVerseNumber(35);
				break;
			case 23:
				setVerseNumber(27);
				break;
			case 24:
				setVerseNumber(27);
				break;
			case 25:
				setVerseNumber(32);
				break;
			case 26:
				setVerseNumber(44);
				break;
			case 27:
				setVerseNumber(31);
				break;
			}

		} else if (checkBook.contains("romans")) {
			switch (position) {
			case 0:
				setVerseNumber(32);
				break;

			case 1:
				setVerseNumber(29);
				break;

			case 2:
				setVerseNumber(31);
				break;

			case 3:
				setVerseNumber(25);
				break;

			case 4:
				setVerseNumber(21);
				break;

			case 5:
				setVerseNumber(23);
				break;

			case 6:
				setVerseNumber(25);
				break;

			case 7:
				setVerseNumber(39);
				break;

			case 8:
				setVerseNumber(33);
				break;
			case 9:
				setVerseNumber(21);
				break;

			case 10:
				setVerseNumber(36);
				break;

			case 11:
				setVerseNumber(21);
				break;
			case 12:
				setVerseNumber(14);
				break;
			case 13:
				setVerseNumber(23);
				break;
			case 14:
				setVerseNumber(33);
				break;
			case 15:
				setVerseNumber(27);
				break;

			}

		} else if (checkBook.contains("1 corinthians")) {

			switch (position) {
			case 0:
				setVerseNumber(31);
				break;

			case 1:
				setVerseNumber(16);
				break;

			case 2:
				setVerseNumber(23);
				break;

			case 3:
				setVerseNumber(21);
				break;

			case 4:
				setVerseNumber(13);
				break;

			case 5:
				setVerseNumber(20);
				break;

			case 6:
				setVerseNumber(40);
				break;

			case 7:
				setVerseNumber(13);
				break;

			case 8:
				setVerseNumber(27);
				break;
			case 9:
				setVerseNumber(33);
				break;

			case 10:
				setVerseNumber(34);
				break;

			case 11:
				setVerseNumber(31);
				break;
			case 12:
				setVerseNumber(13);
				break;
			case 13:
				setVerseNumber(40);
				break;
			case 14:
				setVerseNumber(58);
				break;
			case 15:
				setVerseNumber(24);
				break;

			}
		} else if (checkBook.contains("2 corinthians")) {
			switch (position) {
			case 0:
				setVerseNumber(24);
				break;

			case 1:
				setVerseNumber(17);
				break;

			case 2:
				setVerseNumber(18);
				break;

			case 3:
				setVerseNumber(18);
				break;

			case 4:
				setVerseNumber(21);
				break;

			case 5:
				setVerseNumber(18);
				break;

			case 6:
				setVerseNumber(16);
				break;

			case 7:
				setVerseNumber(24);
				break;

			case 8:
				setVerseNumber(15);
				break;
			case 9:
				setVerseNumber(18);
				break;

			case 10:
				setVerseNumber(33);
				break;

			case 11:
				setVerseNumber(21);
				break;
			case 12:
				setVerseNumber(14);
				break;

			}
		} else if (checkBook.contains("galatians")) {
			switch (position) {
			case 0:
				setVerseNumber(24);
				break;

			case 1:
				setVerseNumber(21);
				break;

			case 2:
				setVerseNumber(29);
				break;

			case 3:
				setVerseNumber(31);
				break;

			case 4:
				setVerseNumber(26);
				break;

			case 5:
				setVerseNumber(18);
				break;

			}

		} else if (checkBook.contains("ephesians")) {
			switch (position) {
			case 0:
				setVerseNumber(23);
				break;

			case 1:
				setVerseNumber(22);
				break;

			case 2:
				setVerseNumber(21);
				break;

			case 3:
				setVerseNumber(32);
				break;

			case 4:
				setVerseNumber(33);
				break;

			case 5:
				setVerseNumber(24);
				break;

			}

		} else if (checkBook.contains("philippians")) {
			switch (position) {
			case 0:
				setVerseNumber(30);
				break;

			case 1:
				setVerseNumber(30);
				break;

			case 2:
				setVerseNumber(21);
				break;

			case 3:
				setVerseNumber(23);
				break;

			}

		} else if (checkBook.contains("colossians")) {
			switch (position) {
			case 0:
				setVerseNumber(29);
				break;

			case 1:
				setVerseNumber(23);
				break;

			case 2:
				setVerseNumber(25);
				break;

			case 3:
				setVerseNumber(18);
				break;

			}

		} else if (checkBook.contains("1 thessalonians")) {
			switch (position) {
			case 0:
				setVerseNumber(10);
				break;

			case 1:
				setVerseNumber(20);
				break;

			case 2:
				setVerseNumber(13);
				break;

			case 3:
				setVerseNumber(18);
				break;

			case 4:
				setVerseNumber(28);
				break;

			}

		} else if (checkBook.contains("2 thessalonians")) {
			switch (position) {
			case 0:
				setVerseNumber(12);
				break;

			case 1:
				setVerseNumber(17);
				break;

			case 2:
				setVerseNumber(18);
				break;

			}

		} else if (checkBook.contains("1 timothy")) {

			switch (position) {
			case 0:
				setVerseNumber(20);
				break;

			case 1:
				setVerseNumber(15);
				break;

			case 2:
				setVerseNumber(16);
				break;

			case 3:
				setVerseNumber(16);
				break;

			case 4:
				setVerseNumber(25);
				break;

			case 5:
				setVerseNumber(21);
				break;

			}
		} else if (checkBook.contains("2 timothy")) {
			switch (position) {
			case 0:
				setVerseNumber(18);
				break;

			case 1:
				setVerseNumber(26);
				break;

			case 2:
				setVerseNumber(17);
				break;

			case 3:
				setVerseNumber(22);
				break;

			}

		} else if (checkBook.contains("titus")) {
			switch (position) {
			case 0:
				setVerseNumber(16);
				break;

			case 1:
				setVerseNumber(15);
				break;

			case 2:
				setVerseNumber(15);
				break;

			}

		} else if (checkBook.contains("philemon")) {
			switch (position) {
			case 0:
				setVerseNumber(25);
				break;
			}

		} else if (checkBook.contains("hebrews")) {
			switch (position) {
			case 0:
				setVerseNumber(14);
				break;

			case 1:
				setVerseNumber(18);
				break;

			case 2:
				setVerseNumber(19);
				break;

			case 3:
				setVerseNumber(16);
				break;

			case 4:
				setVerseNumber(14);
				break;

			case 5:
				setVerseNumber(20);
				break;
			case 6:
				setVerseNumber(28);
				break;
			case 7:
				setVerseNumber(13);
				break;
			case 8:
				setVerseNumber(28);
				break;
			case 9:
				setVerseNumber(39);
				break;
			case 10:
				setVerseNumber(40);
				break;
			case 11:
				setVerseNumber(29);
				break;
			case 12:
				setVerseNumber(25);
				break;

			}
		} else if (checkBook.contains("james")) {
			switch (position) {
			case 0:
				setVerseNumber(27);
				break;

			case 1:
				setVerseNumber(26);
				break;

			case 2:
				setVerseNumber(18);
				break;

			case 3:
				setVerseNumber(17);
				break;

			case 4:
				setVerseNumber(20);
				break;

			}

		} else if (checkBook.contains("1 peter")) {
			switch (position) {
			case 0:
				setVerseNumber(25);
				break;

			case 1:
				setVerseNumber(25);
				break;

			case 2:
				setVerseNumber(22);
				break;

			case 3:
				setVerseNumber(19);
				break;

			case 4:
				setVerseNumber(14);
				break;


			}

		} else if (checkBook.contains("2 peter")) {
			switch (position) {
			case 0:
				setVerseNumber(21);
				break;

			case 1:
				setVerseNumber(22);
				break;

			case 2:
				setVerseNumber(18);
				break;

			}

		} else if (checkBook.contains("1 john")) {

			switch (position) {
			case 0:
				setVerseNumber(10);
				break;

			case 1:
				setVerseNumber(29);
				break;

			case 2:
				setVerseNumber(24);
				break;

			case 3:
				setVerseNumber(21);
				break;

			case 4:
				setVerseNumber(21);
				break;

			}
		} else if (checkBook.contains("2 john")) {
			switch (position) {
			case 0:
				setVerseNumber(13);
				break;
			}

		} else if (checkBook.contains("3 john")) {
			switch (position) {
			case 0:
				setVerseNumber(14);
				break;
			}

		} else if (checkBook.contains("jude")) {
			switch (position) {
			case 0:
				setVerseNumber(25);
				break;
			}

		} else if (checkBook.contains("revelation")) {
			switch (position) {
			case 0:
				setVerseNumber(20);
				break;

			case 1:
				setVerseNumber(29);
				break;

			case 2:
				setVerseNumber(22);
				break;

			case 3:
				setVerseNumber(11);
				break;

			case 4:
				setVerseNumber(14);
				break;

			case 5:
				setVerseNumber(17);
				break;
			case 6:
				setVerseNumber(17);
				break;
			case 7:
				setVerseNumber(13);
				break;
			case 8:
				setVerseNumber(21);
				break;
			case 9:
				setVerseNumber(11);
				break;
			case 10:
				setVerseNumber(19);
				break;
			case 11:
				setVerseNumber(17);
				break;
			case 12:
				setVerseNumber(18);
				break;
			case 13:
				setVerseNumber(20);
				break;
			case 14:
				setVerseNumber(8);
				break;
			case 15:
				setVerseNumber(21);
				break;
			case 16:
				setVerseNumber(18);
				break;
			case 17:
				setVerseNumber(24);
				break;
			case 18:
				setVerseNumber(21);
				break;
			case 19:
				setVerseNumber(15);
				break;
			case 20:
				setVerseNumber(27);
				break;
			case 21:
				setVerseNumber(21);
				break;

			}

		} else if (checkBook.contains("genesis")) {
			switch (position) {
			case 0:
				setVerseNumber(31);
				break;

			case 1:
				setVerseNumber(25);
				break;

			case 2:
				setVerseNumber(25);
				break;

			case 3:
				setVerseNumber(26);
				break;

			case 4:
				setVerseNumber(32);
				break;

			case 5:
				setVerseNumber(22);
				break;
			case 6:
				setVerseNumber(24);
				break;
			case 7:
				setVerseNumber(22);
				break;
			case 8:
				setVerseNumber(29);
				break;
			case 9:
				setVerseNumber(32);
				break;
			case 10:
				setVerseNumber(32);
				break;
			case 11:
				setVerseNumber(20);
				break;
			case 12:
				setVerseNumber(18);
				break;
			case 13:
				setVerseNumber(24);
				break;
			case 14:
				setVerseNumber(21);
				break;
			case 15:
				setVerseNumber(16);
				break;
			case 16:
				setVerseNumber(27);
				break;
			case 17:
				setVerseNumber(33);
				break;
			case 18:
				setVerseNumber(38);
				break;
			case 19:
				setVerseNumber(18);
				break;
			case 20:
				setVerseNumber(34);
				break;
			case 21:
				setVerseNumber(24);
				break;
			case 22:
				setVerseNumber(20);
				break;
			case 23:
				setVerseNumber(67);
				break;
			case 24:
				setVerseNumber(34);
				break;
			case 25:
				setVerseNumber(35);
				break;
			case 26:
				setVerseNumber(46);
				break;
			case 27:
				setVerseNumber(22);
				break;
			case 28:
				setVerseNumber(35);
				break;
			case 29:
				setVerseNumber(43);
				break;
			case 30:
				setVerseNumber(55);
				break;
			case 31:
				setVerseNumber(32);
				break;
			case 32:
				setVerseNumber(20);
				break;
			case 33:
				setVerseNumber(31);
				break;
			case 34:
				setVerseNumber(29);
				break;
			case 35:
				setVerseNumber(43);
				break;
			case 36:
				setVerseNumber(36);
				break;
			case 37:
				setVerseNumber(30);
				break;
			case 38:
				setVerseNumber(23);
				break;
			case 39:
				setVerseNumber(23);
				break;
			case 40:
				setVerseNumber(57);
				break;
			case 41:
				setVerseNumber(38);
				break;
			case 42:
				setVerseNumber(34);
				break;
			case 43:
				setVerseNumber(34);
				break;
			case 44:
				setVerseNumber(28);
				break;
			case 45:
				setVerseNumber(34);
				break;
			case 46:
				setVerseNumber(31);
				break;
			case 47:
				setVerseNumber(22);
				break;
			case 48:
				setVerseNumber(33);
				break;
			case 49:
				setVerseNumber(26);
				break;

			}

		} else if (checkBook.contains("exodus")) {
			switch (position) {
			case 0:
				setVerseNumber(22);
				break;

			case 1:
				setVerseNumber(25);
				break;

			case 2:
				setVerseNumber(22);
				break;

			case 3:
				setVerseNumber(31);
				break;

			case 4:
				setVerseNumber(23);
				break;

			case 5:
				setVerseNumber(30);
				break;
			case 6:
				setVerseNumber(25);
				break;
			case 7:
				setVerseNumber(32);
				break;
			case 8:
				setVerseNumber(35);
				break;
			case 9:
				setVerseNumber(29);
				break;
			case 10:
				setVerseNumber(10);
				break;
			case 11:
				setVerseNumber(51);
				break;
			case 12:
				setVerseNumber(22);
				break;
			case 13:
				setVerseNumber(31);
				break;
			case 14:
				setVerseNumber(27);
				break;
			case 15:
				setVerseNumber(36);
				break;
			case 16:
				setVerseNumber(16);
				break;
			case 17:
				setVerseNumber(27);
				break;
			case 18:
				setVerseNumber(25);
				break;
			case 19:
				setVerseNumber(26);
				break;
			case 20:
				setVerseNumber(36);
				break;
			case 21:
				setVerseNumber(31);
				break;
			case 22:
				setVerseNumber(33);
				break;
			case 23:
				setVerseNumber(18);
				break;
			case 24:
				setVerseNumber(40);
				break;
			case 25:
				setVerseNumber(37);
				break;
			case 26:
				setVerseNumber(21);
				break;
			case 27:
				setVerseNumber(43);
				break;
			case 28:
				setVerseNumber(46);
				break;
			case 29:
				setVerseNumber(38);
				break;
			case 30:
				setVerseNumber(18);
				break;
			case 31:
				setVerseNumber(35);
				break;
			case 32:
				setVerseNumber(23);
				break;
			case 33:
				setVerseNumber(35);
				break;
			case 34:
				setVerseNumber(35);
				break;
			case 35:
				setVerseNumber(38);
				break;
			case 36:
				setVerseNumber(29);
				break;
			case 37:
				setVerseNumber(31);
				break;
			case 38:
				setVerseNumber(43);
				break;
			case 39:
				setVerseNumber(38);
				break;

			}

		} else if (checkBook.contains("leviticus")) {
			switch (position) {
			case 0:
				setVerseNumber(17);
				break;

			case 1:
				setVerseNumber(16);
				break;

			case 2:
				setVerseNumber(17);
				break;

			case 3:
				setVerseNumber(35);
				break;

			case 4:
				setVerseNumber(19);
				break;

			case 5:
				setVerseNumber(30);
				break;
			case 6:
				setVerseNumber(38);
				break;
			case 7:
				setVerseNumber(36);
				break;
			case 8:
				setVerseNumber(24);
				break;
			case 9:
				setVerseNumber(20);
				break;
			case 10:
				setVerseNumber(47);
				break;
			case 11:
				setVerseNumber(8);
				break;
			case 12:
				setVerseNumber(59);
				break;
			case 13:
				setVerseNumber(57);
				break;
			case 14:
				setVerseNumber(33);
				break;
			case 15:
				setVerseNumber(34);
				break;
			case 16:
				setVerseNumber(16);
				break;
			case 17:
				setVerseNumber(30);
				break;
			case 18:
				setVerseNumber(37);
				break;
			case 19:
				setVerseNumber(27);
				break;
			case 20:
				setVerseNumber(24);
				break;
			case 21:
				setVerseNumber(33);
				break;
			case 22:
				setVerseNumber(44);
				break;
			case 23:
				setVerseNumber(23);
				break;
			case 24:
				setVerseNumber(55);
				break;
			case 25:
				setVerseNumber(46);
				break;
			case 26:
				setVerseNumber(34);
				break;

			}

		} else if (checkBook.contains("numbers")) {
			switch (position) {
			case 0:
				setVerseNumber(54);
				break;

			case 1:
				setVerseNumber(34);
				break;

			case 2:
				setVerseNumber(51);
				break;

			case 3:
				setVerseNumber(49);
				break;

			case 4:
				setVerseNumber(31);
				break;

			case 5:
				setVerseNumber(27);
				break;
			case 6:
				setVerseNumber(89);
				break;
			case 7:
				setVerseNumber(26);
				break;
			case 8:
				setVerseNumber(23);
				break;
			case 9:
				setVerseNumber(36);
				break;
			case 10:
				setVerseNumber(35);
				break;
			case 11:
				setVerseNumber(16);
				break;
			case 12:
				setVerseNumber(33);
				break;
			case 13:
				setVerseNumber(45);
				break;
			case 14:
				setVerseNumber(41);
				break;
			case 15:
				setVerseNumber(50);
				break;
			case 16:
				setVerseNumber(13);
				break;
			case 17:
				setVerseNumber(32);
				break;
			case 18:
				setVerseNumber(22);
				break;
			case 19:
				setVerseNumber(29);
				break;
			case 20:
				setVerseNumber(35);
				break;
			case 21:
				setVerseNumber(41);
				break;
			case 22:
				setVerseNumber(30);
				break;
			case 23:
				setVerseNumber(25);
				break;
			case 24:
				setVerseNumber(18);
				break;
			case 25:
				setVerseNumber(65);
				break;
			case 26:
				setVerseNumber(23);
				break;
			case 27:
				setVerseNumber(31);
				break;
			case 28:
				setVerseNumber(40);
				break;
			case 29:
				setVerseNumber(16);
				break;
			case 30:
				setVerseNumber(54);
				break;
			case 31:
				setVerseNumber(42);
				break;
			case 32:
				setVerseNumber(56);
				break;
			case 33:
				setVerseNumber(29);
				break;
			case 34:
				setVerseNumber(34);
				break;
			case 35:
				setVerseNumber(13);
				break;

			}

		} else if (checkBook.contains("deuteronomy")) {
			switch (position) {
			case 0:
				setVerseNumber(46);
				break;

			case 1:
				setVerseNumber(37);
				break;

			case 2:
				setVerseNumber(29);
				break;

			case 3:
				setVerseNumber(49);
				break;

			case 4:
				setVerseNumber(33);
				break;

			case 5:
				setVerseNumber(25);
				break;
			case 6:
				setVerseNumber(26);
				break;
			case 7:
				setVerseNumber(20);
				break;
			case 8:
				setVerseNumber(29);
				break;
			case 9:
				setVerseNumber(22);
				break;
			case 10:
				setVerseNumber(32);
				break;
			case 11:
				setVerseNumber(32);
				break;
			case 12:
				setVerseNumber(18);
				break;
			case 13:
				setVerseNumber(29);
				break;
			case 14:
				setVerseNumber(23);
				break;
			case 15:
				setVerseNumber(22);
				break;
			case 16:
				setVerseNumber(20);
				break;
			case 17:
				setVerseNumber(22);
				break;
			case 18:
				setVerseNumber(21);
				break;
			case 19:
				setVerseNumber(20);
				break;
			case 20:
				setVerseNumber(23);
				break;
			case 21:
				setVerseNumber(30);
				break;
			case 22:
				setVerseNumber(25);
				break;
			case 23:
				setVerseNumber(22);
				break;
			case 24:
				setVerseNumber(19);
				break;
			case 25:
				setVerseNumber(19);
				break;
			case 26:
				setVerseNumber(26);
				break;
			case 27:
				setVerseNumber(68);
				break;
			case 28:
				setVerseNumber(29);
				break;
			case 29:
				setVerseNumber(20);
				break;
			case 30:
				setVerseNumber(30);
				break;
			case 31:
				setVerseNumber(52);
				break;
			case 32:
				setVerseNumber(29);
				break;
			case 33:
				setVerseNumber(12);
				break;

			}

		} else if (checkBook.contains("joshua")) {
			switch (position) {
			case 0:
				setVerseNumber(18);
				break;

			case 1:
				setVerseNumber(24);
				break;

			case 2:
				setVerseNumber(17);
				break;

			case 3:
				setVerseNumber(24);
				break;

			case 4:
				setVerseNumber(15);
				break;

			case 5:
				setVerseNumber(27);
				break;
			case 6:
				setVerseNumber(26);
				break;
			case 7:
				setVerseNumber(35);
				break;
			case 8:
				setVerseNumber(27);
				break;
			case 9:
				setVerseNumber(43);
				break;
			case 10:
				setVerseNumber(23);
				break;
			case 11:
				setVerseNumber(24);
				break;
			case 12:
				setVerseNumber(33);
				break;
			case 13:
				setVerseNumber(15);
				break;
			case 14:
				setVerseNumber(63);
				break;
			case 15:
				setVerseNumber(10);
				break;
			case 16:
				setVerseNumber(18);
				break;
			case 17:
				setVerseNumber(28);
				break;
			case 18:
				setVerseNumber(51);
				break;
			case 19:
				setVerseNumber(9);
				break;
			case 20:
				setVerseNumber(45);
				break;
			case 21:
				setVerseNumber(34);
				break;
			case 22:
				setVerseNumber(16);
				break;
			case 23:
				setVerseNumber(33);
				break;

			}

		} else if (checkBook.contains("judges")) {
			switch (position) {
			case 0:
				setVerseNumber(36);
				break;

			case 1:
				setVerseNumber(23);
				break;

			case 2:
				setVerseNumber(31);
				break;

			case 3:
				setVerseNumber(24);
				break;

			case 4:
				setVerseNumber(31);
				break;

			case 5:
				setVerseNumber(40);
				break;
			case 6:
				setVerseNumber(25);
				break;
			case 7:
				setVerseNumber(35);
				break;
			case 8:
				setVerseNumber(57);
				break;
			case 9:
				setVerseNumber(18);
				break;
			case 10:
				setVerseNumber(40);
				break;
			case 11:
				setVerseNumber(15);
				break;
			case 12:
				setVerseNumber(25);
				break;
			case 13:
				setVerseNumber(20);
				break;
			case 14:
				setVerseNumber(20);
				break;
			case 15:
				setVerseNumber(31);
				break;
			case 16:
				setVerseNumber(13);
				break;
			case 17:
				setVerseNumber(31);
				break;
			case 18:
				setVerseNumber(30);
				break;
			case 19:
				setVerseNumber(48);
				break;
			case 20:
				setVerseNumber(25);
				break;

			}

		} else if (checkBook.contains("ruth")) {
			switch (position) {
			case 0:
				setVerseNumber(22);
				break;

			case 1:
				setVerseNumber(23);
				break;

			case 2:
				setVerseNumber(18);
				break;

			case 3:
				setVerseNumber(22);
				break;

			}

		} else if (checkBook.contains("1 samuel")) {
			switch (position) {
			case 0:
				setVerseNumber(28);
				break;

			case 1:
				setVerseNumber(36);
				break;

			case 2:
				setVerseNumber(21);
				break;

			case 3:
				setVerseNumber(22);
				break;

			case 4:
				setVerseNumber(12);
				break;

			case 5:
				setVerseNumber(21);
				break;
			case 6:
				setVerseNumber(17);
				break;
			case 7:
				setVerseNumber(22);
				break;
			case 8:
				setVerseNumber(27);
				break;
			case 9:
				setVerseNumber(27);
				break;
			case 10:
				setVerseNumber(15);
				break;
			case 11:
				setVerseNumber(25);
				break;
			case 12:
				setVerseNumber(23);
				break;
			case 13:
				setVerseNumber(52);
				break;
			case 14:
				setVerseNumber(35);
				break;
			case 15:
				setVerseNumber(23);
				break;
			case 16:
				setVerseNumber(58);
				break;
			case 17:
				setVerseNumber(30);
				break;
			case 18:
				setVerseNumber(24);
				break;
			case 19:
				setVerseNumber(24);
				break;
			case 20:
				setVerseNumber(15);
				break;
			case 21:
				setVerseNumber(23);
				break;
			case 22:
				setVerseNumber(29);
				break;
			case 23:
				setVerseNumber(22);
				break;
			case 24:
				setVerseNumber(44);
				break;
			case 25:
				setVerseNumber(25);
				break;
			case 26:
				setVerseNumber(12);
				break;
			case 27:
				setVerseNumber(25);
				break;
			case 28:
				setVerseNumber(11);
				break;
			case 29:
				setVerseNumber(31);
				break;
			case 30:
				setVerseNumber(13);
				break;

			}

		} else if (checkBook.contains("2 samuel")) {
			switch (position) {
			case 0:
				setVerseNumber(27);
				break;

			case 1:
				setVerseNumber(32);
				break;

			case 2:
				setVerseNumber(39);
				break;

			case 3:
				setVerseNumber(12);
				break;

			case 4:
				setVerseNumber(25);
				break;

			case 5:
				setVerseNumber(23);
				break;
			case 6:
				setVerseNumber(29);
				break;
			case 7:
				setVerseNumber(18);
				break;
			case 8:
				setVerseNumber(13);
				break;
			case 9:
				setVerseNumber(19);
				break;
			case 10:
				setVerseNumber(27);
				break;
			case 11:
				setVerseNumber(31);
				break;
			case 12:
				setVerseNumber(39);
				break;
			case 13:
				setVerseNumber(33);
				break;
			case 14:
				setVerseNumber(37);
				break;
			case 15:
				setVerseNumber(23);
				break;
			case 16:
				setVerseNumber(29);
				break;
			case 17:
				setVerseNumber(33);
				break;
			case 18:
				setVerseNumber(43);
				break;
			case 19:
				setVerseNumber(26);
				break;
			case 20:
				setVerseNumber(22);
				break;
			case 21:
				setVerseNumber(51);
				break;
			case 22:
				setVerseNumber(39);
				break;
			case 23:
				setVerseNumber(25);
				break;

			}

		} else if (checkBook.contains("1 kings")) {
			switch (position) {
			case 0:
				setVerseNumber(53);
				break;

			case 1:
				setVerseNumber(46);
				break;

			case 2:
				setVerseNumber(28);
				break;

			case 3:
				setVerseNumber(34);
				break;

			case 4:
				setVerseNumber(18);
				break;

			case 5:
				setVerseNumber(38);
				break;
			case 6:
				setVerseNumber(51);
				break;
			case 7:
				setVerseNumber(66);
				break;
			case 8:
				setVerseNumber(28);
				break;
			case 9:
				setVerseNumber(29);
				break;
			case 10:
				setVerseNumber(43);
				break;
			case 11:
				setVerseNumber(33);
				break;
			case 12:
				setVerseNumber(34);
				break;
			case 13:
				setVerseNumber(31);
				break;
			case 14:
				setVerseNumber(34);
				break;
			case 15:
				setVerseNumber(34);
				break;
			case 16:
				setVerseNumber(24);
				break;
			case 17:
				setVerseNumber(46);
				break;
			case 18:
				setVerseNumber(21);
				break;
			case 19:
				setVerseNumber(43);
				break;
			case 20:
				setVerseNumber(29);
				break;
			case 21:
				setVerseNumber(53);
				break;

			}


		} else if (checkBook.contains("2 kings")) {
			switch (position) {
			case 0:
				setVerseNumber(18);
				break;

			case 1:
				setVerseNumber(25);
				break;

			case 2:
				setVerseNumber(27);
				break;

			case 3:
				setVerseNumber(44);
				break;

			case 4:
				setVerseNumber(27);
				break;

			case 5:
				setVerseNumber(33);
				break;
			case 6:
				setVerseNumber(20);
				break;
			case 7:
				setVerseNumber(29);
				break;
			case 8:
				setVerseNumber(37);
				break;
			case 9:
				setVerseNumber(36);
				break;
			case 10:
				setVerseNumber(21);
				break;
			case 11:
				setVerseNumber(21);
				break;
			case 12:
				setVerseNumber(25);
				break;
			case 13:
				setVerseNumber(29);
				break;
			case 14:
				setVerseNumber(38);
				break;
			case 15:
				setVerseNumber(20);
				break;
			case 16:
				setVerseNumber(41);
				break;
			case 17:
				setVerseNumber(37);
				break;
			case 18:
				setVerseNumber(37);
				break;
			case 19:
				setVerseNumber(21);
				break;
			case 20:
				setVerseNumber(26);
				break;
			case 21:
				setVerseNumber(20);
				break;
			case 22:
				setVerseNumber(37);
				break;
			case 23:
				setVerseNumber(20);
				break;
			case 24:
				setVerseNumber(30);
				break;
			}


		} else if (checkBook.contains("1 chronicles")) {
			switch (position) {
			case 0:
				setVerseNumber(54);
				break;

			case 1:
				setVerseNumber(55);
				break;

			case 2:
				setVerseNumber(24);
				break;

			case 3:
				setVerseNumber(43);
				break;

			case 4:
				setVerseNumber(26);
				break;

			case 5:
				setVerseNumber(81);
				break;
			case 6:
				setVerseNumber(40);
				break;
			case 7:
				setVerseNumber(40);
				break;
			case 8:
				setVerseNumber(44);
				break;
			case 9:
				setVerseNumber(14);
				break;
			case 10:
				setVerseNumber(47);
				break;
			case 11:
				setVerseNumber(40);
				break;
			case 12:
				setVerseNumber(14);
				break;
			case 13:
				setVerseNumber(17);
				break;
			case 14:
				setVerseNumber(29);
				break;
			case 15:
				setVerseNumber(43);
				break;
			case 16:
				setVerseNumber(27);
				break;
			case 17:
				setVerseNumber(18);
				break;
			case 18:
				setVerseNumber(19);
				break;
			case 19:
				setVerseNumber(8);
				break;
			case 20:
				setVerseNumber(30);
				break;
			case 21:
				setVerseNumber(19);
				break;
			case 22:
				setVerseNumber(32);
				break;
			case 23:
				setVerseNumber(31);
				break;
			case 24:
				setVerseNumber(31);
				break;
			case 25:
				setVerseNumber(32);
				break;
			case 26:
				setVerseNumber(34);
				break;
			case 27:
				setVerseNumber(21);
				break;
			case 28:
				setVerseNumber(30);
				break;

			}


		} else if (checkBook.contains("2 chronicles")) {
			switch (position) {
			case 0:
				setVerseNumber(17);
				break;

			case 1:
				setVerseNumber(18);
				break;

			case 2:
				setVerseNumber(17);
				break;

			case 3:
				setVerseNumber(22);
				break;

			case 4:
				setVerseNumber(14);
				break;

			case 5:
				setVerseNumber(42);
				break;
			case 6:
				setVerseNumber(22);
				break;
			case 7:
				setVerseNumber(18);
				break;
			case 8:
				setVerseNumber(31);
				break;
			case 9:
				setVerseNumber(19);
				break;
			case 10:
				setVerseNumber(23);
				break;
			case 11:
				setVerseNumber(16);
				break;
			case 12:
				setVerseNumber(22);
				break;
			case 13:
				setVerseNumber(15);
				break;
			case 14:
				setVerseNumber(19);
				break;
			case 15:
				setVerseNumber(14);
				break;
			case 16:
				setVerseNumber(19);
				break;
			case 17:
				setVerseNumber(24);
				break;
			case 18:
				setVerseNumber(11);
				break;
			case 19:
				setVerseNumber(37);
				break;
			case 20:
				setVerseNumber(20);
				break;
			case 21:
				setVerseNumber(12);
				break;
			case 22:
				setVerseNumber(21);
				break;
			case 23:
				setVerseNumber(27);
				break;
			case 24:
				setVerseNumber(28);
				break;
			case 25:
				setVerseNumber(23);
				break;
			case 26:
				setVerseNumber(9);
				break;
			case 27:
				setVerseNumber(27);
				break;
			case 28:
				setVerseNumber(36);
				break;
			case 29:
				setVerseNumber(27);
				break;
			case 30:
				setVerseNumber(21);
				break;
			case 31:
				setVerseNumber(33);
				break;
			case 32:
				setVerseNumber(25);
				break;
			case 33:
				setVerseNumber(33);
				break;
			case 34:
				setVerseNumber(27);
				break;
			case 35:
				setVerseNumber(23);
				break;

			}
		} else if (checkBook.contains("ezra")) {
			switch (position) {
			case 0:
				setVerseNumber(11);
				break;

			case 1:
				setVerseNumber(70);
				break;

			case 2:
				setVerseNumber(13);
				break;

			case 3:
				setVerseNumber(24);
				break;

			case 4:
				setVerseNumber(17);
				break;

			case 5:
				setVerseNumber(22);
				break;
			case 6:
				setVerseNumber(28);
				break;
			case 7:
				setVerseNumber(36);
				break;
			case 8:
				setVerseNumber(15);
				break;
			case 9:
				setVerseNumber(44);
				break;
			}

		} else if (checkBook.contains("nehemiah")) {
			switch (position) {
			case 0:
				setVerseNumber(11);
				break;

			case 1:
				setVerseNumber(20);
				break;

			case 2:
				setVerseNumber(32);
				break;

			case 3:
				setVerseNumber(23);
				break;

			case 4:
				setVerseNumber(19);
				break;

			case 5:
				setVerseNumber(19);
				break;
			case 6:
				setVerseNumber(73);
				break;
			case 7:
				setVerseNumber(18);
				break;
			case 8:
				setVerseNumber(38);
				break;
			case 9:
				setVerseNumber(39);
				break;
			case 10:
				setVerseNumber(36);
				break;
			case 11:
				setVerseNumber(47);
				break;
			case 12:
				setVerseNumber(31);
				break;
			}

		} else if (checkBook.contains("esther")) {
			switch (position) {
			case 0:
				setVerseNumber(22);
				break;

			case 1:
				setVerseNumber(23);
				break;

			case 2:
				setVerseNumber(15);
				break;

			case 3:
				setVerseNumber(17);
				break;

			case 4:
				setVerseNumber(14);
				break;

			case 5:
				setVerseNumber(14);
				break;
			case 6:
				setVerseNumber(10);
				break;
			case 7:
				setVerseNumber(17);
				break;
			case 8:
				setVerseNumber(32);
				break;
			case 9:
				setVerseNumber(3);
				break;

			}

		} else if (checkBook.contains("job")) {
			switch (position) {
			case 0:
				setVerseNumber(22);
				break;

			case 1:
				setVerseNumber(13);
				break;

			case 2:
				setVerseNumber(26);
				break;

			case 3:
				setVerseNumber(21);
				break;

			case 4:
				setVerseNumber(27);
				break;

			case 5:
				setVerseNumber(30);
				break;
			case 6:
				setVerseNumber(21);
				break;
			case 7:
				setVerseNumber(22);
				break;
			case 8:
				setVerseNumber(35);
				break;
			case 9:
				setVerseNumber(22);
				break;
			case 10:
				setVerseNumber(20);
				break;
			case 11:
				setVerseNumber(25);
				break;
			case 12:
				setVerseNumber(28);
				break;

			case 13:
				setVerseNumber(22);
				break;

			case 14:
				setVerseNumber(35);
				break;

			case 15:
				setVerseNumber(22);
				break;

			case 16:
				setVerseNumber(16);
				break;

			case 17:
				setVerseNumber(21);
				break;

			case 18:
				setVerseNumber(29);
				break;
			case 19:
				setVerseNumber(29);
				break;
			case 20:
				setVerseNumber(34);
				break;
			case 21:
				setVerseNumber(30);
				break;
			case 22:
				setVerseNumber(17);
				break;
			case 23:
				setVerseNumber(25);
				break;
			case 24:
				setVerseNumber(6);
				break;
			case 25:
				setVerseNumber(14);
				break;
			case 26:
				setVerseNumber(23);
				break;

			case 27:
				setVerseNumber(28);
				break;

			case 28:
				setVerseNumber(25);
				break;

			case 29:
				setVerseNumber(31);
				break;

			case 30:
				setVerseNumber(40);
				break;

			case 31:
				setVerseNumber(22);
				break;
			case 32:
				setVerseNumber(33);
				break;
			case 33:
				setVerseNumber(37);
				break;
			case 34:
				setVerseNumber(16);
				break;
			case 35:
				setVerseNumber(33);
				break;
			case 36:
				setVerseNumber(24);
				break;
			case 37:
				setVerseNumber(41);
				break;
			case 38:
				setVerseNumber(30);
				break;
			case 39:
				setVerseNumber(24);
				break;

			case 40:
				setVerseNumber(34);
				break;

			case 41:
				setVerseNumber(17);
				break;

			}

		} else if (checkBook.contains("psalms")) {
			switch (position) {
			case 0:
				setVerseNumber(6);
				break;

			case 1:
				setVerseNumber(12);
				break;

			case 2:
				setVerseNumber(8);
				break;

			case 3:
				setVerseNumber(8);
				break;

			case 4:
				setVerseNumber(12);
				break;

			case 5:
				setVerseNumber(10);
				break;
			case 6:
				setVerseNumber(17);
				break;
			case 7:
				setVerseNumber(9);
				break;
			case 8:
				setVerseNumber(20);
				break;
			case 9:
				setVerseNumber(18);
				break;
			case 10:
				setVerseNumber(7);
				break;
			case 11:
				setVerseNumber(8);
				break;
			case 12:
				setVerseNumber(6);
				break;

			case 13:
				setVerseNumber(7);
				break;

			case 14:
				setVerseNumber(5);
				break;

			case 15:
				setVerseNumber(11);
				break;

			case 16:
				setVerseNumber(15);
				break;

			case 17:
				setVerseNumber(50);
				break;

			case 18:
				setVerseNumber(14);
				break;
			case 19:
				setVerseNumber(9);
				break;
			case 20:
				setVerseNumber(13);
				break;
			case 21:
				setVerseNumber(31);
				break;
			case 22:
				setVerseNumber(6);
				break;
			case 23:
				setVerseNumber(10);
				break;
			case 24:
				setVerseNumber(22);
				break;
			case 25:
				setVerseNumber(12);
				break;
			case 26:
				setVerseNumber(14);
				break;

			case 27:
				setVerseNumber(9);
				break;

			case 28:
				setVerseNumber(11);
				break;

			case 29:
				setVerseNumber(12);
				break;

			case 30:
				setVerseNumber(24);
				break;

			case 31:
				setVerseNumber(11);
				break;
			case 32:
				setVerseNumber(22);
				break;
			case 33:
				setVerseNumber(22);
				break;
			case 34:
				setVerseNumber(28);
				break;
			case 35:
				setVerseNumber(12);
				break;
			case 36:
				setVerseNumber(40);
				break;
			case 37:
				setVerseNumber(22);
				break;
			case 38:
				setVerseNumber(13);
				break;
			case 39:
				setVerseNumber(17);
				break;

			case 40:
				setVerseNumber(13);
				break;

			case 41:
				setVerseNumber(11);
				break;

			case 42:
				setVerseNumber(5);
				break;

			case 43:
				setVerseNumber(26);
				break;

			case 44:
				setVerseNumber(17);
				break;

			case 45:
				setVerseNumber(11);
				break;

			case 46:
				setVerseNumber(9);
				break;

			case 47:
				setVerseNumber(14);
				break;
			case 48:
				setVerseNumber(20);
				break;
			case 49:
				setVerseNumber(23);
				break;
			case 50:
				setVerseNumber(19);
				break;
			case 51:
				setVerseNumber(9);
				break;
			case 52:
				setVerseNumber(6);
				break;
			case 53:
				setVerseNumber(7);
				break;
			case 54:
				setVerseNumber(23);
				break;

			case 55:
				setVerseNumber(13);
				break;

			case 56:
				setVerseNumber(11);
				break;

			case 57:
				setVerseNumber(11);
				break;

			case 58:
				setVerseNumber(17);
				break;

			case 59:
				setVerseNumber(12);
				break;

			case 60:
				setVerseNumber(18);
				break;
			case 61:
				setVerseNumber(12);
				break;
			case 62:
				setVerseNumber(11);
				break;
			case 63:
				setVerseNumber(10);
				break;
			case 64:
				setVerseNumber(13);
				break;
			case 65:
				setVerseNumber(20);
				break;
			case 66:
				setVerseNumber(7);
				break;
			case 67:
				setVerseNumber(35);
				break;
			case 68:
				setVerseNumber(36);
				break;

			case 69:
				setVerseNumber(5);
				break;

			case 70:
				setVerseNumber(24);
				break;

			case 71:
				setVerseNumber(20);
				break;

			case 72:
				setVerseNumber(28);
				break;

			case 73:
				setVerseNumber(23);
				break;
			case 74:
				setVerseNumber(10);
				break;
			case 75:
				setVerseNumber(12);
				break;
			case 76:
				setVerseNumber(20);
				break;
			case 77:
				setVerseNumber(72);
				break;
			case 78:
				setVerseNumber(13);
				break;
			case 79:
				setVerseNumber(19);
				break;
			case 80:
				setVerseNumber(16);
				break;
			case 81:
				setVerseNumber(8);
				break;

			case 82:
				setVerseNumber(18);
				break;

			case 83:
				setVerseNumber(12);
				break;

			case 84:
				setVerseNumber(13);
				break;

			case 85:
				setVerseNumber(17);
				break;

			case 86:
				setVerseNumber(7);
				break;

			case 87:
				setVerseNumber(18);
				break;

			case 88:
				setVerseNumber(52);
				break;

			case 89:
				setVerseNumber(17);
				break;
			case 90:
				setVerseNumber(16);
				break;
			case 91:
				setVerseNumber(15);
				break;
			case 92:
				setVerseNumber(5);
				break;
			case 93:
				setVerseNumber(23);
				break;
			case 94:
				setVerseNumber(11);
				break;
			case 95:
				setVerseNumber(13);
				break;
			case 96:
				setVerseNumber(12);
				break;

			case 97:
				setVerseNumber(9);
				break;

			case 98:
				setVerseNumber(9);
				break;

			case 99:
				setVerseNumber(5);
				break;

			case 100:
				setVerseNumber(8);
				break;

			case 101:
				setVerseNumber(28);
				break;

			case 102:
				setVerseNumber(22);
				break;
			case 103:
				setVerseNumber(35);
				break;
			case 104:
				setVerseNumber(45);
				break;
			case 105:
				setVerseNumber(48);
				break;
			case 106:
				setVerseNumber(43);
				break;
			case 107:
				setVerseNumber(13);
				break;
			case 108:
				setVerseNumber(31);
				break;
			case 109:
				setVerseNumber(7);
				break;
			case 110:
				setVerseNumber(10);
				break;

			case 111:
				setVerseNumber(10);
				break;

			case 112:
				setVerseNumber(9);
				break;

			case 113:
				setVerseNumber(8);
				break;

			case 114:
				setVerseNumber(18);
				break;

			case 115:
				setVerseNumber(19);
				break;
			case 116:
				setVerseNumber(2);
				break;
			case 117:
				setVerseNumber(29);
				break;
			case 118:
				setVerseNumber(176);
				break;
			case 119:
				setVerseNumber(7);
				break;
			case 120:
				setVerseNumber(8);
				break;
			case 121:
				setVerseNumber(9);
				break;
			case 122:
				setVerseNumber(4);
				break;
			case 123:
				setVerseNumber(8);
				break;

			case 124:
				setVerseNumber(5);
				break;

			case 125:
				setVerseNumber(6);
				break;

			case 126:
				setVerseNumber(5);
				break;

			case 127:
				setVerseNumber(6);
				break;

			case 128:
				setVerseNumber(8);
				break;

			case 129:
				setVerseNumber(8);
				break;

			case 130:
				setVerseNumber(3);
				break;

			case 131:
				setVerseNumber(18);
				break;
			case 132:
				setVerseNumber(3);
				break;
			case 133:
				setVerseNumber(3);
				break;
			case 134:
				setVerseNumber(21);
				break;
			case 135:
				setVerseNumber(26);
				break;
			case 136:
				setVerseNumber(9);
				break;
			case 137:
				setVerseNumber(8);
				break;
			case 138:
				setVerseNumber(24);
				break;

			case 139:
				setVerseNumber(13);
				break;

			case 140:
				setVerseNumber(10);
				break;

			case 141:
				setVerseNumber(7);
				break;

			case 142:
				setVerseNumber(12);
				break;

			case 143:
				setVerseNumber(15);
				break;

			case 144:
				setVerseNumber(21);
				break;
			case 145:
				setVerseNumber(10);
				break;
			case 146:
				setVerseNumber(20);
				break;
			case 147:
				setVerseNumber(14);
				break;
			case 148:
				setVerseNumber(9);
				break;
			case 149:
				setVerseNumber(6);
				break;
			}

		} else if (checkBook.contains("proverbs")) {
			switch (position) {
			case 0:
				setVerseNumber(33);
				break;

			case 1:
				setVerseNumber(22);
				break;

			case 2:
				setVerseNumber(35);
				break;

			case 3:
				setVerseNumber(27);
				break;

			case 4:
				setVerseNumber(23);
				break;

			case 5:
				setVerseNumber(35);
				break;
			case 6:
				setVerseNumber(27);
				break;
			case 7:
				setVerseNumber(36);
				break;
			case 8:
				setVerseNumber(18);
				break;
			case 9:
				setVerseNumber(32);
				break;
			case 10:
				setVerseNumber(31);
				break;
			case 11:
				setVerseNumber(28);
				break;
			case 12:
				setVerseNumber(25);
				break;

			case 13:
				setVerseNumber(35);
				break;

			case 14:
				setVerseNumber(33);
				break;

			case 15:
				setVerseNumber(33);
				break;

			case 16:
				setVerseNumber(28);
				break;

			case 17:
				setVerseNumber(24);
				break;

			case 18:
				setVerseNumber(29);
				break;
			case 19:
				setVerseNumber(30);
				break;
			case 20:
				setVerseNumber(31);
				break;
			case 21:
				setVerseNumber(29);
				break;
			case 22:
				setVerseNumber(35);
				break;
			case 23:
				setVerseNumber(34);
				break;
			case 24:
				setVerseNumber(28);
				break;
			case 25:
				setVerseNumber(28);
				break;
			case 26:
				setVerseNumber(27);
				break;

			case 27:
				setVerseNumber(28);
				break;

			case 28:
				setVerseNumber(27);
				break;

			case 29:
				setVerseNumber(33);
				break;

			case 30:
				setVerseNumber(31);
				break;
			}

		} else if (checkBook.contains("ecclesiastes")) {
			switch (position) {
			case 0:
				setVerseNumber(18);
				break;

			case 1:
				setVerseNumber(26);
				break;

			case 2:
				setVerseNumber(22);
				break;

			case 3:
				setVerseNumber(16);
				break;

			case 4:
				setVerseNumber(20);
				break;

			case 5:
				setVerseNumber(12);
				break;
			case 6:
				setVerseNumber(29);
				break;
			case 7:
				setVerseNumber(17);
				break;
			case 8:
				setVerseNumber(18);
				break;
			case 9:
				setVerseNumber(20);
				break;
			case 10:
				setVerseNumber(10);
				break;
			case 11:
				setVerseNumber(14);
				break;

			}

		} else if (checkBook.contains("song of solomon")) {
			switch (position) {
			case 0:
				setVerseNumber(17);
				break;

			case 1:
				setVerseNumber(17);
				break;

			case 2:
				setVerseNumber(11);
				break;

			case 3:
				setVerseNumber(16);
				break;

			case 4:
				setVerseNumber(16);
				break;

			case 5:
				setVerseNumber(13);
				break;
			case 6:
				setVerseNumber(13);
				break;
			case 7:
				setVerseNumber(14);
				break;
			}


		} else if (checkBook.contains("isaiah")) {
			switch (position) {
			case 0:
				setVerseNumber(31);
				break;

			case 1:
				setVerseNumber(22);
				break;

			case 2:
				setVerseNumber(26);
				break;

			case 3:
				setVerseNumber(6);
				break;

			case 4:
				setVerseNumber(30);
				break;

			case 5:
				setVerseNumber(13);
				break;
			case 6:
				setVerseNumber(25);
				break;
			case 7:
				setVerseNumber(22);
				break;
			case 8:
				setVerseNumber(21);
				break;
			case 9:
				setVerseNumber(34);
				break;
			case 10:
				setVerseNumber(26);
				break;
			case 11:
				setVerseNumber(6);
				break;
			case 12:
				setVerseNumber(22);
				break;

			case 13:
				setVerseNumber(32);
				break;

			case 14:
				setVerseNumber(9);
				break;

			case 15:
				setVerseNumber(14);
				break;

			case 16:
				setVerseNumber(14);
				break;

			case 17:
				setVerseNumber(7);
				break;

			case 18:
				setVerseNumber(25);
				break;
			case 19:
				setVerseNumber(6);
				break;
			case 20:
				setVerseNumber(17);
				break;
			case 21:
				setVerseNumber(25);
				break;
			case 22:
				setVerseNumber(18);
				break;
			case 23:
				setVerseNumber(23);
				break;
			case 24:
				setVerseNumber(12);
				break;
			case 25:
				setVerseNumber(21);
				break;
			case 26:
				setVerseNumber(13);
				break;

			case 27:
				setVerseNumber(29);
				break;

			case 28:
				setVerseNumber(24);
				break;

			case 29:
				setVerseNumber(33);
				break;

			case 30:
				setVerseNumber(19);
				break;

			case 31:
				setVerseNumber(20);
				break;
			case 32:
				setVerseNumber(24);
				break;
			case 33:
				setVerseNumber(17);
				break;
			case 34:
				setVerseNumber(10);
				break;
			case 35:
				setVerseNumber(22);
				break;
			case 36:
				setVerseNumber(38);
				break;
			case 37:
				setVerseNumber(22);
				break;
			case 38:
				setVerseNumber(8);
				break;
			case 39:
				setVerseNumber(31);
				break;

			case 40:
				setVerseNumber(29);
				break;

			case 41:
				setVerseNumber(25);
				break;

			case 42:
				setVerseNumber(28);
				break;

			case 43:
				setVerseNumber(28);
				break;

			case 44:
				setVerseNumber(25);
				break;

			case 45:
				setVerseNumber(13);
				break;

			case 46:
				setVerseNumber(15);
				break;

			case 47:
				setVerseNumber(22);
				break;
			case 48:
				setVerseNumber(26);
				break;
			case 49:
				setVerseNumber(11);
				break;
			case 50:
				setVerseNumber(23);
				break;
			case 51:
				setVerseNumber(15);
				break;
			case 52:
				setVerseNumber(12);
				break;
			case 53:
				setVerseNumber(17);
				break;
			case 54:
				setVerseNumber(13);
				break;

			case 55:
				setVerseNumber(12);
				break;

			case 56:
				setVerseNumber(21);
				break;

			case 57:
				setVerseNumber(14);
				break;

			case 58:
				setVerseNumber(21);
				break;

			case 59:
				setVerseNumber(22);
				break;

			case 60:
				setVerseNumber(11);
				break;
			case 61:
				setVerseNumber(12);
				break;
			case 62:
				setVerseNumber(19);
				break;
			case 63:
				setVerseNumber(12);
				break;
			case 64:
				setVerseNumber(25);
				break;
			case 65:
				setVerseNumber(24);
				break;
			}
		} else if (checkBook.contains("jeremiah")) {
			switch (position) {
			case 0:
				setVerseNumber(19);
				break;

			case 1:
				setVerseNumber(37);
				break;

			case 2:
				setVerseNumber(25);
				break;

			case 3:
				setVerseNumber(31);
				break;

			case 4:
				setVerseNumber(31);
				break;

			case 5:
				setVerseNumber(30);
				break;
			case 6:
				setVerseNumber(34);
				break;
			case 7:
				setVerseNumber(22);
				break;
			case 8:
				setVerseNumber(26);
				break;
			case 9:
				setVerseNumber(25);
				break;
			case 10:
				setVerseNumber(23);
				break;
			case 11:
				setVerseNumber(17);
				break;
			case 12:
				setVerseNumber(27);
				break;

			case 13:
				setVerseNumber(22);
				break;

			case 14:
				setVerseNumber(21);
				break;

			case 15:
				setVerseNumber(21);
				break;

			case 16:
				setVerseNumber(27);
				break;

			case 17:
				setVerseNumber(23);
				break;

			case 18:
				setVerseNumber(15);
				break;
			case 19:
				setVerseNumber(18);
				break;
			case 20:
				setVerseNumber(14);
				break;
			case 21:
				setVerseNumber(30);
				break;
			case 22:
				setVerseNumber(40);
				break;
			case 23:
				setVerseNumber(10);
				break;
			case 24:
				setVerseNumber(38);
				break;
			case 25:
				setVerseNumber(24);
				break;
			case 26:
				setVerseNumber(22);
				break;

			case 27:
				setVerseNumber(17);
				break;

			case 28:
				setVerseNumber(32);
				break;

			case 29:
				setVerseNumber(24);
				break;

			case 30:
				setVerseNumber(40);
				break;

			case 31:
				setVerseNumber(44);
				break;
			case 32:
				setVerseNumber(26);
				break;
			case 33:
				setVerseNumber(22);
				break;
			case 34:
				setVerseNumber(19);
				break;
			case 35:
				setVerseNumber(32);
				break;
			case 36:
				setVerseNumber(21);
				break;
			case 37:
				setVerseNumber(28);
				break;
			case 38:
				setVerseNumber(18);
				break;
			case 39:
				setVerseNumber(16);
				break;

			case 40:
				setVerseNumber(18);
				break;

			case 41:
				setVerseNumber(22);
				break;

			case 42:
				setVerseNumber(13);
				break;

			case 43:
				setVerseNumber(30);
				break;

			case 44:
				setVerseNumber(5);
				break;

			case 45:
				setVerseNumber(28);
				break;

			case 46:
				setVerseNumber(7);
				break;

			case 47:
				setVerseNumber(47);
				break;
			case 48:
				setVerseNumber(39);
				break;
			case 49:
				setVerseNumber(46);
				break;
			case 50:
				setVerseNumber(64);
				break;
			case 51:
				setVerseNumber(34);
				break;
			}

		} else if (checkBook.contains("lamentations")) {
			switch (position) {
			case 0:
				setVerseNumber(22);
				break;

			case 1:
				setVerseNumber(22);
				break;

			case 2:
				setVerseNumber(66);
				break;

			case 3:
				setVerseNumber(22);
				break;

			case 4:
				setVerseNumber(22);
				break;
			}

		} else if (checkBook.contains("ezekiel")) {
			switch (position) {
			case 0:
				setVerseNumber(28);
				break;

			case 1:
				setVerseNumber(10);
				break;

			case 2:
				setVerseNumber(27);
				break;

			case 3:
				setVerseNumber(17);
				break;

			case 4:
				setVerseNumber(17);
				break;

			case 5:
				setVerseNumber(14);
				break;
			case 6:
				setVerseNumber(27);
				break;
			case 7:
				setVerseNumber(18);
				break;
			case 8:
				setVerseNumber(11);
				break;
			case 9:
				setVerseNumber(22);
				break;
			case 10:
				setVerseNumber(25);
				break;
			case 11:
				setVerseNumber(28);
				break;
			case 12:
				setVerseNumber(23);
				break;

			case 13:
				setVerseNumber(23);
				break;

			case 14:
				setVerseNumber(8);
				break;

			case 15:
				setVerseNumber(63);
				break;

			case 16:
				setVerseNumber(24);
				break;

			case 17:
				setVerseNumber(32);
				break;

			case 18:
				setVerseNumber(14);
				break;
			case 19:
				setVerseNumber(49);
				break;
			case 20:
				setVerseNumber(32);
				break;
			case 21:
				setVerseNumber(31);
				break;
			case 22:
				setVerseNumber(49);
				break;
			case 23:
				setVerseNumber(27);
				break;
			case 24:
				setVerseNumber(17);
				break;
			case 25:
				setVerseNumber(21);
				break;
			case 26:
				setVerseNumber(36);
				break;

			case 27:
				setVerseNumber(26);
				break;

			case 28:
				setVerseNumber(21);
				break;

			case 29:
				setVerseNumber(26);
				break;

			case 30:
				setVerseNumber(18);
				break;

			case 31:
				setVerseNumber(32);
				break;
			case 32:
				setVerseNumber(33);
				break;
			case 33:
				setVerseNumber(31);
				break;
			case 34:
				setVerseNumber(15);
				break;
			case 35:
				setVerseNumber(38);
				break;
			case 36:
				setVerseNumber(28);
				break;
			case 37:
				setVerseNumber(23);
				break;
			case 38:
				setVerseNumber(29);
				break;
			case 39:
				setVerseNumber(49);
				break;

			case 40:
				setVerseNumber(26);
				break;

			case 41:
				setVerseNumber(20);
				break;

			case 42:
				setVerseNumber(27);
				break;

			case 43:
				setVerseNumber(31);
				break;

			case 44:
				setVerseNumber(25);
				break;

			case 45:
				setVerseNumber(24);
				break;

			case 46:
				setVerseNumber(23);
				break;

			case 47:
				setVerseNumber(35);
				break;
			}

		} else if (checkBook.contains("daniel")) {
			switch (position) {
			case 0:
				setVerseNumber(21);
				break;

			case 1:
				setVerseNumber(49);
				break;

			case 2:
				setVerseNumber(30);
				break;

			case 3:
				setVerseNumber(37);
				break;

			case 4:
				setVerseNumber(31);
				break;

			case 5:
				setVerseNumber(28);
				break;
			case 6:
				setVerseNumber(28);
				break;
			case 7:
				setVerseNumber(27);
				break;
			case 8:
				setVerseNumber(27);
				break;
			case 9:
				setVerseNumber(21);
				break;
			case 10:
				setVerseNumber(45);
				break;
			case 11:
				setVerseNumber(13);
				break;
			}

		} else if (checkBook.contains("hosea")) {

			switch (position) {
			case 0:
				setVerseNumber(11);
				break;

			case 1:
				setVerseNumber(23);
				break;

			case 2:
				setVerseNumber(5);
				break;

			case 3:
				setVerseNumber(19);
				break;

			case 4:
				setVerseNumber(15);
				break;

			case 5:
				setVerseNumber(11);
				break;
			case 6:
				setVerseNumber(16);
				break;
			case 7:
				setVerseNumber(14);
				break;
			case 8:
				setVerseNumber(17);
				break;
			case 9:
				setVerseNumber(15);
				break;
			case 10:
				setVerseNumber(12);
				break;
			case 11:
				setVerseNumber(14);
				break;
			case 12:
				setVerseNumber(16);
				break;

			case 13:
				setVerseNumber(9);
				break;
			}
		} else if (checkBook.contains("joel")) {
			switch (position) {
			case 0:
				setVerseNumber(20);
				break;
			case 1:
				setVerseNumber(32);
				break;
			case 2:
				setVerseNumber(21);
				break;
			}

		} else if (checkBook.contains("amos")) {
			switch (position) {
			case 0:
				setVerseNumber(15);
				break;

			case 1:
				setVerseNumber(16);
				break;

			case 2:
				setVerseNumber(15);
				break;

			case 3:
				setVerseNumber(13);
				break;

			case 4:
				setVerseNumber(27);
				break;

			case 5:
				setVerseNumber(14);
				break;
			case 6:
				setVerseNumber(17);
				break;
			case 7:
				setVerseNumber(14);
				break;
			case 8:
				setVerseNumber(15);
				break;
			}

		} else if (checkBook.contains("obadiah")) {
			switch (position) {
			case 0:
				setVerseNumber(21);
				break;
			}

		} else if (checkBook.contains("jonah")) {
			switch (position) {
			case 0:
				setVerseNumber(17);
				break;
			case 1:
				setVerseNumber(10);
				break;
			case 2:
				setVerseNumber(10);
				break;
			case 3:
				setVerseNumber(11);
				break;
			}
		} else if (checkBook.contains("micah")) {
			switch (position) {
			case 0:
				setVerseNumber(16);
				break;

			case 1:
				setVerseNumber(13);
				break;

			case 2:
				setVerseNumber(12);
				break;

			case 3:
				setVerseNumber(13);
				break;

			case 4:
				setVerseNumber(15);
				break;

			case 5:
				setVerseNumber(16);
				break;
			case 6:
				setVerseNumber(20);
				break;

			}

		} else if (checkBook.contains("nahum")) {

			switch (position) {
			case 0:
				setVerseNumber(15);
				break;

			case 1:
				setVerseNumber(13);
				break;

			case 2:
				setVerseNumber(19);
				break;

			}
		} else if (checkBook.contains("habakkuk")) {

			switch (position) {
			case 0:
				setVerseNumber(17);
				break;

			case 1:
				setVerseNumber(20);
				break;

			case 2:
				setVerseNumber(19);
				break;

			}
		} else if (checkBook.contains("zephaniah")) {
			switch (position) {
			case 0:
				setVerseNumber(18);
				break;

			case 1:
				setVerseNumber(15);
				break;

			case 2:
				setVerseNumber(20);
				break;

			}

		} else if (checkBook.contains("haggai")) {
			switch (position) {
			case 0:
				setVerseNumber(15);
				break;

			case 1:
				setVerseNumber(23);
				break;

			}

		} else if (checkBook.contains("zechariah")) {
			switch (position) {
			case 0:
				setVerseNumber(21);
				break;

			case 1:
				setVerseNumber(13);
				break;

			case 2:
				setVerseNumber(10);
				break;

			case 3:
				setVerseNumber(14);
				break;

			case 4:
				setVerseNumber(11);
				break;

			case 5:
				setVerseNumber(15);
				break;
			case 6:
				setVerseNumber(14);
				break;
			case 7:
				setVerseNumber(23);
				break;
			case 8:
				setVerseNumber(17);
				break;
			case 9:
				setVerseNumber(12);
				break;
			case 10:
				setVerseNumber(17);
				break;
			case 11:
				setVerseNumber(14);
				break;
			case 12:
				setVerseNumber(9);
				break;
			case 13:
				setVerseNumber(21);
				break;
			}
		} else if (checkBook.contains("malachi")) {
			switch (position) {
			case 0:
				setVerseNumber(14);
				break;
			case 1:
				setVerseNumber(17);
				break;
			case 2:
				setVerseNumber(18);
				break;
			case 3:
				setVerseNumber(6);
				break;
			}

		}

		chapter.setAdapter(adapter);
	}

	private void setVerseNumber(int verse) {
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



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		// TODO Auto-generated method stub
		String verse = String.valueOf(pos);
		ArrayList<String> array = new ArrayList<String>();
		array.add(verse);
		ah.saveArray("verse", array);
		Intent intent = new Intent(getActivity(), MainActivity.class);
		startActivity(intent);
	}
}
