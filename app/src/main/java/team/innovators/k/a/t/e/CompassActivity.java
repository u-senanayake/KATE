package team.innovators.k.a.t.e;

import android.app.Activity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;

public class CompassActivity extends Activity implements SensorEventListener{

	
	private ImageView mPointer;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private Sensor mMagnetometer;
	
	private float[] mLastAccelerometer =new float[3];
	private float[] mLastMagnetometer =new float[3];
	
	private boolean mLastAccelerometerSet=false;
	private boolean mLastMagnetometerSet=false;
	
	private float[] mR=new float[9];
	private float[] mOrientation=new float[3];
	
	private float mCurrentDegree=0f;
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set as fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);;
		
		//end of set fullscreen
		
		setContentView(R.layout.activity_compass);
		
		Button BackToHome=(Button) findViewById(R.id.BackHomeBtnOnCompass);
		BackToHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent GoBackHome=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(GoBackHome);
				
			}
		});
		
		mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
		mAccelerometer=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mMagnetometer=mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		mPointer=(ImageView) findViewById(R.id.pointer);
		
			
	}
	
	protected void onResume()
	{
		super.onResume();
		mSensorManager.registerListener(this, mAccelerometer,SensorManager.SENSOR_DELAY_GAME);
		mSensorManager.registerListener(this, mMagnetometer,SensorManager.SENSOR_DELAY_GAME);
	}

	protected void onPause()
	{
		super.onPause();
		mSensorManager.unregisterListener(this, mAccelerometer);
		mSensorManager.unregisterListener(this, mMagnetometer);
		
	}
	
	
	@Override
	public void onSensorChanged(SensorEvent event)
	{
		if(event.sensor==mAccelerometer)
		{
			System.arraycopy(event.values, 0, mLastAccelerometer, 0, event.values.length);
			mLastAccelerometerSet=true;
			
		}
		
		else if (event.sensor==mMagnetometer)
		{
			System.arraycopy(event.values, 0, mLastMagnetometer, 0, event.values.length);
			mLastMagnetometerSet=true;
			
		}
		
		if(mLastAccelerometerSet && mLastMagnetometerSet)
		{
			
			SensorManager.getRotationMatrix(mR, null, mLastAccelerometer, mLastMagnetometer);
			SensorManager.getOrientation(mR, mOrientation);
			
			float AzimuthinRadians=mOrientation[0];
			float AzimuthinDegrees=(float) (Math.toDegrees(AzimuthinRadians)+360);
			
			RotateAnimation ra=new RotateAnimation(mCurrentDegree,-AzimuthinDegrees,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
			
			ra.setDuration(250);
			ra.setFillAfter(true);
			
			mPointer.startAnimation(ra);
			mCurrentDegree =-AzimuthinDegrees;
			
		}
		
	}
	
	
	@Override
	public void onAccuracyChanged(Sensor sensor ,int accuracy)
	{
		//noteToself-Nothing to do yet.develop something here too..
	}
	
	
	
/*	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compass, menu);
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
