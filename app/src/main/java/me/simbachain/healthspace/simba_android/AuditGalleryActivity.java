package me.simbachain.healthspace.simba_android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuditGalleryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] accounts = new String[]{"0xb1db8a003114ee270207e8812a009f108b41f625", "0x9ccd1bb0d58a9ce5db012ff74967edb371a91457",
            "0x0a69fcf74245459a1883485a4e4f23bb3b552370", "0x442fd3df4845b53afa13eae0051429b912bb4205",
            "0x818ce4fb076ef541457f22b955af6bfa046c6e37", "0x2ba1d9aba1f0b1b12ad1b48a9c7cf327f1d17180",
            "0xad267928e21fe2bdd09417b20b6b8b0fa767c453", "0x4324ca587090d5d77942531cc18adde45836dd25",
            "0x647102ec4e63f571971e75ba4c5493a636af08bc", "0xd8e00bdfc99738a223db7821281d52de59c25b05"};
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_gallery);

        Button toBack = findViewById(R.id.back_button);
        Spinner userID = findViewById(R.id.user_id);

        progressDialog = new ProgressDialog(AuditGalleryActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        android.widget.ArrayAdapter<CharSequence> userAdapter = ArrayAdapter.createFromResource(this, R.array.user_accounts,
                android.R.layout.simple_spinner_item);
        userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        userID.setAdapter(userAdapter);

        userID.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        getIncomingIntent();

        //Goes back to the title screen
        toBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AuditGalleryActivity.this, AuditActivity.class));
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        TitleScreen.accountID = accounts[pos];
        Toast.makeText(this, "Your Accound ID is: " + TitleScreen.accountID, Toast.LENGTH_LONG).show();
        Log.i("PostActivity", "ID is " + TitleScreen.accountID);
    }
    public void onNothingSelected(AdapterView<?> parent) {}

    private void getIncomingIntent() {
        if(getIntent().hasExtra("audit_no") && getIntent().hasExtra("ipfc")) {

            int auditNumber = getIntent().getIntExtra("audit_no", 0);
            String IPFC = getIntent().getStringExtra("ipfc");

            OkHttpClient httpClient = new OkHttpClient.Builder().build();

            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ArrayAdapterFactory()).create();

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("http://healthspace.simbachain.me/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson));

            Retrofit retrofit = builder.client(httpClient).build();

            final SimbaClient client = retrofit.create(SimbaClient.class);

            setIncomingIntent(auditNumber, IPFC);
            Call<List<GetSimba>> call = client.getAuditItems(auditNumber);

            call.enqueue(new Callback<List<GetSimba>>() {
                @Override
                public void onResponse(Call<List<GetSimba>> call, Response<List<GetSimba>> response) {
                    progressDialog.dismiss();
                    generateData(response.body());
                }

                @Override
                public void onFailure(Call<List<GetSimba>> call, Throwable t) {
                    progressDialog.dismiss();
                    System.out.println(t);
                    Toast.makeText(AuditGalleryActivity.this, "Something went wrong. " +
                                    "Check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void setIncomingIntent(int audit, String ipfc) {

        TextView auditNumber = findViewById(R.id.editAuditNumber);
        TextView IPFC = findViewById(R.id.editIPFS);

        auditNumber.setText(audit+"");
        IPFC.setText(ipfc);
    }
    public void generateData(List<GetSimba> dataList) {
        TextView posterID = findViewById(R.id.editPosterID);
        TextView timestamp = findViewById(R.id.editTimeStamp);
        TextView location = findViewById(R.id.editLocation);
        TextView name = findViewById(R.id.editName);
        TextView description = findViewById(R.id.editDescription);
        TextView status = findViewById(R.id.editStatus);
        TextView comments = findViewById(R.id.editComment);

        posterID.setText(dataList.get(0).getAuditor());
        timestamp.setText(dataList.get(0).getAsset().getTimestamp());
        location.setText(dataList.get(0).getAsset().getLocation());
        name.setText(dataList.get(0).getAsset().getPersonName());
        description.setText(dataList.get(0).getAsset().getItems().get(0).getDescription());
        status.setText(dataList.get(0).getAsset().getItems().get(0).getStatus());
        comments.setText(dataList.get(0).getAsset().getItems().get(0).getComments());
    }
}
