package com.example.prakriti.ecommercedemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         new ProductAsyncTask().execute();





    }
    class ProductAsyncTask extends AsyncTask<String, String, String> {
        ProgressDialog mprogressDialog;
        RecyclerView mrecyclerView;
        int flag;
        List<MyData> data_list = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogressDialog = new ProgressDialog(MainActivity.this);
            mprogressDialog.setMessage("Please wait");
            mprogressDialog.setCancelable(false);
            mprogressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> loginHashMap = new HashMap<>();
            JsonParser jsonParser = new JsonParser();
            JSONObject jsonObject = jsonParser.performPostCI("http://telemart.com.np/api/android/categories.php", loginHashMap);
            String request = "";


            try {
                if (jsonObject == null) {
                    flag = 1;
                } else if (jsonObject.getString(request).equals(request)) {
                    JSONArray jsonArray=jsonObject.getJSONArray(request);
                    for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            Integer id = object.getInt("id");
                            String name = object.getString("name");
                            String slug = object.getString("slug");
                            Integer parent = object.getInt("parent");
                            String description = object.getString("description");
                            String display = object.getString("display");

                            // Image node is JSON Object
                            JSONObject image = object.getJSONObject("image");
                            Integer image_id  = image.getInt("id");
                            String date_created = image.getString("date_created");
                            String date_created_gmt =image.getString("date_created_gmt");
                            String date_modified =image.getString("date_modified");
                            String date_modified_gmt =image.getString("date_modified_gmt");
                            String src =image.getString("src");
                            String title =image.getString("title");
                            String alt =image.getString("alt");


                            //same as above
                            Integer menu_order = object.getInt("menu_order");
                            Integer count = object.getInt("count");

                            JSONObject _links = object.getJSONObject("_links");

                            JSONArray self = _links.getJSONArray("self");

                            String self_href = self.getJSONObject(i).getString("href");

                            JSONArray collection = _links.getJSONArray("collection");

                            String collection_href = collection.getJSONObject(i).getString("href");





                            //String character = FoodArray.getJSONObject(i).getString("char");
                            //   JSONArray Self = object.getJSONArray("self");
                            //  for (int i = 0; i < Self.length(); i++) {

                            //     String character = Self.getJSONObject(i).getString("href");

                            //   JSONObject status = response.getJSONObject("status");


                            MyData myData= new MyData(id, count, menu_order, parent,image_id,name, slug, description, display,date_created, date_created_gmt, date_modified,date_modified_gmt, src, title, alt, self_href, collection_href);

                            data_list.add(myData);

                            Log.e("donkey", "sam");

                    }

                }
                else {
                    flag = 3;
                }

            } catch (JSONException e) {

            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mprogressDialog.dismiss();
            if (flag == 1) {
                Toast.makeText(MainActivity.this, "Server/Network issue", Toast.LENGTH_SHORT).show();

            } else if (flag == 2) {
                //mAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                mrecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

                GridLayoutManager mGrid = new GridLayoutManager(MainActivity.this,1);
                mrecyclerView.setLayoutManager(mGrid);
                mrecyclerView.setHasFixedSize(true);
                CustomAdapter mAdapter = new CustomAdapter(MainActivity.this, data_list );
                mrecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }


        }

    }

}