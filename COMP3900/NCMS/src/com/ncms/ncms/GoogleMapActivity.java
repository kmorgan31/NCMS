package com.ncms.ncms;

import java.util.List;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
//import com.google.android.maps.MyLocationOverlay;
//import com.google.android.maps.Overlay;

import android.os.Bundle;
//import android.view.Menu;
//import android.view.MotionEvent;

public class GoogleMapActivity extends MapActivity {

	MapView map;
	long start,stop;
	//MyLocationOverlay compass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		map = (MapView)findViewById(R.id.map);
		map.setBuiltInZoomControls(true);
		
//		Touch t = new Touch();
//		List<Overlay> overlayList = map.getOverlays();
//		overlayList.add(t);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.map, menu);
//		return true;
//	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	class Touch extends Overlay{
//		public boolean onTouchEvent(MotionEvent e, MapView m){
//			return false;
//		}
//	}

}
