package team.innovators.k.a.t.e;

//import java.io.FileNotFoundException;
//import java.io.IOException;

import team.innovators.k.a.t.e.LoginDataBaseAdapter;

import android.app.Activity;
//import android.content.Context;
import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.net.Uri;
import android.os.Bundle;
//import android.provider.MediaStore;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
 
	protected static String getPassfromDB = null;
	public TextView passView;
	public String completeCode="";
	//private int count=4;
	//private String btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		final Button keypadBtn0=(Button) findViewById(R.id.button0);
		final Button keypadBtn1=(Button) findViewById(R.id.button1);
		final Button keypadBtn2=(Button) findViewById(R.id.button2);
		final Button keypadBtn3=(Button) findViewById(R.id.button3);
		final Button keypadBtn4=(Button) findViewById(R.id.button4);
		final Button keypadBtn5=(Button) findViewById(R.id.button5);
		final Button keypadBtn6=(Button) findViewById(R.id.button6);
		final Button keypadBtn7=(Button) findViewById(R.id.button7);
		final Button keypadBtn8=(Button) findViewById(R.id.button8);
		final Button keypadBtn9=(Button) findViewById(R.id.button9);
		final Button loginBtn=(Button) findViewById(R.id.btnlogLogin);
		
		passView=(TextView) findViewById(R.id.loginCode);       
		
		
		keypadBtn0.setClickable(true);
		keypadBtn1.setClickable(true);
		keypadBtn2.setClickable(true);
		keypadBtn3.setClickable(true);
		keypadBtn4.setClickable(true);
		keypadBtn5.setClickable(true);
		keypadBtn6.setClickable(true);
		keypadBtn7.setClickable(true);
		keypadBtn8.setClickable(true);
		keypadBtn9.setClickable(true);
		loginBtn.setClickable(true);
		
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		
//get Button 0 's input		
		keypadBtn0.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn0.isPressed()) {
				
					String key0="0";
					completeCode=completeCode+key0;
					
				
											}
				
				passView.setText(completeCode);
				
			}
		});
		
		
//get Button 1 's input		
		keypadBtn1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					if(keypadBtn1.isPressed()) {
						
						String key1="1";
						completeCode=completeCode+key1;
					
				//	String test=passView.getText().toString();
				//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
				
											}
					passView.setText(completeCode);
				
				
			}
		});
		
		
		//get Button 2 's input
		
		keypadBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn2.isPressed()) {
					
					String key2="2";
					completeCode=completeCode+key2;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		//get Button 3 's input
		
		keypadBtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn3.isPressed()) {
					
					String key3="3";
					completeCode=completeCode+key3;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		//get Button 4 's input
		
		keypadBtn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn4.isPressed()) {
					
					String key4="4";
					completeCode=completeCode+key4;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		//get Button 5 's input
		
		keypadBtn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn5.isPressed()) {
					
					String key5="5";
					completeCode=completeCode+key5;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		//get Button 6 's input
		
		keypadBtn6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn6.isPressed()) {
					
					String key6="6";
					completeCode=completeCode+key6;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		//get Button 7 's input
		
		keypadBtn7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn7.isPressed()) {
					
					String key7="7";
					completeCode=completeCode+key7;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		//get Button 8 's input
		
		keypadBtn8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn8.isPressed()) {
					
					String key8="8";
					completeCode=completeCode+key8;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		//get Button 9 's input
		
		
		keypadBtn9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(keypadBtn9.isPressed()) {
					
					String key9="9";
					completeCode=completeCode+key9;
				
			//	String test=passView.getText().toString();
			//	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG).show();
			
										}
				passView.setText(completeCode);
			
			
		}
	});
		
		
		
		
		
		
		
		
		
		
		
		
		
//finally click this to check database and goto mainactivity or show some error		
		loginBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "Matching passcode, Please wait... ", Toast.LENGTH_SHORT).show();
				
				String checkCode=completeCode;
				
				//String username=
					loginDataBaseAdapter.getDatabaseInstance();	
						
			//get saved passcode from DB	
				getPassfromDB=loginDataBaseAdapter.getSinlgeEntry(checkCode);
				
				if(checkCode.equals(getPassfromDB)){
					//Toast.makeText(getApplicationContext(), "Login Approved!", Toast.LENGTH_LONG).show();
					
					//Intent GotoMain=new Intent(LoginActivity.this,MainActivity.class);
					finish();
					//startActivity(GotoMain);
					//LoginActivity.this.startActivity(GotoMain);
					
					
					
				}
				
				
				else{
					
					Toast.makeText(getApplicationContext(), "Invalid Password..", Toast.LENGTH_LONG).show();
					passView.setText("");
					
					onStop();
					//finishAffinity();
					
					Intent intent = new Intent(LoginActivity.this, null);
					//Clear all activities and start new task
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); 
					startActivity(intent);
					
					return; 
				}
				
			//	Toast.makeText(getApplicationContext(), getPassfromDB, Toast.LENGTH_LONG).show();
				
				//if(checkCode.equals(object))
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
	while((count<5) && count>0){	
		
if(keypadBtn0.isPressed()){
		
		keypadBtn0.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				btn0="0";
				completeCode=btn0;
				passView.setText(completeCode);
				
			}
		});
		completeCode=btn0;
		passView.setText(completeCode);
}

if(keypadBtn1.isPressed()){
		keypadBtn1.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View v) {
					
					btn1="0";
					
					
				}
			});
		completeCode=btn0+btn1;
		passView.setText(completeCode);
}





//loop end
	}
	
	
	
	
	
	
	
	
	
	
	
	*/
	
	
//oncreate end	
}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		loginDataBaseAdapter.close();
		
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		data=new Intent(LoginActivity.this,MainActivity.class);
		startActivity(data);
	}

	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		
		
		
	}
	
	@Override
	public void onBackPressed(){
		return;
	}



	
}
