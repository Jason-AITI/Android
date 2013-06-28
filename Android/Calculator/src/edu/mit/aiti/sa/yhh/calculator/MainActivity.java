package edu.mit.aiti.sa.yhh.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;

/* Summary: 
 * The equals button is a bit glitchy.
 * The clear button just crashes the program.
 * 
 * Result:
 * The clear button is disabled.
 */


public class MainActivity extends Activity {

	TextView disp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		disp = (TextView)findViewById(R.id.textView1);
		disp.setText("0");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	static boolean isEmpty=true;
	public void num_Clicked(View sender){
		Button bt = (Button)sender;		
		if (disp.getText().length()>7)return;
		if (isEmpty){
			if(bt.getText().toString().equals("0"))return;
			disp.setText(bt.getText());
			isEmpty = false;
		}
		else{
			disp.append(bt.getText());
		}

	}
	
	static int accumulator=0;
	static short operationToDo=0;
	public void op_Clicked(View sender){
		Button bt = (Button)sender;
		switch(operationToDo){
		case 0: accumulator += Integer.parseInt(disp.getText().toString());
				break;
		case 1: accumulator -= Integer.parseInt(disp.getText().toString());
				break;
		case 2: accumulator *= Integer.parseInt(disp.getText().toString());
				break;
		case 3: accumulator /= Integer.parseInt(disp.getText().toString());
				break;
		case 4: accumulator += 0;
				break;
		}
		
		disp.setText(Integer.toString(accumulator));
		if(bt.getText().toString().equals("+")) operationToDo = 0;
		if(bt.getText().toString().equals("-")) operationToDo = 1;
		if(bt.getText().toString().equals("*")) operationToDo = 2;
		if(bt.getText().toString().equals("/")) operationToDo = 3;
		if(bt.getText().toString().equals("=")) operationToDo = 4;
		isEmpty = true;
		
	}
	public void result_Clicked(View sender){
		disp.setText(Integer.toString(accumulator));
		isEmpty = true;
	}
	
	
	// Doesn't work. Crashes the calculator and can't figure out why.
	public void clear_Clicked(){
		operationToDo = 0;
		accumulator = 0;
		disp.setText("0");
		isEmpty = true;
	}
	
	public static final String EXTRA_MSG = "aiti.mit.edu.sa.yhh.calculator.MESSAGE";
	
	public void nextAct(View v){
		Intent intent = new Intent(v.getContext(),SecondActivity.class);
		String str = disp.getText().toString();
		intent.putExtra(EXTRA_MSG, str);
		startActivity(intent);
	}
	
}
