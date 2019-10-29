package com.tom.guess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText number;
    int counter;
    TextView speak;
    TextView Please;
    int num;
    Random random = new Random();
    int secret = random.nextInt(10)+1;
    private TextView edCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button button = findViewById(R.id.button);
        setSupportActionBar(toolbar);
        edCounter = findViewById(R.id.counter);
        edCounter.setText(counter + "");
        number = findViewById(R.id.number);
        speak = findViewById(R.id.speak);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void guess (View view){
        int num = Integer.parseInt(number.getText().toString());
        counter++;
        edCounter.setText(counter + "");

        if (secret > num){
            speak.setText("bigger");
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("hahah")
                    .setMessage("Biggr")
                    .setPositiveButton("ok", null)
                    .show();
        }else if(secret < num) {
              speak.setText("smaller");
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("hahah")
                    .setMessage("smaller")
                    .setPositiveButton("ok", null)
                    .show();
        }else if(secret == num){
            speak.setText("right");

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("hahah")
                    .setMessage("jo jo")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            secret = random.nextInt(10)+1;
                            counter = 0;
                        }
                    })
                    .show();
        }
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
