package com.example.a2alexf68.mapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;


/**
 * Created by 2alexf68 on 09/02/2017.
 */
public class MapChooseActivity extends Activity implements View.OnClickListener {



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mca);

        Button regular = (Button)findViewById(R.id.btnRegular);
        regular.setOnClickListener(this);

        Button cyclemap = (Button)findViewById(R.id.btnCyclemap);
        cyclemap.setOnClickListener(this);
    }
    public void onClick(View view)
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        boolean cyclemap = false;

        if (view.getId() == R.id.btnCyclemap)
        {
            cyclemap = true;
        }

        bundle.putBoolean("com.example.cyclemap", cyclemap);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

}
