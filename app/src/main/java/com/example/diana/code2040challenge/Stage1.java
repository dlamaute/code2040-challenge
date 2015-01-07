package com.example.diana.code2040challenge;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.content.Intent;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class Stage1 extends Activity {

    private TextView orig;
    private TextView ans;  //add to layout first
    private String str = "There has been an error.";

    private String url;
    private String token;

    private String res = "There has been an error.";

    private static String revString(String st){
        int i, len = st.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(st.charAt(i));
        }
        return dest.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage1);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        //JSONObject request = new JSONObject();
        final App app = (App) getApplicationContext();

        url = app.getUrl();
        token = app.getToken();

        orig  = (TextView) findViewById(R.id.orig_text);
        ans = (TextView) findViewById(R.id.resp_text);

        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                JSONObject request = new JSONObject();
                try { request.put("token", token); }
                catch (JSONException e){ e.printStackTrace(); }
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(url + "getstring");


                try {
                    StringEntity se = new StringEntity(request.toString());
                    //se.setContentType("application/json;charset=UTF-8");
                    post.setEntity(se);
                    String thing1 = EntityUtils.toString(post.getEntity());
                    HttpResponse response = client.execute(post);
                    String thing = EntityUtils.toString(response.getEntity());
                    JSONObject jObj = new JSONObject(thing);
                    str = jObj.getString("result");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e){
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                // Notifies UI when the task is done
                orig.setText(str);
                res = revString(str);
                ans.setText(res);
            }
        }.execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent upIntent = new Intent(this, MainActivity.class);
                this.startActivity(upIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
