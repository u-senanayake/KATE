package team.innovators.k.a.t.e;

import java.io.FileNotFoundException;
import java.io.IOException;

import android.content.Context;
import android.content.Intent;
//import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.widget.ImageView;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.TextView;
//import team.innovators.k.a.t.e.MainActivity;
import android.widget.RelativeLayout;

public class MainSettings extends PreferenceActivity {
	
	String PassUpdated;
	public RelativeLayout lockBg;

	protected static final int SELECT_PICTURE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main_settings);
		addPreferencesFromResource(R.xml.preferences);
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		
		//getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
		
		//SET DEFAULT VALUES SET BY DEVELOPER
		//PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		
/*		//read from saved settings
		SharedPreferences shpf=PreferenceManager.
				getDefaultSharedPreferences(this);
		String show=shpf.getString("pref_general_disp_name",null);
*/
		
//--------------------------------------------------------------------------------------------------
		//this caused user name become null
/*
		
//write settings
		String newName="Vishwa";
		SharedPreferences setName=PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editsetName=setName.edit();
		editsetName.putString("pref_general_disp_name", newName);
		editsetName.apply();
		editsetName.commit();
		
		//updateName();
		//setname.setUserName();
		
		
	*/	
//---------------------------------------------------------------------------------------------------	
		//change login pass
		
		EditTextPreference newCode=(EditTextPreference) findPreference("pref_general_change_login_pin");
		newCode.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				
				String newwCode=newValue.toString();
				updatePasscode(newwCode);
			
				return true;
			}
		});
		
		SharedPreferences updatepass=PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editPass=updatepass.edit();
		editPass.putString("pref_general_change_login_pin", PassUpdated);
		editPass.apply();
		editPass.commit();
		
		
		
		//------------------------------------------------------------
		
		
		Preference changeLockScrBg=(Preference) findPreference("pref_lockscree_bgimage_path");
		changeLockScrBg.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			
			@Override
			public boolean onPreferenceClick(Preference preference) {
				
				Intent img=new Intent();
				img.setType("image/*");
				img.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(Intent.createChooser
						(img, "Select Picture"),SELECT_PICTURE);
				
				
				return false;
			}
		});
		
		
		
		
		/*String bgPath;
		bgPath=getPath();
		SharedPreferences setLockBg=PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor EditBg=setLockBg.edit();
		EditBg.putString(key, value);
		*/
		
		
	}
	
	
	public void updatePasscode(String newwCode){
		
		//String newName="Vishwa";
		SharedPreferences setPasscode=PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editsetName=setPasscode.edit();
		editsetName.putString("pref_general_change_login_pin", newwCode);
		editsetName.apply();
		editsetName.commit();
		
	}
	
	
	
	
//-------------------------------------------------------------------	/*
	/*
	String getPath(){
		
		Intent img=new Intent();
		img.setType("image/*");
		img.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser
				(img, "Select Picture"),SELECT_PICTURE);
		
		return null;
		
	}
	
	
	
	
	
	
	
	
//----------------------------------------------------------------------  */	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Context context=this;
		if(resultCode==RESULT_OK){
			if ((requestCode==SELECT_PICTURE) && (data!=null) 
					&&(data.getData()!=null)   ){
				
				Uri selectedImageUri=data.getData();
				
				
				
				try {
					Bitmap bgImgx=MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
					
					
					Drawable dd= new BitmapDrawable(bgImgx);
					
					String LockScrBg=data.toString();
					
					SharedPreferences setLockBg=PreferenceManager.getDefaultSharedPreferences(this);
					SharedPreferences.Editor EditBg=setLockBg.edit();
					EditBg.putString("lockscr_bg", LockScrBg);
					EditBg.apply();
					EditBg.commit();
					
					lockBg=(RelativeLayout) findViewById(R.id.layoutBg);
					lockBg.setBackgroundDrawable(dd);
					
//					RelativeLayout Lbg=(RelativeLayout) findViewById(R.id.layoutBg);
//					Lbg.setBackgroundDrawable(dd);
					
				
			//		imgLayout=(ImageView) findViewById(R.id.bgImg1);
					//imgLayout.setImageBitmap(bgImgx);
			//		imgLayout.setImageDrawable(dd);
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	
	}
	
	
	
	
	
	
	
	
	

/*	
	public void updateName(){
		String getName = null;
		SharedPreferences shpf=PreferenceManager.
				getDefaultSharedPreferences(this);
		getName=shpf.getString("pref_general_disp_name",null);

		TextView userName = (TextView)findViewById(R.id.textHomeGreeting);
		userName.setText("Hello "+getName);
	}
	
	*/
	
/*	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_settings, menu);
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
