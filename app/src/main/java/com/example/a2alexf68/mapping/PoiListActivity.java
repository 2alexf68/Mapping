package com.example.a2alexf68.mapping;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PoiListActivity extends ListActivity {

    String[] details,names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_poi_list);
        names = new String[] {"Cycling", "Regular"};
        details = new String[]  {"Cycling path","Highway"};
        MyAdapter adapter = new MyAdapter();
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView lv, View view, int index, long id)
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        boolean cyclemap = false;

        if (index == 0)
        {
            cyclemap = true;
        }

        bundle.putBoolean("com.example.cyclemap", cyclemap);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
    public class MyAdapter extends ArrayAdapter<String>
    {
        public MyAdapter() {
            // We have to use ExampleListActivity.this to refer to the outer class (the activity)
            super(PoiListActivity.this, android.R.layout.simple_list_item_1, names);
        }

        public View getView(int index, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_poi_list, parent, false);
            }
            TextView title = (TextView) view.findViewById(R.id.poi_name), detail =
                    (TextView) view.findViewById(R.id.poi_desc);
            title.setText(names[index]);
            detail.setText(details[index]);
            return view;
        }
    }
}

