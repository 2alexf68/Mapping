package com.example.a2alexf68.mapping;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
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


public class HelloMap extends Activity implements OnClickListener
{

    MapView mv;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);
        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(10);
        mv.getController().setCenter(new GeoPoint(41.1,12.1));

        Button b = (Button) findViewById(R.id.locationButton);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText latitudeEditText = (EditText)findViewById(R.id.latitudeEditText);
        String latitudeAsString = latitudeEditText.getText().toString();

        EditText longitudeEditText = (EditText)findViewById(R.id.longitudeEditText);
        String longitudeAsString = longitudeEditText.getText().toString();

        if(latitudeAsString.isEmpty() || longitudeAsString.isEmpty())
        {
            mv.getController().setCenter(new GeoPoint (41.1,12.1));
            mv.getController().setZoom(5);
        } else {
            double latitude = Double.parseDouble(latitudeAsString);
            double longitude = Double.parseDouble(longitudeAsString);

            mv.getController().setCenter(new GeoPoint(longitude, latitude));
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
        if (item.getItemId() == R.id.choosemap)
        {
            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;
        }else if (item.getItemId() == R.id.set_location)
            {
                Intent intent = new Intent(this,SetLocation.class);
                startActivityForResult(intent,1);
                return true;
            }
        return false;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean cyclemap = extras.getBoolean("com.example.cyclemap");
                if(cyclemap == true)
                {
                    mv.setTileSource(TileSourceFactory.CYCLEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }
        else if (requestCode==1)
        {
           if(resultCode==RESULT_OK)
           {
               Bundle extras=intent.getExtras();
               double latitude = extras.getDouble("com.example.coordinate");
               double longitude = extras.getDouble("com.example.coordinate");
               //double latitude = Double.parseDouble();
               //double longitude = Double.parseDouble();

               mv.getController().setCenter(new GeoPoint(longitude, latitude));
           }


        }
    }
}