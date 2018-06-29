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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] accounts = new String[]{"0xb1db8a003114ee270207e8812a009f108b41f625", "0x9ccd1bb0d58a9ce5db012ff74967edb371a91457",
            "0x0a69fcf74245459a1883485a4e4f23bb3b552370", "0x442fd3df4845b53afa13eae0051429b912bb4205",
            "0x818ce4fb076ef541457f22b955af6bfa046c6e37", "0x2ba1d9aba1f0b1b12ad1b48a9c7cf327f1d17180",
            "0xad267928e21fe2bdd09417b20b6b8b0fa767c453", "0x4324ca587090d5d77942531cc18adde45836dd25",
            "0x647102ec4e63f571971e75ba4c5493a636af08bc", "0xd8e00bdfc99738a223db7821281d52de59c25b05"};
    String timeStamp;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Button toBack = findViewById(R.id.back_button);
        Spinner userID = findViewById(R.id.user_id);
        Button toPost = findViewById(R.id.postButton);

        final EditText location = findViewById(R.id.editLocation);
        final EditText name = findViewById(R.id.editName);
        final EditText description = findViewById(R.id.editDescription);
        final EditText status = findViewById(R.id.editStatus);
        final EditText comments = findViewById(R.id.editComment);


        ArrayAdapter<CharSequence> userAdapter = ArrayAdapter.createFromResource(this, R.array.user_accounts,
                android.R.layout.simple_spinner_item);
        userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        userID.setAdapter(userAdapter);

        //Goes back to the title screen
        toBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostActivity.this, TitleScreen.class));
            }
        });
        userID.setOnItemSelectedListener(this);

        //Gathers a list of data to be added to the api
        toPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(PostActivity.this);
                progressDialog.setMessage("Posting...");
                progressDialog.show();

                timeStamp = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:ms").format(new Date());
                List<Item> items = new ArrayList<>();
                items.add(new Item( description.getText().toString(),
                        status.getText().toString(),
                        comments.getText().toString()));
                PostSimba postSimba = new PostSimba(
                        TitleScreen.accountID,
                        new Asset(
                                location.getText().toString(),
                                timeStamp,
                                name.getText().toString(),
                                items
                        )
                );
                sendAudit(postSimba);
            }
        });
    }

    //Chooses what account is selected, defaults to the first account in the list
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        TitleScreen.accountID = accounts[pos];
        Toast.makeText(this, "Your Account ID is: " + TitleScreen.accountID, Toast.LENGTH_LONG).show();
        Log.i("PostActivity", "ID is " + TitleScreen.accountID);
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Sends a list of data as a POST request to the api
    public void sendAudit(PostSimba postSimba) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(TitleScreen.baseURL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SimbaClient client = retrofit.create(SimbaClient.class);
        Call<PostSimba> call = client.postAudit(postSimba);

        call.enqueue(new Callback<PostSimba>() {
            @Override
            public void onResponse(Call<PostSimba> call, Response<PostSimba> response) {
                progressDialog.dismiss();
                Toast.makeText(PostActivity.this
                        ,"It has been posted!"
                        ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostSimba> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(PostActivity.this
                        ,"Something went wrong. Check your internet connection"
                        ,Toast.LENGTH_SHORT).show();
                System.err.println(t);
            }
        });

    }
}