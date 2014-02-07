package com.example.demo2s2;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.demo2s2.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] arrayCountries = new String[]{
			"Brasil", "Guatemala", "Mexico", "Espa�a", "Peru"	
		};
		ArrayList<String> countries = new ArrayList<String>(Arrays.asList(arrayCountries));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
		
		ListView list = (ListView) findViewById(R.id.listView);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		String country = adapterView.getItemAtPosition(position).toString();
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
			CountryInfoFragment fragment = (CountryInfoFragment) manager.findFragmentById(R.id.fragmentCountryInfo);
			fragment.loadWebViewContent(country);
			
		} else {
			Intent intent = new Intent(this, CountryDetailActivity.class);
			intent.putExtra(CountryDetailActivity.COUNTRY, country);
			startActivity(intent);
		}
		
	}

}
