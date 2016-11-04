package team.innovators.k.a.t.e;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import ocr.image.ImageActivity;

public class HomeActivity extends Activity {
    Button kate,ocr,location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        kate=(Button)findViewById(R.id.kate);
        ocr=(Button)findViewById(R.id.ocr);
        location=(Button)findViewById(R.id.location);

        kate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,SplashActivity.class);
                startActivity(intent);
            }
        });
        ocr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,ImageActivity.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,LockerActivity.class);
                startActivity(intent);
            }
        });
    }
}
