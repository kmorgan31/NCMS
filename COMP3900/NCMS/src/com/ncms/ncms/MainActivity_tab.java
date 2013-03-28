package com.ncms.ncms;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity_tab extends Activity {

	ExpandableListView exv;
	TabHost tbh;
	int numDeliveries;
	int numStops; //areas to deliver papers in delivery
	int numAgents; //agents within area to delivery papers to
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_tab);
		
		exv = (ExpandableListView)findViewById(R.id.expandableListView1);
		exv.setAdapter(new MyAdapter(this));
		
		//tbh = getTabHost();
		
		exv.setOnChildClickListener(new OnChildClickListener(){

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				//change mapView
				//change tabs
				//when specific tab selected - zoom in on area and show agents
				String itemClicked = MyAdapter.childList[groupPosition][childPosition];
				Toast.makeText(MainActivity_tab.this, itemClicked + " is clicked", Toast.LENGTH_SHORT).show();
				return false;
			}
	
		});
		
		numDeliveries = exv.getCount();
		//tbh = (TabHost)findViewById(R.id.tab1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_tab, menu);
		return true;
	}

}