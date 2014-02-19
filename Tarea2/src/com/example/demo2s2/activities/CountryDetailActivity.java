package com.example.demo2s2.activities;

import java.io.File;

import com.example.demo2s2.R;
import com.example.demo2s2.R.id;
import com.example.demo2s2.R.layout;
import com.example.demo2s2.R.menu;
import com.example.demo2s2.R.string;
import com.example.demo2s2.data.Tienda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class CountryDetailActivity extends FragmentActivity {
	private String country ="";
	public static final String COUNTRY ="country";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country_detail);
		
		Intent intent = getIntent();
		country = (intent.getStringExtra(COUNTRY));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case R.id.action_share:
				Uri imageUri = Uri.parse("file//res/drawable/aptura.png");
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SEND);           
				intent.setType("image/jpeg");
				intent.putExtra(Intent.EXTRA_STREAM, imageUri);         
				startActivity(Intent.createChooser(intent, getString(R.string.action_share))); 
				
				return true; 
			default: 
				return super.onOptionsItemSelected(item);
		}
	}

	public String getCountry() {
		return country;
	}



}
