package com.appsticit1.quz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreBoard extends AppCompatActivity {

    Button okbutton;
    TextView scoreText;

    QuzActivity obquzActiviry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);


        okbutton = findViewById(R.id.okBut);
        scoreText = findViewById(R.id.score);

        obquzActiviry = new QuzActivity();
        int score = getIntent().getIntExtra("add1", 0);

        scoreText.setText(" "+score);


        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });


    }
    @Override
    public void onBackPressed() {



            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Your exam Finished")
                    .setMessage("Do you Want to re-exam!!")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            Intent i = new Intent(getApplicationContext(), StartActivity.class);
                            startActivity(i);

                        }

                    })
                    .show();


    }
}
