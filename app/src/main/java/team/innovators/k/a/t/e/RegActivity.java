package team.innovators.k.a.t.e;

//import java.io.FileNotFoundException;
//import java.io.IOException;

import android.app.Activity;
//import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
//import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
import android.widget.Toast;
//import android.support.v7.app.AppCompatActivity;




public class RegActivity extends Activity {
	
	private EditText regEmail,regPhone,regPass,regName;
	private Button regSignup;
	private static final String TAG="Registration";
	private String getEmail,getPhone,getPass,getName;
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		
		regEmail=(EditText) findViewById (R.id.txtRegEmail);
		regPhone=(EditText) findViewById (R.id.txtRegPhone);
		regPass=(EditText) findViewById (R.id.txtRegPass);
		regName=(EditText) findViewById (R.id.txtRegName);
		regSignup=(Button) findViewById(R.id.regBtnSignUp);
		
//create instance of database.sqlite
		
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	    loginDataBaseAdapter=loginDataBaseAdapter.open();
		
	    regSignup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getEmail=regEmail.getText().toString();
				getPhone=regPhone.getText().toString();
				getName=regName.getText().toString();
				getPass=regPass.getText().toString();
				
		// check if any of the fields are empty
				
				if(getEmail.equals("") || getPhone.equals("") || getName.equals("") || getPass.equals("")){
					
					Toast.makeText(getApplicationContext(), "Some of the fields are empty", Toast.LENGTH_LONG).show();
					return;
				}
				
		//check if password is longer than 4 characters
				
				if(getPass.length()<4){
					Toast.makeText(getApplicationContext(), "Password length is less than four characters", Toast.LENGTH_SHORT).show();
					return;
				}
				
				else{
		//save data in db
					loginDataBaseAdapter.insertEntry(getName, getPass, getEmail, getPhone);
					Toast.makeText(getApplicationContext(), "Success! Lets Explore", Toast.LENGTH_LONG).show();
					
					
				}
				
				
			}
		});
		
		
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		SharedPreferences setUserName=PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editsetName=setUserName.edit();
		editsetName.putString("pref_general_disp_name", getName);
		editsetName.apply();
		editsetName.commit();
		
		loginDataBaseAdapter.close();
		
//after sucessful login,launch app's MAIN ACTIVITY for first time without login
		
		Intent gotoMain=new Intent(getApplicationContext(),MainActivity.class);
		startActivity(gotoMain);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg, menu);
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





















	
}
