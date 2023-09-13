package com.example.prototype_alpha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import kotlin.Lazy;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab, fab1, fab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false; //default false
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab =(FloatingActionButton) findViewById(R.id.fab);
        fab1 =(FloatingActionButton) findViewById(R.id.fab1);
        fab2 =(FloatingActionButton) findViewById(R.id.fab2);

        //animations here...
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this ,R.anim.rotate_backward);

        //click listener here...for fab which is the add floatbtn
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                animateFab();
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(MainActivity.this, "Backup", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void animateFab(){
        if(isOpen){
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen =false;
        } else {
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen =true;
        }
    }
    //for implementing the menu in the  toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


}