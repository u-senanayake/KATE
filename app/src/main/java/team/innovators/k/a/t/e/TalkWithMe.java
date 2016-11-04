package team.innovators.k.a.t.e;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class TalkWithMe extends Activity implements OnClickListener{
	
	protected static final int REQUEST_OK=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk_with_me);
		findViewById(R.id.button1).setOnClickListener(this);
		
	}

	
	@Override
	public void onClick(View v)
	{
		Intent i=new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
		
			try{
				startActivityForResult(i,REQUEST_OK);
				}
			catch(Exception e){
				Toast.makeText(this, "Error iitializing speech", Toast.LENGTH_LONG).show();
			}
		
	}
	
	
	@Override
	public void onActivityResult(int reqCode,int resCode,Intent data)
	{
		super.onActivityResult(reqCode, resCode, data);
		if(reqCode==REQUEST_OK && resCode==RESULT_OK)
		{
			ArrayList<String>thingsUserSaid=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			((TextView)findViewById(R.id.text1)).setText(thingsUserSaid.get(0));
			
		}
		
	}
	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.talk_with_me, menu);
		return true;
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	*/
}
