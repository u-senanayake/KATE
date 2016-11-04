package location.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import location.BaseActivityLocation;
import team.innovators.k.a.t.e.R;

public class LocationActivity extends BaseActivityLocation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }
}
