package team.innovators.k.a.t.e;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.RelativeLayout;


import com.facebook.shimmer.ShimmerFrameLayout;


public class LockScreen extends Activity {
	
	private ShimmerFrameLayout mShimViewContainer;
	private long ms=0;
	private long splashDuration=3000;
	private boolean splashActive=true;
	private boolean paused=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//starting lockscreen service
		
		startService(new Intent(this,LockScreenService.class));
				
		makeFullScreen();
		
//		RelativeLayout layoutBg=(RelativeLayout) findViewById(R.id.layoutBg);
//		layoutBg.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
//		layoutBg.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
				
		setContentView(R.layout.activity_lock_screen);
		
//		mShimViewContainer=(ShimmerFrameLayout) findViewById(R.id.mShimViewContainer);
//		onShimStart();
/*		
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
					Intent neIntent=new Intent(LockScreen.this,LockScreen.class);
					startActivity(neIntent);
				}
				
			}
		};
		
		splashThread.start();
		
*/		
		
		
//		final RelativeLayout layoutBg=(RelativeLayout) findViewById(R.id.layoutBg);
		
		
		SeekBar gotoMic=(SeekBar) findViewById(R.id.gotoMicSeek);
		gotoMic.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// nothing 4 here
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// nothin 4 here
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				if(seekBar.getProgress()>95){
					gotoMic(null);
					
					
				}
				else{
					Toast.makeText(getApplicationContext(), "Move Slider Until It Reaches The End..", Toast.LENGTH_LONG).show();
					seekBar.setProgress(0);
				}
				
			}
			
		});
		
		SeekBar mSlide=(SeekBar) findViewById(R.id.unlockSeek);
		
		
		mSlide.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			
			@Override
			public void onStopTrackingTouch(SeekBar seekbar){
				if(seekbar.getProgress()>95){
					unlockScreen(null);
					
					//Toast.makeText(getApplicationContext(), "sssss", Toast.LENGTH_SHORT).show();
					
				}
				else{
					Toast.makeText(getApplicationContext(), "To Unlock, Move Slider Until It Reaches The End..", Toast.LENGTH_LONG).show();
					seekbar.setProgress(0);
				/*	float ii=seekbar.getProgress();
					for(int i=40;i<60;i++){
						if(ii<70){
						layoutBg.setAlpha((100-ii)/100);
						
						}
						
						seekbar.setProgress(0);
						layoutBg.setAlpha(1);
					}  */
					//seekbar.setThumb(getResources().getDrawable(R.drawable.ic_launcher));
					//seekbar.setProgress(0);
				}
			}
			
			@Override
	        public void onStartTrackingTouch(SeekBar seekBar) {


	        }

	        @Override
	        public void onProgressChanged(SeekBar seekBar, int progress,
	                boolean fromUser) {
	            if(progress>95){
	                seekBar.setThumb(getResources().getDrawable(R.drawable.ic_launcher));
	            }

	        }
			
		});
		
		
		
		
		
		
		
		
//		mShimViewContainer=(ShimmerFrameLayout) findViewById(R.id.mShimViewContainer);
//		onStart();
		
		//make this view fullscreen.function here
		
		
	}
	
	public void makeFullScreen(){
		
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(Build.VERSION.SDK_INT < 19) { //View.SYSTEM_UI_FLAG_IMMERSIVE is only on API 19+
            this.getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else {
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LOW_PROFILE);
        }
		
	}
	
	
/*	
	public void onShimStart(){
		mShimViewContainer.getAnimation();
		mShimViewContainer.animate();
		mShimViewContainer.setDuration(3000);
		//mShimViewContainer.useDefaults();
		boolean isPlaying=mShimViewContainer.isAnimationStarted();
		
		if(isPlaying)
		{
			mShimViewContainer.startShimmerAnimation();
		}
	}

*/	
	
	@Override
	public void onBackPressed(){
		return;
	}

	public void unlockScreen(View view){
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
	public void gotoMic(View view){
		Intent mic=new Intent(LockScreen.this,TalkWithMe.class);
		startActivity(mic);
	}






}
