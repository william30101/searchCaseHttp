package com.example.searchcase;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button searchBtn;
	TextView searchText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		searchText = (TextView) findViewById(R.id.searchTextView);
		searchBtn = (Button) findViewById(R.id.searchBtn);
		
		RequestQueue queue = requestsingleton.getInstance(this.getApplicationContext()).
			    getRequestQueue();
		
		String url ="http://www.google.com";
		StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
	            new Response.Listener<String>() {
	    @Override
	    public void onResponse(String response) {
	        // Display the first 500 characters of the response string.
	    	searchText.setText("Response is: "+ response.substring(0,500));
	    }
	}, new Response.ErrorListener() {
	    @Override
	    public void onErrorResponse(VolleyError error) {
	    	searchText.setText("That didn't work!");
	    }
	});
		
		requestsingleton.getInstance(this).addToRequestQueue(stringRequest);
	}
	
	
	
	
	private Button.OnClickListener onClickListener = new OnClickListener() {
		int indicator;

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			indicator = v.getId();
			switch (indicator) {
			case R.id.searchBtn:
				String beSearchedText = searchText.getText().toString();

				break;


			default:
				break;

			}
		}

	};
	
}
