package edu.mit.aiti.sa.yhh.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class SecondActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MSG);
		
		TextView text = (TextView)findViewById(R.id.textView2);
		text.setText(message);
		
	}
	
	public void rtrn(View v){
		Intent intent = new Intent(v.getContext(),MainActivity.class);
		startActivity(intent);
	}

}
