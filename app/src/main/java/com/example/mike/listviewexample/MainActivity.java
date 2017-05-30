package com.example.mike.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is a list of items going in the list view
        String[] items = {"pencil", "pen", "floor", "wall", "flipflop", "candy"};
        //FOR THE CUSTOM VIEW
        //ListAdapter listAdapter = new CustomAdapter(this, items);
        //FOR THE NORMAL VIEW
        //adapter to convert for example string java code to list items
        //converting an array to list items             //this object //how do you want them formatted  //form where(the array above)
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        //reference to the listView
        ListView listView = (ListView)findViewById(R.id.listView);
        //which/how do you want to adapt listAdapter
        listView.setAdapter(listAdapter);

        //looks for when you click on that list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //gets the item name of the item they tapped
                String item = String.valueOf(parent.getItemAtPosition(position));
                //displaying what they tapped
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
