package com.ncms.ncms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;

public class MainActivity_tab extends Activity {

	ExpandableListView exv;
	int numDeliveries;
	int numStops; //areas to deliver papers in delivery
	int numAgents; //agents within area to delivery papers to
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_tab);
		
		exv = (ExpandableListView)findViewById(R.id.expandableListView1);
		exv.setAdapter(new MyAdapter(this));
		
		exv.setOnGroupClickListener(new OnGroupClickListener(){

			@Override
			public boolean onGroupClick(ExpandableListView arg0, View arg1,
					int groupPosition, long arg3) {
				// TODO Auto-generated method stub
				//change mapview
				//show route from current location to destination
				String itemClicked = MyAdapter.parentList[groupPosition];
				Toast.makeText(MainActivity_tab.this, itemClicked + " is clicked", Toast.LENGTH_SHORT).show();
				if(itemClicked.equals("Delivery 1")){
//					try{
//						Class menuOption = Class.forName("com.ncms.ncms.GoogleMapActivity");
//						double[] coords = {53.55,98.22}; 
//						String child = MyAdapter.childList[groupPosition][0];
//						Intent chosenLayout = new Intent(MainActivity_tab.this,menuOption).putExtra("co-ordinates", coords).putExtra("delivery info", child);
//						startActivity(chosenLayout);
//					}catch(ClassNotFoundException e){
//						e.printStackTrace();
//					}
				}
				return false;
			}
			
		});
		
		exv.setOnChildClickListener(new OnChildClickListener(){

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				//go to delivery page
				String itemClicked = MyAdapter.parentList[groupPosition];
				if(itemClicked.equals("Delivery 1")){
					try{
						Class menuOption = Class.forName("com.ncms.ncms.LoginActivity_Tab");
						Intent chosenLayout = new Intent(MainActivity_tab.this,menuOption).putExtra("delivery info", MyAdapter.childList[groupPosition][childPosition]);
						startActivity(chosenLayout);
					}catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				}
				return false;
			}
	
		});
		
		numDeliveries = exv.getCount();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_tab, menu);
		return true;
	}

}
