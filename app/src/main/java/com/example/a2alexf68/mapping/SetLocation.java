package com.example.a2alexf68.mapping;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
/**
 * Created by 2alexf68 on 09/02/2017.
 */
    public class SetLocation extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.set_location);

            Button submitButton = (Button) findViewById(R.id.submitButton);
            submitButton.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        //retrieve our lat and long values from the edit boxes
        EditText latitudeEditText = (EditText)findViewById(R.id.latitudeEditText);
        double latitude = Double.parseDouble(latitudeEditText.getText().toString());

        //double.parsedouble() allows to transform a string into a double type
        EditText longitudeEditText = (EditText)findViewById(R.id.longitudeEditText);
        double longitude =Double.parseDouble(longitudeEditText.getText().toString());

        //assemble our lat long bundle
        Bundle latlongBundle = new Bundle();
        latlongBundle.putDouble("com.example.latitude", latitude);
        latlongBundle.putDouble("com.example.longitude", longitude);

        //gives the box which contains information; send the bundle to the parent activity
        Intent intent = new Intent();
        intent.putExtras(latlongBundle);
        //if it arrives at this part of the code send the message that everything is okay
        setResult(RESULT_OK,intent);
        finish();
    }
}
