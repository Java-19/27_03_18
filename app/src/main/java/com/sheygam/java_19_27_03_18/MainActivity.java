package com.sheygam.java_19_27_03_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] names = {
            "Name 1",
            "Name 2",
            "Name 3",
            "Name 4",
            "Name 5",
            "Name 6",
            "Name 7",
            "Name 8",
            "Name 9",
            "Name 10",
            "Name 11",
            "Name 12",
            "Name 13",
            "Name 14",
            "Name 15"
    };
    private ListView myList;
    private MenuItem addItem, refreshItem;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.my_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
//        myList.setAdapter(adapter);
//        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Was clicked " + names[position], Toast.LENGTH_SHORT).show();
//            }
//        });
        adapter = new MyAdapter(this);
//        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User current = (User) adapter.getItem(position);
                Toast.makeText(MainActivity.this, "Was clicked " + current.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        myList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        addItem = menu.findItem(R.id.add_item);
        refreshItem = menu.findItem(R.id.refresh_item);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings_item){
            Toast.makeText(this,"Was clicked settings",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.add_item){
            Toast.makeText(this, "Was clicked add", Toast.LENGTH_SHORT).show();
//            addItem.setVisible(false);
//            refreshItem.setVisible(true);
            adapter.addUser(new User("Vasya","vasya@mail.com"));
        }else if(item.getItemId() == R.id.refresh_item){
            addItem.setVisible(true);
            refreshItem.setVisible(false);
        }
        return super.onOptionsItemSelected(item);
    }
}
