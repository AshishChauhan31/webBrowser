package com.example.akhilesh.webbrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        final EditText editText = findViewById (R.id.editText);
        final SearchView searchView = findViewById (R.id.searchView);
       // CharSequence query = searchView.getQuery ();
       // ListView listView = findViewById (R.id.listView);
        //listView.setOnItemClickListener (AdapterView);
               //Button button = findViewById (R.id.button);
       // button.setOnClickListener (View );

        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String s1 = editText.getText ().toString ().trim();
                if(s1.equals (""))
                {
                    Toast.makeText (MainActivity.this, "please ! enter the url", Toast.LENGTH_SHORT).show ();
                }
                else {
                    if(!s1.equals ("http://")||!s1.equals ("https://"))
                    {
                        s1="http://"+s1;
                        Intent WebIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(s1));
                        startActivity (WebIntent);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected (item);
    }
}
