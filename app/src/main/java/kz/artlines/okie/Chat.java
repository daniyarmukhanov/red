package kz.artlines.okie;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jsonparser.JSONParser;


public class Chat extends ActionBarActivity {
    Spinner spinner;
    ListView feedView;
    List feedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater li = LayoutInflater.from(this);
        final View customView = li.inflate(R.layout.my_action_bar, null);
        ImageButton leftmenu= (ImageButton) customView.findViewById(R.id.item1);
        TextView title=(TextView)customView.findViewById(R.id.title);
        title.setText("Чат");
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
                    startActivity(new Intent(Chat.this, CreateTus.class));
                }
                if (position==2){
                    startActivity(new Intent(Chat.this, MainActivity.class));
                }
                if (position==3){
                    startActivity(new Intent(Chat.this, Chat.class));
                }
                if (position==4){
                    startActivity(new Intent(Chat.this, Profile.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        actionBar.setCustomView(customView);

        feedView = (ListView) findViewById(R.id.list);
        feedList = new ArrayList<HashMap<String, String>>();
        new ShowFeed().execute();
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
    public class ShowFeed extends AsyncTask<String, String, String> {

        private JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray;
        JSONObject jsonObject;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(Chat.this);
            progressDialog.setMessage("Loading news...");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);

        }

        @Override
        protected String doInBackground(String... str) {


            List<NameValuePair> params = new ArrayList<NameValuePair>();
          //  params.add(new BasicNameValuePair("page", "" + page));

            //jsonObject = jsonParser.makeHttpRequest("http://mukhanov.me/aqparat/allnews.php", "POST", params);

            try {
                // jsonArray = jsonObject.getJSONArray("news");
//
//                if(feedList != null && feedList.size() > 0){
//                    for(int i=0;i < feedList.size();i++)
//                      adapter.add(feedList.get(i));
//
//                }
                for (int i = 0; i < 4; i++) {
                    //JSONObject jsonObject = jsonArray.getJSONObject(i);
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("name", "Имя");
                    map.put("day", "10.05");
                    map.put("status", i%2+"");
                    map.put("lastmsg", "Че, как дела?");
                    //map.put("photo", jsonObject.getString("photo"));
                    feedList.add(map);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            ChatAdapter feedAdapter = new ChatAdapter(getBaseContext(), (ArrayList<HashMap<String, String>>) feedList);
            feedView.setAdapter(feedAdapter);



            //((PullToRefresh_Master) adsListView).onRefreshComplete();

        }
    }
}
