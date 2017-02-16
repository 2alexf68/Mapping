package com.example.a2alexf68.mapping;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.osmdroid.config.Configuration;
import android.content.Intent;
/**
 * Created by 2alexf68 on 09/02/2017.
 */
    public class SetLocation extends Activity implements View.OnClickListener
{
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

    @Override
    public void onClick(View view) {
        EditText latitudeEditText = (EditText)findViewById(R.id.latitudeEditText);
        String latitudeAsString = latitudeEditText.getText().toString();

        EditText longitudeEditText = (EditText)findViewById(R.id.longitudeEditText);
        String longitudeAsString = longitudeEditText.getText().toString();

        Button b = (Button) findViewById(R.id.locationButton);
        b.setOnClickListener(this);

        double latitude = Double.parseDouble(latitudeAsString);
        double longitude = Double.parseDouble(longitudeAsString);

        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        bundle.putDouble("com.example.coordinate", latitude);
       // bundle.putDouble("com.example.coordinate", longitude);

        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
