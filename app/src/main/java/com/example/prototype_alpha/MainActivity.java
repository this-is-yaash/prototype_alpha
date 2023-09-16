package com.example.prototype_alpha;

import androidx.appcompat.app.AppCompatActivity;
import com.example.prototype_alpha.utilities.FabAnimationUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.prototype_alpha.utilities.BackPressedHandler;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private ExtendedFloatingActionButton fab1, fab2;
    private FabAnimationUtil fabAnimationUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);

        fabAnimationUtil = new FabAnimationUtil(this, fab, fab1, fab2);

        //Floating Action button action are here fab,fab1,fab2
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAnimationUtil.animateFab();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle fab1 settings FAB'btn click action here
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
                fabAnimationUtil.animateFab();
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle fab2 backup FAB'btn click action here
                Intent backupIntent = new Intent(MainActivity.this, BackupActivity.class);
                startActivity(backupIntent);
                fabAnimationUtil.animateFab();
                Toast.makeText(MainActivity.this, "Backup", Toast.LENGTH_SHORT).show();

            }
        });
    }

    //for implementing the menu in the  toolbar (for now it has Search icon with searchbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //prompt before exiting app triggered by pressing back button
    @Override
    public void onBackPressed() {
        BackPressedHandler.onBackPressed(this);
    }
}