package com.appsticit1.quz;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

import static com.appsticit1.quz.R.color.green;

public class QuzActivity extends AppCompatActivity {

    Animation slide_animation1, slide_animation2, slide_animation3, slide_animation4;
    TextView qusNumber, quesText;

    Button ansOne,ansTwo, ansThree, ansFour;

    String M_ans = "";

    Button previous, skip, next;

    int i1=1;

    int min = 1;
    int max = 20;

    Random r ;


    String mainAns = "";
    int newid = 0;

    String point = "";

    StartActivity startActivity;

    int QusID = 1;
    int IDD = 1;
    int score1;
    String num="0";
    ScoreBoard mySE;

    int idNumber[];
    int id= 0;
    int num1 = 0;
    int forLocaldata = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quz);

        r = new Random();
       idNumber = new int[20];

        for(int i=0;i<=19;i++){

            idNumber[i]=0;
        }
        i1 = r.nextInt(max - min + 1) + min;
        int il=0;
        for( il = 0; idNumber[19]==0; il += 1){

            i1 = r.nextInt(max - min + 1) + min;

            if(idNumber[0]!=i1 && idNumber[0]==0 ){
                idNumber[0]=i1;
                idNumber[19]=0;
            }
           else if(i1!=idNumber[0] && idNumber[1]==0){
                idNumber[1]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && idNumber[2]==0){

                idNumber[2]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2]&& idNumber[3]==0){
                idNumber[3]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2] && i1!=idNumber[3] && idNumber[4]==0){
                idNumber[4]=i1;
                idNumber[14]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2] && i1!=idNumber[3] && i1!=idNumber[4]
                    && idNumber[5]==0){
                idNumber[5]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2] && i1!=idNumber[3] && i1!=idNumber[4]
                    && i1!=idNumber[5]&& idNumber[6]==0){
                idNumber[6]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2] && i1!=idNumber[3] && i1!=idNumber[4]
                    && i1!=idNumber[5] && i1!=idNumber[6] && idNumber[7]==0){
                idNumber[7]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2] && i1!=idNumber[3] && i1!=idNumber[4]
                    && i1!=idNumber[5] && i1!=idNumber[6]
                    && i1!=idNumber[7] && idNumber[8]==0){
                idNumber[8]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2] && i1!=idNumber[3] && i1!=idNumber[4]
                    && i1!=idNumber[5] && i1!=idNumber[6]
                    && i1!=idNumber[7] && i1!=idNumber[8]
                    && idNumber[9]==0){
                idNumber[9]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1]
                    && i1!=idNumber[2] && i1!=idNumber[3] && i1!=idNumber[4]
                    && i1!=idNumber[5] && i1!=idNumber[6]
                    && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9]&& idNumber[10]==0){

                idNumber[10]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]&& idNumber[11]==0){
                idNumber[11]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& idNumber[12]==0){
                idNumber[12]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& i1!=idNumber[12] && idNumber[13]== 0){
                idNumber[13]=i1;
                idNumber[19]=0;
            }

           else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& i1!=idNumber[12]
                    && i1!=idNumber[13]&& idNumber[14]==0){
                idNumber[14]=i1;
                idNumber[19]=0;
            }


            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& i1!=idNumber[12]
                    && i1!=idNumber[13]  && i1!=idNumber[14]&& idNumber[15]==0){
                idNumber[15]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& i1!=idNumber[12]
                    && i1!=idNumber[13]  && i1!=idNumber[14]
                    && i1!=idNumber[15]&& idNumber[16]==0){
                idNumber[16]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& i1!=idNumber[12]
                    && i1!=idNumber[13]&& i1!=idNumber[14]
                    && i1!=idNumber[15]&& i1!=idNumber[16]&& idNumber[17]==0){
                idNumber[17]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& i1!=idNumber[12]
                    && i1!=idNumber[13]&& i1!=idNumber[14]
                    && i1!=idNumber[15]&& i1!=idNumber[16]
                    && i1!=idNumber[17]&& idNumber[18]==0){
                idNumber[18]=i1;
                idNumber[19]=0;
            }
            else if(i1!=idNumber[0] && i1!=idNumber[1] && i1!=idNumber[2]
                    && i1!=idNumber[3] && i1!=idNumber[4] && i1!=idNumber[5]
                    && i1!=idNumber[6] && i1!=idNumber[7] && i1!=idNumber[8]
                    && i1!=idNumber[9] && i1!=idNumber[10]
                    && i1!=idNumber[11]&& i1!=idNumber[12]
                    && i1!=idNumber[13]&& i1!=idNumber[14]
                    && i1!=idNumber[15]&& i1!=idNumber[16]
                    && i1!=idNumber[17]&& i1!=idNumber[18]&& idNumber[19]==0){
                idNumber[19]=i1;
            }


        }


        startActivity = new StartActivity();

        mySE = new ScoreBoard();

        qusNumber = findViewById(R.id.QusNumberTextview);
        quesText = findViewById(R.id.quesTextview);

        ansOne = findViewById(R.id.ansNumberOne);
        ansTwo = findViewById(R.id.ansNumberTwo);
        ansThree = findViewById(R.id.ansNumberThree);
        ansFour = findViewById(R.id.ansNumberFour);

        previous = findViewById(R.id.previousBT);
        skip = findViewById(R.id.skipBT);
        next = findViewById(R.id.nextBT);


        num1 = 1;
        id = idNumber[0];
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), " id num "+id, Toast.LENGTH_SHORT).show();

                new QuzActivity.ReadJSON().execute("http://akashjoy.com/hostal/quz.php?id="+id+"");
            }
        });


        slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
        quesText.startAnimation(slide_animation1);

        slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
        ansOne.startAnimation(slide_animation1);

        slide_animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation2);
        ansTwo.startAnimation(slide_animation2);

        slide_animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation3);
        ansThree.startAnimation(slide_animation3);

        slide_animation4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation4);
        ansFour.startAnimation(slide_animation4);




        ansOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                M_ans = "1";
                ansOne.setBackgroundResource(R.drawable.greenforbutton);

                ansTwo.setBackgroundResource(R.drawable.custombutton);
                ansThree.setBackgroundResource(R.drawable.custombutton);
                ansFour.setBackgroundResource(R.drawable.custombutton);

            }
        });

        ansTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                M_ans = "2";
                ansTwo.setBackgroundResource(R.drawable.greenforbutton);

                ansOne.setBackgroundResource(R.drawable.custombutton);
                ansThree.setBackgroundResource(R.drawable.custombutton);
                ansFour.setBackgroundResource(R.drawable.custombutton);
            }
        });

        ansThree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                M_ans = "3";
                ansThree.setBackgroundResource(R.drawable.greenforbutton);

                ansOne.setBackgroundResource(R.drawable.custombutton);
                ansTwo.setBackgroundResource(R.drawable.custombutton);
                ansFour.setBackgroundResource(R.drawable.custombutton);
            }
        });

        ansFour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                M_ans = "4";

                ansFour.setBackgroundResource(R.drawable.greenforbutton);

                ansOne.setBackgroundResource(R.drawable.custombutton);
                ansTwo.setBackgroundResource(R.drawable.custombutton);
                ansThree.setBackgroundResource(R.drawable.custombutton);
            }
        });


        skip.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "" + score1, Toast.LENGTH_SHORT).show();
                M_ans = "0";

                num1 += 1;
                id = idNumber[newid +=1];
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), " id num "+id, Toast.LENGTH_SHORT).show();

                        new QuzActivity.ReadJSON().execute("http://akashjoy.com/hostal/quz.php?id="+id+"");

                    }
                });
                ansOne.setBackgroundResource(R.drawable.custombutton);
                ansTwo.setBackgroundResource(R.drawable.custombutton);
                ansThree.setBackgroundResource(R.drawable.custombutton);
                ansFour.setBackgroundResource(R.drawable.custombutton);

                slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
                quesText.startAnimation(slide_animation1);

                slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
                ansOne.startAnimation(slide_animation1);

                slide_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation2);
                ansTwo.startAnimation(slide_animation2);

                slide_animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation3);
                ansThree.startAnimation(slide_animation3);

                slide_animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation4);
                ansFour.startAnimation(slide_animation4);


                if (num1 == 20) {


                    // Toast.makeText(getApplicationContext(), "Its your last question!!", Toast.LENGTH_SHORT).show();
                    next.setVisibility(View.INVISIBLE);
                    skip.setText("Submit");

                    skip.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Toast.makeText(getApplicationContext(), "" + score1, Toast.LENGTH_SHORT).show();


                            Intent i = new Intent(getApplicationContext(), ScoreBoard.class);
                            i.putExtra("add1", score1);
                            startActivity(i);

                        }
                    });
                }

            }
        });


            next.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(M_ans.equals(num)){
                        Toast.makeText(getApplicationContext(), "Please Select Your Ans", Toast.LENGTH_SHORT).show();

                    }
                    else {

                        if (M_ans.equals(mainAns)) {
                            score1++;
                        }
                        Toast.makeText(getApplicationContext(), "" + score1, Toast.LENGTH_SHORT).show();
                        M_ans = "0";

                        num1 += 1;

                        id = idNumber[newid +=1];
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), " id num "+id, Toast.LENGTH_SHORT).show();

                                new QuzActivity.ReadJSON().execute("http://akashjoy.com/hostal/quz.php?id=" +id+"");

                            }
                        });
                        ansOne.setBackgroundResource(R.drawable.custombutton);
                        ansTwo.setBackgroundResource(R.drawable.custombutton);
                        ansThree.setBackgroundResource(R.drawable.custombutton);
                        ansFour.setBackgroundResource(R.drawable.custombutton);

                        slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
                        quesText.startAnimation(slide_animation1);

                        slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
                        ansOne.startAnimation(slide_animation1);

                        slide_animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation2);
                        ansTwo.startAnimation(slide_animation2);

                        slide_animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation3);
                        ansThree.startAnimation(slide_animation3);

                        slide_animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation4);
                        ansFour.startAnimation(slide_animation4);


                        if (num1 == 20) {


                            // Toast.makeText(getApplicationContext(), "Its your last question!!", Toast.LENGTH_SHORT).show();
                            next.setVisibility(View.INVISIBLE);
                            skip.setText("Submit");

                            skip.setOnClickListener(new OnClickListener() {
                                @Override
                                public void onClick(View v) {


                                    for(int i=0;i<=19;i++){

                                        idNumber[i]=0;
                                    }
                                    Toast.makeText(getApplicationContext(), "" + score1, Toast.LENGTH_SHORT).show();


                                    Intent i = new Intent(getApplicationContext(), ScoreBoard.class);
                                    i.putExtra("add1", score1);
                                    finish();
                                    startActivity(i);

                                }
                            });
                        }
                    }
                }

            });


        previous.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                num1 -= 1;
                id = idNumber[newid-=1];
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), " id num "+id, Toast.LENGTH_SHORT).show();

                        new QuzActivity.ReadJSON().execute("http://akashjoy.com/hostal/quz.php?id="+id+"");
                    }
                });

                ansOne.setBackgroundResource(R.drawable.custombutton);
                ansTwo.setBackgroundResource(R.drawable.custombutton);
                ansThree.setBackgroundResource(R.drawable.custombutton);
                ansFour.setBackgroundResource(R.drawable.custombutton);


                slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
                quesText.startAnimation(slide_animation1);

                slide_animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
                ansOne.startAnimation(slide_animation1);

                slide_animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation2);
                ansTwo.startAnimation(slide_animation2);

                slide_animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation3);
                ansThree.startAnimation(slide_animation3);

                slide_animation4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation4);
                ansFour.startAnimation(slide_animation4);


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

                String onlineId = modelObject.getString("id");
                String qus =   modelObject.getString("question");
                String ans1 =  modelObject.getString("ans_one");
                String ans2 = modelObject.getString("ans_two");
                String ans3 =  modelObject.getString("ans_three");
                String ans4 =  modelObject.getString("ans_four");
                mainAns =  modelObject.getString("main_ans");

                qusNumber.setText(num1+" ");
                quesText.setText(qus);
                ansOne.setText(ans1);
                ansTwo.setText(ans2);
                ansThree.setText(ans3);
                ansFour.setText(ans4);




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
