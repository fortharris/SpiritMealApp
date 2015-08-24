package com.sabonzy.spiritmealbible;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.sabonzy.tabadapter.TabsPagerAdapter;

public class TabActivity extends FragmentActivity implements
		ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "Chapter", "Verse" };
	String TabFragmentB;


	public void setTabFragmentB(String t) {
		TabFragmentB = t;
	}

	public String getTabFragmentB() {
		return TabFragmentB;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_activity);

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		setHasEmbeddedTabs(actionBar, false);
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}
		// on swiping the viewpager make respective tab selected
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	public static void setHasEmbeddedTabs(Object inActionBar,
			final boolean inHasEmbeddedTabs) {
		// get the ActionBar class
		Class<?> actionBarClass = inActionBar.getClass();

		// if it is a Jelly Bean implementation (ActionBarImplJB), get the super
		// class (ActionBarImplICS)
		if ("android.support.v7.app.ActionBarImplJB".equals(actionBarClass
				.getName())) {
			actionBarClass = actionBarClass.getSuperclass();
		}

		// if Android 4.3 >
		if ("android.support.v7.app.ActionBarImplJBMR2".equals(actionBarClass
				.getName())) {
			actionBarClass = actionBarClass.getSuperclass().getSuperclass();
		}

		try {
			// try to get the mActionBar field, because the current ActionBar is
			// probably just a wrapper Class
			// if this fails, no worries, this will be an instance of the native
			// ActionBar class or from the ActionBarImplBase class
			final Field actionBarField = actionBarClass
					.getDeclaredField("mActionBar");
			actionBarField.setAccessible(true);
			inActionBar = actionBarField.get(inActionBar);
			actionBarClass = inActionBar.getClass();
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (NoSuchFieldException e) {
		}

		try {
			// now call the method setHasEmbeddedTabs, this will put the tabs
			// inside the ActionBar

			final Method method = actionBarClass.getDeclaredMethod(
					"setHasEmbeddedTabs", new Class[] { Boolean.TYPE });
			method.setAccessible(true);
			method.invoke(inActionBar, new Object[] { inHasEmbeddedTabs });
		} catch (NoSuchMethodException e) {
		} catch (InvocationTargetException e) {
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		}
	}

}
