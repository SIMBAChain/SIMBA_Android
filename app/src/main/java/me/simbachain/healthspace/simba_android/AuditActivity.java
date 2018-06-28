package me.simbachain.healthspace.simba_android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuditActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit);


        //Loading bar for aesthetic purposes
        progressDialog = new ProgressDialog(AuditActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        OkHttpClient httpClient = new OkHttpClient.Builder().build();

        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ArrayAdapterFactory()).create();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(TitleScreen.baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson));

        Retrofit retrofit = builder.client(httpClient).build();

        final SimbaClient client = retrofit.create(SimbaClient.class);

        Call<List<GetSimba>> call = client.getAudits();

        Button toBack = findViewById(R.id.back_button);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        //Requests all data from from the audits page
        call.enqueue(new Callback<List<GetSimba>>() {
            @Override
            public void onResponse(Call<List<GetSimba>> call, Response<List<GetSimba>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<GetSimba>> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println(t);
                Toast.makeText(AuditActivity.this, "Something went wrong. Check your internet connection."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //Goes back to the title screen
        toBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AuditActivity.this, TitleScreen.class));
            }
        });
    }


    //First takes the list, reverses it, and cuts off the last part, leaving the last ten audits
    //Then sends data to the SimbaAdapter to parse for the RecyclerView
    public void generateDataList(List<GetSimba> dataList) {
        Collections.reverse(dataList);
        dataList.subList(11, dataList.size()).clear();
        mAdapter = new SimbaAdapter(this, dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AuditActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
