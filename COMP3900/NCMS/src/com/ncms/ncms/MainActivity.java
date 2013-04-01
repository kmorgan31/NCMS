package com.ncms.ncms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

public class MainActivity extends Activity {

	ExpandableListView exv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_phone);
		
		exv = (ExpandableListView)findViewById(R.id.expandableListView1);
		exv.setAdapter(new MyAdapter(this));
		
		exv.setOnGroupClickListener(new OnGroupClickListener(){

			@Override
			public boolean onGroupClick(ExpandableListView arg0, View arg1,
					int groupPosition, long arg3) {
				// TODO Auto-generated method stub
				//show marker on map
				String itemClicked = MyAdapter.parentList[groupPosition];
				Toast.makeText(MainActivity.this, itemClicked + " is clicked", Toast.LENGTH_SHORT).show();
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
						Class menuOption = Class.forName("com.ncms.ncms.LoginActivity");
						Intent chosenLayout = new Intent(MainActivity.this,menuOption).putExtra("delivery info", MyAdapter.childList[groupPosition][childPosition]);
						startActivity(chosenLayout);
					}catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				}
				return false;
			}
	
		});
//		Intent openMenu = new Intent("com.ncms.ncms.MAIN");
//		startActivity(openMenu);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
