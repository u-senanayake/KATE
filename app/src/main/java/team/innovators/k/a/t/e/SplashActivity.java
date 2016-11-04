package team.innovators.k.a.t.e;

import com.facebook.shimmer.ShimmerFrameLayout;

import android.app.Activity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.content.Intent;


public class SplashActivity extends Activity {

	private ShimmerFrameLayout mShimViewContainer;
	private long ms=0;
	private long splashDuration=3000;
	private boolean splashActive=true;
	private boolean paused=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		startService(new Intent(this,LockScreenService.class));
		
		mShimViewContainer=(ShimmerFrameLayout) findViewById(R.id.mShimViewContainer);
		onStart();
		
		
		Thread splashThread=new Thread(){
			public void run(){
				
				try{
					while(splashActive && ms<splashDuration){
						if(!paused){
							ms=ms+100;
							sleep(100);
						}
					}
				}
				catch(Exception ex){
					
				}
				finally{
					Intent neIntent=new Intent(SplashActivity.this,MainActivity.class);
					startActivity(neIntent);
				}
				
			}
		};
		
		splashThread.start();
		
	}
	
	
	
	public void onStart(View view)
	{
		int time=2000;
		//mShimViewContainer.onCre
				mShimViewContainer.getAnimation();
				mShimViewContainer.setDuration(time);
				mShimViewContainer.animate();
				
				
				boolean isPlaying=mShimViewContainer.isAnimationStarted();
				
				if(isPlaying)
				{
					mShimViewContainer.startShimmerAnimation();
				}
	}
	

	
	@Override
	protected void onResume()
	{
		super.onResume();
		mShimViewContainer.startShimmerAnimation();
	}
	
	@Override
	protected void onPause()
	{
		mShimViewContainer.stopShimmerAnimation();
		super.onPause();
		
	}
	
	


	
	
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
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
