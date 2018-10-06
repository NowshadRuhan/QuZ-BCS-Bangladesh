package com.appsticit1.quz;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class QusAns extends AppCompatActivity {

    TextView qusNum, questions, numOne, numTwo,numThree, numFour, numMain;
    Button showAnswer, nextBUT;

    String onID = "";
    String qustion = "",ansOne = "", ansTwo= "", ansThree="", ansFour="";

    Animation slide_animation0;
    String mainANS = "";
    int Nid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qus_ans);

        showAnswer = findViewById(R.id.showAns);
        nextBUT = findViewById(R.id.nextB);

        qusNum = findViewById(R.id.QusNumberTV);
        questions = findViewById(R.id.quesTV);

        numOne = findViewById(R.id.AnsNumOne);
        numTwo = findViewById(R.id.AnsNumTwo);
        numThree = findViewById(R.id.AnsNumThree);
        numFour = findViewById(R.id.AnsNumFour);

        numMain = findViewById(R.id.mainANS);

        slide_animation0 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
        questions.startAnimation(slide_animation0);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new QusAns.ReadJSON().execute("http://akashjoy.com/hostal/quz.php?id=1");
            }
        });



        Nid = 1;
        nextBUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nid = Nid+1;
                numMain.setText("Your Ans");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new QusAns.ReadJSON().execute("http://akashjoy.com/hostal/quz.php?id="+Nid+"");
                    }
                });


            }
        });

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one="1", two="2", three="3", four="4";

                if(mainANS.equals(one)){
                    numMain.setText(ansOne);
                }
                else if(mainANS.equals(two)){
                    numMain.setText(ansTwo);
                }
                else if(mainANS.equals(three)){
                    numMain.setText(ansThree);
                }
                else if(mainANS.equals(four)){
                    numMain.setText(ansFour);
                }

            }
        });


    }

     class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return readURL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("responce");

                JSONObject modelObject = jsonArray.getJSONObject(0);

                onID =  modelObject.getString("id");
                qustion =   modelObject.getString("question");
                ansOne =  modelObject.getString("ans_one");
                ansTwo = modelObject.getString("ans_two");
                ansThree =  modelObject.getString("ans_three");
                ansFour =  modelObject.getString("ans_four");
                mainANS =  modelObject.getString("main_ans");


                qusNum.setText(onID);
                questions.setText(qustion);

                numOne.setText(ansOne);
                numTwo.setText(ansTwo);
                numThree.setText(ansThree);
                numFour.setText(ansFour);

                slide_animation0 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
                questions.startAnimation(slide_animation0);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



    private static String readURL(String theUrl){
        StringBuilder content = new StringBuilder();


        try {
            URL url  = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine() )!= null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  content.toString();
    }

}

