//package com.example.prakriti.ecommercedemo;
//
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// * Created by Prakriti on 8/30/2017.
// */
//
//class DetailsActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private GridLayoutManager gridLayoutManager;
//    private CustomAdapter adapter;
//    private List<MyData> data_list;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        data_list = new ArrayList<>();
//        // new FoodAsyncTask().execute();
//        load_data_from_server(0);
//
//        gridLayoutManager = new GridLayoutManager(this, 1);
//        recyclerView.setLayoutManager(gridLayoutManager);
//
//        adapter = new CustomAdapter(this, data_list);
//        recyclerView.setAdapter(adapter);
//
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                if (gridLayoutManager.findLastVisibleItemPosition() == data_list.size() - 1) {
//                    load_data_from_server(data_list.get(data_list.size() - 1).getId());
//                }
//            }
//        });
//
//    }
//    private void load_data_from_server(final int id) {
//        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {
//
//            ProgressDialog mprogressDialog;
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                mprogressDialog = new ProgressDialog(DetailsActivity.this);
//                mprogressDialog.setMessage("Please wait");
//                mprogressDialog.setCancelable(false);
//                mprogressDialog.show();
//
//            }
//
//            @Override
//            protected Void doInBackground(Integer... integers) {
//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder().url("http://192.168.1.134/script.php?id=" + id).build();
//                try {
//                    Log.e("swikriti", "sonika");
//                    Response response = client.newCall(request).execute();
//
//
//                    JSONArray array = new JSONArray(response.body().string());
//
//
//
//                    for (int i = 0; i < array.length(); i++) {
//                        JSONObject dataObject = array.getJSONObject(i);
//                        Integer id = dataObject.getInt("id");
//                        String name = dataObject.getString("name");
//                        String slug = dataObject.getString("slug");
//                        Integer parent = dataObject.getInt("parent");
//                        String description = dataObject.getString("description");
//                        String image = dataObject.getString("image");
//                        Integer count = dataObject.getInt("count");
//                        Integer menu_order = dataObject.getInt("menu_order");
//                        String display = dataObject.getString("display");
//                        String links = dataObject.getString("links");
//                        String self = dataObject.getString("self");
//                        String collection = dataObject.getString("collection");
//
//
//                        MyData myData= new MyData(id,count,menu_order,parent,name,slug,description,display,image, links, self, collection, links,self,collection);
//                        data_list.add(myData);
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (JSONException e) {
//                    System.out.println("End of Content");
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//
//                mprogressDialog.dismiss();
//                adapter.notifyDataSetChanged();
//
//            }
//        };
//        task.execute(id);
//    }
//}
//
