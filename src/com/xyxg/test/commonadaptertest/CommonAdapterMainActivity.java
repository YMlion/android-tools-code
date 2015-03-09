package com.xyxg.test.commonadaptertest;

import java.util.ArrayList;
import java.util.List;

import com.xyxg.tools.adapter.CommonAdapter;
import com.xyxg.tools.adapter.ViewHolder;
import com.xyxg.tools.commonadaptertest.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CommonAdapterMainActivity extends Activity {
    
    ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        listView.setAdapter(new CommonAdapter<String>(this, list, R.layout.item) {
            
            @Override
            public void getItemView(ViewHolder holder, String t) {
                holder.setText(R.id.title, t);
                holder.setImageResource(R.id.image, R.drawable.ic_launcher);
            }
        });
    }
}
