package com.example.a2alexf68.mapping;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.config.Configuration;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.*;


public class HelloMap extends Activity implements OnClickListener
{

    MapView mv;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(5);
        mv.getController().setCenter(new GeoPoint(40.1,22.5));

        Button b = (Button) findViewById(R.id.locationButton);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText LatitudeEditText = (EditText)findViewById(R.id.LatitudeEditText);
        String Latitude1AsString = LatitudeEditText.getText().toString();

        EditText LongitudeEditText = (EditText)findViewById(R.id.LongitudeEditText);
        String Longitude1AsString = LongitudeEditText.getText().toString();

        if(LongitudeEditText.equals("") & LatitudeEditText.equals(""))
        {
            mv.getController().setCenter(new GeoPoint (40.1,22.5));
            mv.getController().setZoom(4);
        } else {
            double Latitude1 = Double.parseDouble(Latitude1AsString);
            double Longitude1 = Double.parseDouble(Longitude1AsString);

            mv.getController().setCenter(new GeoPoint(Longitude1, Latitude1));
        }

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}