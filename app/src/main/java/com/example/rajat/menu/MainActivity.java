package com.example.rajat.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttonpopup;
    TextView rajat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rajat = findViewById(R.id.rajat);
        registerForContextMenu(rajat);



        buttonpopup = findViewById(R.id.buttonpopup);
        buttonpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.item1){
                            Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
                        }else if(item.getItemId()==R.id.item2){
                            Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.item1){
            Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.item2){
            Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item1){
            Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.item2){
            Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
        }
        return true;
    }




}

