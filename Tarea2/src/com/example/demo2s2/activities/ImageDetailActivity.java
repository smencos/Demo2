package com.example.demo2s2.activities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.demo2s2.R;
import com.example.demo2s2.data.Tienda;

public class ImageDetailActivity extends ListActivity implements OnClickListener {
	
	private final static String EMAIL = "email";

	private List<HashMap<String, String>> emails = new ArrayList<HashMap<String, String>>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.imagen_tienda);
		
		Button btnAdd = (Button) findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(this);
		
		SimpleAdapter adapter = new SimpleAdapter(this, 
												  emails, 
												  android.R.layout.simple_list_item_1, 
												  new String[]{EMAIL}, 
												  new int[]{android.R.id.text1});
		setListAdapter(adapter);
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String country = "casa";
		switch (item.getItemId()){
			case R.id.action_share:
				if (!country.equals("")) {
					String url = "Te comparto la tienda " + country;
					Tienda tiendaMos = MainActivity.tiendastarea1.get(country);
					String nombre = tiendaMos.name1;
					String dire = tiendaMos.direccion1;
					String we = tiendaMos.website1;
					String msg = url + " direccion: " + dire + " Webpage: " + we;
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.putExtra(Intent.EXTRA_TEXT, msg);
					intent.setType("text/plain");
					startActivity(Intent.createChooser(intent, getString(R.string.action_share)));
				}
				return true; 
			default: 
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View v) {
		EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail); 
		String email = editTextEmail.getText().toString();
		HashMap<String, String>	element = new HashMap<String, String>();
		element.put(EMAIL, email);
		emails.add(element);
		SimpleAdapter adapter = (SimpleAdapter)getListAdapter();
		adapter.notifyDataSetChanged();
	}
	

}
