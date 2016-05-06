package com.example.root.curemedical;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.root.curemedical.Models.Constants;
import com.example.root.curemedical.Models.OrthopaedicsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

List<OrthopaedicsModel> list;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView=(RecyclerView)findViewById(R.id.ortho_recycleviewer);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        pd=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        callOrthopaedics();




    }

    private void callOrthopaedics() {
        pd.show();
        String url="https://gg_admin-prod.apigee.net/curegatewaytest/medicalpackages?ql=category=%27Orthopaedics%27&city=Kolkata&apikey=yqs9TA1F0s3ARnweRxVRfqeTzsBU5PPP";
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("App",response.toString());
                        setorthopaedicmodel(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                    pd.hide();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request


                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        int socketTimeout = 20000;//20 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
    }

    private void setorthopaedicmodel(String response) {

        list=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("entities");
            for(int i=0;i<jsonArray.length();i++)
            {
                OrthopaedicsModel orthopaedicsModel=new OrthopaedicsModel();
                JSONObject object=jsonArray.getJSONObject(i);


                //Multiple try and Catch so that Only One Method does not work, rest all do.
                try{
                    orthopaedicsModel.setCategory(object.getString(Constants.CATEGORY));
                }
                catch(JSONException j)
                {

                }
                try{
                    orthopaedicsModel.setDescription(object.getString(Constants.DESCRIPTION));

                }
                catch(JSONException j)
                {

                }

                try{
                    orthopaedicsModel.setId(object.getInt(Constants.ID));

                }
                catch(JSONException j)
                {

                }
                try{
                    orthopaedicsModel.setMedia(object.getString(Constants.MEDIA));

                }
                catch(JSONException j)
                {
orthopaedicsModel.setMedia("none");
                }
                try{
                    orthopaedicsModel.setName(object.getString(Constants.NAME));

                }
                catch(JSONException j)
                {
                    orthopaedicsModel.setPackagename(object.getString(Constants.PackageNAme));

                }
                try{
                    orthopaedicsModel.setProcedure(object.getString(Constants.PROCEDURE));

                }
                catch(JSONException j)
                {

                }
                try{
                    orthopaedicsModel.setResult(object.getString(Constants.RESULT));

                }
                catch(JSONException j)
                {

                }
                try{
                    orthopaedicsModel.setRisks(object.getString(Constants.RISKS));

                }
                catch(JSONException j)
                {
                  //  orthopaedicsModel.setWhen(object.getString(Constants.WHEN));

                }

                try{
                    orthopaedicsModel.setWhen(object.getString(Constants.WHEN));

                }
                catch(JSONException j)
                {


                }
                try {
                    orthopaedicsModel.setGeneralward(object.getInt(Constants.GENERALWARD));
                }
                catch(JSONException j)
                {

                }
                try {
                    orthopaedicsModel.setPrivateward(object.getInt(Constants.PRIVATEWARD));
                }
                catch(JSONException j)
                {

                }
                try {
                    orthopaedicsModel.setSemiprivate(object.getInt(Constants.SEMIPRIVATE));
                }
                catch(JSONException j)
                {

                }
                try
                {
                    orthopaedicsModel.setMaxprivateward(object.getInt(Constants.MAXPRIVATE));
                }
                catch(JSONException j)
                {

                }
                try {
                    orthopaedicsModel.setMingeneralward(object.getInt(Constants.MINGENERAL));
                }
                catch(JSONException j)
                {

                }
                    list.add(orthopaedicsModel);
            }
            Log.v("app",""+list.size());
            mAdapter=new MyAdapter(MainActivity.this,list);
            mRecyclerView.setAdapter(mAdapter);
            pd.hide();
        } catch (JSONException e) {
            e.printStackTrace();
            pd.hide();
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
