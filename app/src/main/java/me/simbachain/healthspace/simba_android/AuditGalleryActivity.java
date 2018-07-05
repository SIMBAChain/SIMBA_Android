package me.simbachain.healthspace.simba_android;

import android.app.AlertDialog;
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
    static String firstAuditor = "";
    static String secondAuditor = "";
    static int auditNo = 0;
    static String auditor = "";
    static String postedVerification = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_gallery);

        Button toBack = findViewById(R.id.back_button);
        Spinner userID = findViewById(R.id.user_id);
        Button incorrect = findViewById(R.id.IncorrectButton);
        Button correct = findViewById(R.id.CorrectButton);
        final TextView auditNumber = findViewById(R.id.editAuditNumber);
        final TextView posterID = findViewById(R.id.editPosterID);
        final TextView IPFS = findViewById(R.id.editIPFS);
        final TextView timeStamp = findViewById(R.id.editTimeStamp);
        final TextView location = findViewById(R.id.editLocation);
        final TextView name = findViewById(R.id.editName);
        final TextView description = findViewById(R.id.editDescription);
        final TextView status = findViewById(R.id.editStatus);
        final TextView comments = findViewById(R.id.editComment);
        final TextView verified = findViewById(R.id.editVerification);
        final TextView auditorOne = findViewById(R.id.editFirstAuditor);
        final TextView auditorTwo = findViewById(R.id.editSecondAuditor);


        //Loading bar for aesthetic purposes
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

        //Allows for the user to click a textbox and show them
        //a popup of that text, for readability
        auditNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(auditNumber.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        posterID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(posterID.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        IPFS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(IPFS.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        timeStamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(timeStamp.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(location.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(name.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(description.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(status.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(comments.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        verified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(verified.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        auditorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(auditorOne.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        auditorTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuditGalleryActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                TextView dialogText = view1.findViewById(R.id.dialogText);

                dialogText.setText(auditorTwo.getText());

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        //Verifies an audit as either correct or incorrect
        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Errors that may occur within the verification process
                if(auditor.equals(TitleScreen.accountID)) {
                    Toast.makeText(AuditGalleryActivity.this
                            ,"The verifier cannot be the same person who posted the audit."
                            , Toast.LENGTH_SHORT).show();
                }
                else if((firstAuditor.equals(TitleScreen.accountID)) || (secondAuditor.equals(TitleScreen.accountID))) {
                    Toast.makeText(AuditGalleryActivity.this
                            , "Verifier has already submitted verification status for this audit."
                            , Toast.LENGTH_SHORT).show();
                }
                else {
                    PostVerification postVerification = new PostVerification(
                            TitleScreen.accountID,
                            false
                    );

                    postedVerification = "false";
                    postVerification(postVerification);
                }
            }
        });
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(auditor.equals(TitleScreen.accountID)) {
                    Toast.makeText(AuditGalleryActivity.this
                            ,"The verifier cannot be the same person who posted the audit."
                            , Toast.LENGTH_SHORT).show();
                }
                else if((firstAuditor.equals(TitleScreen.accountID)) || (secondAuditor.equals(TitleScreen.accountID))) {
                    Toast.makeText(AuditGalleryActivity.this
                            , "Verifier has already submitted verification status for this audit."
                            , Toast.LENGTH_SHORT).show();
                }
                else {
                    PostVerification postVerification = new PostVerification(
                            TitleScreen.accountID,
                            true
                    );

                    postedVerification = "true";
                    postVerification(postVerification);
                }
            }
        });
    }

    //Chooses what account is selected, defaults to the first account in the list
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        TitleScreen.accountID = accounts[pos];
        Toast.makeText(this, "Your Accound ID is: " + TitleScreen.accountID, Toast.LENGTH_LONG).show();
        Log.i("PostActivity", "ID is " + TitleScreen.accountID);
    }
    public void onNothingSelected(AdapterView<?> parent) {}

    //Gets auditNumber, IPFC, and Verified fields from respective post from the audit activity
    private void getIncomingIntent() {
        if(getIntent().hasExtra("audit_no") && getIntent().hasExtra("ipfc") && getIntent().hasExtra("verified")) {

            int auditNumber = getIntent().getIntExtra("audit_no", 0);
            String IPFC = getIntent().getStringExtra("ipfc");
            String Verified = getIntent().getStringExtra("verified");

            auditNo = auditNumber;

            OkHttpClient httpClient = new OkHttpClient.Builder().build();

            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ArrayAdapterFactory()).create();

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(TitleScreen.baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson));

            Retrofit retrofit = builder.client(httpClient).build();

            final SimbaClient client = retrofit.create(SimbaClient.class);

            setIncomingIntent(auditNumber, IPFC, Verified);
            Call<List<GetSimba>> call = client.getAuditItems(auditNumber);

            //Begins setting everything up in the descriptive view
            call.enqueue(new Callback<List<GetSimba>>() {
                @Override
                public void onResponse(Call<List<GetSimba>> call, Response<List<GetSimba>> response) {
                    generateData(response.body());
                    Call<List<Verification>> verify = client.getAuditVerifications(auditNo);
                    verify.enqueue(new Callback<List<Verification>>() {
                        @Override
                        public void onResponse(Call<List<Verification>> call, Response<List<Verification>> response) {
                            progressDialog.dismiss();
                            generateVerification(response.body());
                        }

                        @Override
                        public void onFailure(Call<List<Verification>> call, Throwable t) {
                            progressDialog.dismiss();
                            System.out.println(t);
                            Toast.makeText(AuditGalleryActivity.this, "Something went wrong. " +
                                    "Check your internet connection.", Toast.LENGTH_SHORT).show();
                        }
                    });
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

    //Sets the audit number, IPFC, and verified statuses to their respective fields
    private void setIncomingIntent(int audit, String ipfc, String verified) {

        TextView auditNumber = findViewById(R.id.editAuditNumber);
        TextView IPFC = findViewById(R.id.editIPFS);
        TextView Verified = findViewById(R.id.editVerification);

        auditNumber.setText(audit+"");
        IPFC.setText(ipfc);
        Verified.setText(verified);
    }

    //Sets all data to their respective fields
    public void generateData(List<GetSimba> dataList) {
        TextView posterID = findViewById(R.id.editPosterID);
        TextView timestamp = findViewById(R.id.editTimeStamp);
        TextView location = findViewById(R.id.editLocation);
        TextView name = findViewById(R.id.editName);
        TextView description = findViewById(R.id.editDescription);
        TextView status = findViewById(R.id.editStatus);
        TextView comments = findViewById(R.id.editComment);

        auditor = dataList.get(0).getAuditor().toLowerCase();

        posterID.setText(dataList.get(0).getAuditor());
        timestamp.setText(dataList.get(0).getAsset().getTimestamp());
        location.setText(dataList.get(0).getAsset().getLocation());
        name.setText(dataList.get(0).getAsset().getPersonName());
        description.setText(dataList.get(0).getAsset().getItems().get(0).getDescription());
        status.setText(dataList.get(0).getAsset().getItems().get(0).getStatus());
        comments.setText(dataList.get(0).getAsset().getItems().get(0).getComments());
    }
    public void generateVerification(List<Verification> dataList) {
        TextView firstaudit = findViewById(R.id.editFirstAuditor);
        TextView secondaudit = findViewById(R.id.editSecondAuditor);
        Button incorrect = findViewById(R.id.IncorrectButton);
        Button correct = findViewById(R.id.CorrectButton);

        if(!dataList.isEmpty()) {
            for(int i = 0; i <= dataList.size()-1; i++) {
                if(i == 0) {
                    firstaudit.setText(dataList.get(i).getVerification().toString());
                    firstAuditor = dataList.get(i).getAuditor();
                    System.out.println(firstAuditor);
                }
                else if (i == 1) {
                    secondaudit.setText(dataList.get(i).getVerification().toString());
                    secondAuditor = dataList.get(i).getAuditor();
                    incorrect.setEnabled(false);
                    incorrect.setVisibility(View.GONE);
                    correct.setEnabled(true);
                    correct.setVisibility(View.GONE);
                    System.out.println(secondAuditor);
                }
            }
        }
    }

    //Allows the user to choose a verification
    public void postVerification(final PostVerification postVerification) {
        final TextView firstaudit = findViewById(R.id.editFirstAuditor);
        final TextView secondaudit = findViewById(R.id.editSecondAuditor);
        final TextView verifiedStatus = findViewById(R.id.editVerification);
        final Button incorrect = findViewById(R.id.IncorrectButton);
        final Button correct = findViewById(R.id.CorrectButton);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://healthspace.simbachain.me/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SimbaClient client = retrofit.create(SimbaClient.class);
        Call<PostVerification> call = client.postVerification(auditNo, postVerification);

        call.enqueue(new Callback<PostVerification>() {
            @Override
            public void onResponse(Call<PostVerification> call, Response<PostVerification> response) {
                if(firstaudit.getText().equals("")) {
                    firstaudit.setText(postedVerification);
                }
                else if (secondaudit.getText().equals("")) {
                    secondaudit.setText(postedVerification);
                    incorrect.setEnabled(false);
                    incorrect.setVisibility(View.GONE);
                    correct.setEnabled(true);
                    correct.setVisibility(View.GONE);
                    if(Boolean.valueOf(firstaudit.getText().toString())
                            && Boolean.valueOf(secondaudit.getText().toString())) {
                        verifiedStatus.setText("true");
                    }
                    else if(!Boolean.valueOf(firstaudit.getText().toString())
                            && !Boolean.valueOf(secondaudit.getText().toString())) {
                        verifiedStatus.setText("false");
                    }
                }
            }

            @Override
            public void onFailure(Call<PostVerification> call, Throwable t) {
                Toast.makeText(AuditGalleryActivity.this
                        ,"Something went wrong. Check your internet connection."
                        ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
