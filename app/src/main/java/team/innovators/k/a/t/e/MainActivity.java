package team.innovators.k.a.t.e;


import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//notification class imports
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends Activity {

	
	private EditText setUserNamefromSettings;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//starting lockscreen service
		
		startService(new Intent(this,LockScreenService.class));
		//startService(new Intent(this,LockScreen.class));
		
		
//set default values into settings
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		
//check if app is running on its first run
		
		
		SharedPreferences fRun=getSharedPreferences("firstrun",0);
		
		SharedPreferences loginEnabled=getSharedPreferences("pref_general_enable_login",0);
		//SharedPreferences loginEnabled=getSharedPreferences("pref_general_enable_login",0);
		
		if(fRun.getBoolean("firstrun", true)){
			
			SharedPreferences.Editor editX=fRun.edit();
			editX.putBoolean("firstrun", false);
			editX.apply();
			
			
			//reg activity stuff here
			
//goto register screen
			
			Intent loginIntent=new Intent(getApplicationContext(),RegActivity.class);
			startActivity(loginIntent);
			//Toast.makeText(getApplicationContext(), "First run", Toast.LENGTH_LONG).show();
			
			finish();
			
		}
	else{	
		if(loginEnabled.getBoolean("pref_general_enable_login", true)==true){
			
			//gotoLogin();
			
			Intent gotoLogin=new Intent(MainActivity.this,LoginActivity.class);
			startActivity(gotoLogin);
			
			//finish();
		}
		else{
			Toast.makeText(getApplicationContext(), "Login Disabled", Toast.LENGTH_LONG).show();
		}
	}	
		
		
//set xml file activity_main.xml as interface for this activity
		setContentView(R.layout.activity_main);                      
		
		
		//settingsDataUpdate();  *** this'll be needed no more.delete this method -by Me 8/25/16 3.14pm
		
//Set custom notification on notification drawer
		SetNotification();
		
		
		
//plugging in layout's items into code.like identifier
		
		Button CompBtn=(Button) findViewById(R.id.CompBtn);
		Button MicBtn=(Button) findViewById(R.id.MicBtn);
		Button NotesBtnHome=(Button) findViewById(R.id.NotesBtnHome);
		Button CamreaHomeBtn=(Button) findViewById(R.id.CameraHomeBtn);
		Button LockerHomeBtn=(Button) findViewById(R.id.LockerBtnHome);
		
	//TEMP LOGIN BUTTON
		//Button tempLogin=(Button) findViewById(R.id.ExtraSettingsBtn);
		
		
		//Button mainScrPreferences=(Button) findViewById(R.id.action_main_settings);

//set username from settings
		
		setUserName();
		
//end set username		
		
//compass interface access for compass.this is like just one line of long code line.
		CompBtn.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				
				//create intent for change interfaces, from HOME to COMPASS
				Intent GotoCompass=new Intent(getApplicationContext(),CompassActivity.class);
				startActivity(GotoCompass);	
			}
		});
//end compass interface access
		
		
//Voice interface access
		MicBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//create intent for change interfaces, from HOME to VOICE ACTIONS
				Intent GotoVoice=new Intent(getApplicationContext(),TalkWithMe.class);
				startActivity(GotoVoice);
				
			}
		});
//end voice interface access
		
		
//Notes interface access
		NotesBtnHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//create intent for change interfaces, from HOME to NOTES
				Intent GotoNotes=new Intent(getApplicationContext(),NotesActivity.class);
				startActivity(GotoNotes);
				
			}
		});
//end notes interface access
		
		
//Camera interface access
		
		CamreaHomeBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//create intent for change interfaces, from HOME to CAMERA
				Intent GotoCamHome=new Intent(getApplicationContext(),CameraActivity.class);
				startActivity(GotoCamHome);
				
			}
		});
		
//end camera interface access
		
		
//Locker interface access
		
		LockerHomeBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//create intent for change interfaces, from HOME to LOCKER
				Intent GotoLocker=new Intent(getApplicationContext(),LockerActivity.class);
				startActivity(GotoLocker);
				
			}
		});
		
//end locker interface access
		
		
		
		
//TEMP LOGIN
/*		tempLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent gotoTempLogin=new Intent(getApplicationContext(),LoginActivity.class);
				startActivity(gotoTempLogin);
				
			}
		});		*/
		
	}

	
	
	public void setUserName(){
		float greetsize=30;
		String getName = null;
		SharedPreferences shpf=PreferenceManager.
				getDefaultSharedPreferences(this);
		getName=shpf.getString("pref_general_disp_name",null);

		TextView userName = (TextView)findViewById(R.id.textHomeGreeting);
		userName.setText("Hello "+getName+"..");
		userName.setTextSize(greetsize);
	}
	
	
	
	
	public void settingsDataUpdate(){
		
		setUserNamefromSettings=(EditText) findViewById(R.id.textHomeGreeting);
		SharedPreferences pref=getApplicationContext().getSharedPreferences("pref_general_disp_name", MODE_PRIVATE);
		String userNamex=pref.getString("pref_general_disp_name", "");
		setUserNamefromSettings.setText(userNamex);
	}
	
	
	
	
	
	public void gotoLogin(){
		
		Intent gotoLogin=new Intent(getApplicationContext(),LoginActivity.class);
		startActivity(gotoLogin);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		
		int id = item.getItemId();
		if (id == R.id.action_main_prefs) {
			Intent aa=new Intent(getApplicationContext(),MainSettings.class);
			startActivity(aa);
			
			return true;
		}
		if(id==R.id.action_main_about){
			Toast.makeText(MainActivity.this, "Created By Team innovators", Toast.LENGTH_LONG).show();
			return true;
		}
		
		if(id==R.id.action_main_help){
			//Intent abc=new Intent();   DO SOMETHIG HERE!!!!!!!!!!
			SharedPreferences shpf=PreferenceManager.
					getDefaultSharedPreferences(this);
			String show=shpf.getString("pref_general_disp_name",null);
			Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
			
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	public void SetNotification(){
		//String tmpNotif="Welcome to KATE";
		NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
		
		Intent notif=new Intent(this,MainActivity.class);
		notif.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent pInt=PendingIntent.getActivity(this, 0, notif, PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(pInt);
		
		builder.setTicker(getResources().getString(R.string.home_notif_ticker));
		
		builder.setSmallIcon(R.drawable.notification_small);
		
		builder.setAutoCancel(false);
		
		builder.setOnlyAlertOnce(true);
		
		builder.setContentTitle(getResources().getString(R.string.home_notification_title));
		builder.setContentText(getResources().getString(R.string.home_notification_text));
		
		Notification Crnotif=builder.build();
		
		NotificationManager show=(NotificationManager) 
					getSystemService(NOTIFICATION_SERVICE);
		show.notify(0, Crnotif);
		
		
	}
	
	public void showNotificationClicked(View v) {
        SetNotification();
    }
	
	
	
	
	
	
	
	
	
	
	
	
}
