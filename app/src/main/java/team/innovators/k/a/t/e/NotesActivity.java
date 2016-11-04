package team.innovators.k.a.t.e;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

//import com.example.lknotepad.R;

//import android.app.*;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;


public class NotesActivity extends Activity {

	private String fileName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes);
		
		//back home button
		
		Button BackToHome=(Button) findViewById(R.id.returnHomefromNotepad);
		BackToHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent GoBackHome=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(GoBackHome);
				
			}
		});
		
		
		
		
		
		
		final EditText textdata=(EditText) findViewById(R.id.txtRegEmail);
		textdata.setHint("Write here");
		//textdata.setHintTextColor(colors);
		
		Button savetext=(Button) findViewById(R.id.savebtn);
		savetext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				AlertDialog.Builder save = new AlertDialog.Builder(NotesActivity.this);
				save.setTitle("Save as..");
				save.setMessage("Choose File Name");
				final EditText filename=new EditText(NotesActivity.this);
				save.setView(filename);
				//fileName.equals(filename);
				
				save.setPositiveButton("Save", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						String srt=filename.getEditableText().toString();
						String folderKate="My Notes";
						String kateMain="KATE";
						
						//File myFile=new File(Environment.getExternalStoragePublicDirectory(srt)+".txt");
						File mkFolder = new File(Environment.getExternalStoragePublicDirectory(kateMain), folderKate);
						if(!mkFolder.exists()){
							mkFolder.mkdirs();
						}
		//				File mkSubFolderNotes=new File(Environment.getExternalStoragePublicDirectory(folderKate)+"/"+kateMain,folderKate);
		//				if(!mkSubFolderNotes.exists()){
		//					mkSubFolderNotes.mkdirs();
		//				}
						
						//Environment.getExternalStoragePublicDirectory("/sdcard/kate/");
						
						
						//File myFile=new File(Environment.getExternalStoragePublicDirectory(kateMain),srt+".txt");
						File myFile=new File(Environment.getExternalStoragePublicDirectory(kateMain)+"/"+folderKate,srt+".txt");
						
						
						try{
						myFile.createNewFile();
						FileOutputStream fOut=new FileOutputStream(myFile);
						OutputStreamWriter myWriter=new OutputStreamWriter(fOut);
						myWriter.append(textdata.getText());
						myWriter.close();
						fOut.close();
						Toast.makeText(getBaseContext(),"File Saved in My Files", Toast.LENGTH_LONG).show();
						}
						
						catch(Exception e){
							
							Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
						}
					}
				});
				
				save.show();
				
			}
		});
		
		
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notes, menu);
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
