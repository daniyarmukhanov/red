package kz.artlines.okie;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class ChangeProfile extends ActionBarActivity {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater li = LayoutInflater.from(this);
        final View customView = li.inflate(R.layout.my_action_bar, null);
        ImageButton leftmenu= (ImageButton) customView.findViewById(R.id.item1);
        TextView title=(TextView)customView.findViewById(R.id.title);
        title.setText("Изменить профиль");
        spinner=(Spinner)customView.findViewById(R.id.leftmenu);
        leftmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.performClick();

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==1){
                    startActivity(new Intent(ChangeProfile.this, CreateTus.class));
                }
                if (position==2){
                    startActivity(new Intent(ChangeProfile.this, MainActivity.class));
                }
                if (position==3){
                    startActivity(new Intent(ChangeProfile.this, Chat.class));
                }
                if (position==4){
                    startActivity(new Intent(ChangeProfile.this, Profile.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        actionBar.setCustomView(customView);
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
            startActivity(new Intent(this,ChangeProfile.class));
            return true;
        }else if(id==R.id.change_pass){
            startActivity(new Intent(this,ChangePassword.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
