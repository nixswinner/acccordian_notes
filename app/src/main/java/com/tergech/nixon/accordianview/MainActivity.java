package com.tergech.nixon.accordianview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
               /* Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                        .show();*/
                //passing data to the display activity
                String data=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                String topichead=listDataHeader.get(groupPosition);

                Intent intent=new Intent(MainActivity.this,display.class);
                intent.putExtra("data",data);
                intent.putExtra("topichead",topichead);
                startActivity(intent);
                return false;
            }
        });
    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Topic 1");
        listDataHeader.add("Topic 2");
        listDataHeader.add("Topic 3");
        listDataHeader.add("Topic 4");
        listDataHeader.add("Topic 5");
        listDataHeader.add("Topic 6");
        // Adding child data
        List<String> Topic1 = new ArrayList<String>();
        Topic1.add("SubTopic 1.1");
        Topic1.add("SubTopic 1.2");
        Topic1.add("SubTopic 1.3");
        Topic1.add("SubTopic 1.4");
        Topic1.add("SubTopic 1.5");
        Topic1.add("SubTopic 1.6");
        Topic1.add("SubTopic 1.7");

        List<String> Topic2 = new ArrayList<String>();
        Topic2.add("SubTopic 2.1");
        Topic2.add("SubTopic 2.2");
        Topic2.add("SubTopic 2.3");
        Topic2.add("SubTopic 2.4");
        Topic2.add("SubTopic 2.5");
        Topic2.add("SubTopic 2.6");

        List<String> Topic3 = new ArrayList<String>();
        Topic3.add("SubTopic 3.1");
        Topic3.add("SubTopic 3.2");
        Topic3.add("SubTopic 3.3");
        Topic3.add("SubTopic 3.4");
        Topic3.add("SubTopic 3.5");

        List<String> Topic4 = new ArrayList<String>();
        Topic4.add("SubTopic 4.1");
        Topic4.add("SubTopic 4.2");
        Topic4.add("SubTopic 4.3");
        Topic4.add("SubTopic 4.4");
        Topic4.add("SubTopic 4.5");

        List<String> Topic5 = new ArrayList<String>();
        Topic5.add("SubTopic 5.1");
        Topic5.add("SubTopic 5.2");
        Topic5.add("SubTopic 5.3");
        Topic5.add("SubTopic 5.4");
        Topic5.add("SubTopic 5.5");

        List<String> Topic6 = new ArrayList<String>();
        Topic6.add("SubTopic 6.1");
        Topic6.add("SubTopic 6.2");
        Topic6.add("SubTopic 6.3");
        Topic6.add("SubTopic 6.4");
        Topic6.add("SubTopic 6.5");

        listDataChild.put(listDataHeader.get(0), Topic1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Topic2);
        listDataChild.put(listDataHeader.get(2), Topic3);
        listDataChild.put(listDataHeader.get(3), Topic4);
        listDataChild.put(listDataHeader.get(4), Topic5);
        listDataChild.put(listDataHeader.get(5), Topic6);
    }

}
