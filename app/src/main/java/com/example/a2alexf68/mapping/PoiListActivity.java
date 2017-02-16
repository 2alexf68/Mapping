package com.example.a2alexf68.mapping;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PoiListActivity extends ListActivity {

    String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_poi_list);
        data = new String[] { "Firefox", "Chrome", "Internet Explorer" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView lv, View view, int index, long id)
    {
        // handle list item selection
    }

}

