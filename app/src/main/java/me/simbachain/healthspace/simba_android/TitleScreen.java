package me.simbachain.healthspace.simba_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TitleScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static String accountID = "";
    String[] accounts = new String[]{"0xb1db8a003114ee270207e8812a009f108b41f625", "0x9ccd1bb0d58a9ce5db012ff74967edb371a91457",
        "0x0a69fcf74245459a1883485a4e4f23bb3b552370", "0x442fd3df4845b53afa13eae0051429b912bb4205",
        "0x818ce4fb076ef541457f22b955af6bfa046c6e37", "0x2ba1d9aba1f0b1b12ad1b48a9c7cf327f1d17180",
        "0xad267928e21fe2bdd09417b20b6b8b0fa767c453", "0x4324ca587090d5d77942531cc18adde45836dd25",
        "0x647102ec4e63f571971e75ba4c5493a636af08bc", "0xd8e00bdfc99738a223db7821281d52de59c25b05"};
    public static String baseURL = "http://healthspace.simbachain.me/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        Button toPost = findViewById(R.id.toPost);
        Button toAudit = findViewById(R.id.toAudit);
        Spinner userID = findViewById(R.id.user_id);


        ArrayAdapter<CharSequence> userAdapter = ArrayAdapter.createFromResource(this, R.array.user_accounts,
                android.R.layout.simple_spinner_item);
        userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        userID.setAdapter(userAdapter);

        //Goes to the PostActivity or the AuditActivity
        toPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TitleScreen.this, PostActivity.class));
            }
        });
        toAudit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TitleScreen.this, AuditActivity.class));
            }
        });
        userID.setOnItemSelectedListener(this);
    }

    //Chooses what account is selected, defaults to the first account in the list
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        accountID = accounts[pos];
        Toast.makeText(this, "Your Accound ID is: " + accountID, Toast.LENGTH_LONG).show();
        Log.i("Titlescreen", "ID is " + accountID);
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
