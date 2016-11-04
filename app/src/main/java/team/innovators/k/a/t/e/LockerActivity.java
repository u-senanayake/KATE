package team.innovators.k.a.t.e;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LockerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locker);
		SetNotification();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.locker, menu);
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



//notification

public void SetNotification(){
	
	NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
	
	Intent notif=new Intent(this,MainActivity.class);
	notif.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
	PendingIntent pInt=PendingIntent.getActivity(this, 0, notif, PendingIntent.FLAG_UPDATE_CURRENT);
	builder.setContentIntent(pInt);
	
	builder.setTicker(getResources().getString(R.string.locker_notif_ticker));
	
	builder.setSmallIcon(R.drawable.notification_small);
	
	builder.setAutoCancel(false);
	
	builder.setOnlyAlertOnce(true);
	
	builder.setContentTitle(getResources().getString(R.string.locker_notification_title));
	builder.setContentText(getResources().getString(R.string.locker_notification_text));
	
	Notification Crnotif=builder.build();
	
	NotificationManager show=(NotificationManager) 
				getSystemService(NOTIFICATION_SERVICE);
	show.notify(0, Crnotif);
	
	
}

public void showNotificationClicked(View v) {
    SetNotification();
}

//end notification



}