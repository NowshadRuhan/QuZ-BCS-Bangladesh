package com.appsticit1.quz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myquz";
    private static final String TABLE_NAME = "tbl_quz";
    private static final String tbl_id = "ID";
    private static final String Online_Id = "Online_id";
    private static final String Question = "question";
    private static final String ansOne = "ansone";
    private static final String ansTwo = "anstwo";
    private static final String ansThree = "ansthree";
    private static final String ansFour ="ansfour";
    private static final String MainAns ="MainAns";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String s = "Create table "+TABLE_NAME+" ( "+tbl_id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+Online_Id+" int,"+Question+" text,  "+ansOne+" text, "+ansTwo+" text,"+ansThree+" text,"+ansFour+" text,"+MainAns+" varcher(200))";
        db.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public   void addingDataToTable(ModelClass model)
    {

        SQLiteDatabase sqd = this.getWritableDatabase();
        ContentValues cv= new ContentValues();

        cv.put(Online_Id, model.getid());
        cv.put(Question, model.getQus());
        cv.put(ansOne, model.getAnsOne());
        cv.put(ansTwo,model.getAnsTwo());
        cv.put(ansThree,model.getAnsThree());
        cv.put(ansFour,model.getAnsFour());
        cv.put(MainAns,model.getMainans());



        //Log.d("test",model.getMenu_title() + " " + model.getMenuID() +" " + model.getMenu_price());


        sqd.insert(TABLE_NAME, null ,cv);
        sqd.close();

    }

    public String cheackID(int OnID){
        String sab="", s1="";
        SQLiteDatabase sq =this.getReadableDatabase();
         sab= "SELECT IFNULL( (SELECT Online_id FROM tbl_quz WHERE Online_id = "+OnID+" LIMIT 1) ,'not found' )as found";
        Cursor c= sq.rawQuery(sab,null);


        if(c != null && c.moveToFirst()){
            s1 = c.getString(c.getColumnIndex("found"));

            c.close();
            sq.close();
            return s1;
        }
        else{
            s1 = c.getString(c.getColumnIndex("not found"));
            sq.close();
        }
        return s1;
    }


    public void deleteTable(int a){

        SQLiteDatabase sq =this.getReadableDatabase();
       String s = "DELETE FROM tbl_quz WHERE ID = "+a;
        Cursor c= sq.rawQuery(s,null);
        c.close();
    }



    public ArrayList<ModelClass> arrayList(int QusID){

        ArrayList<ModelClass> arrayView = new ArrayList<ModelClass>();
        String s1,s2,s3, s4, s5, s6,s7;
        SQLiteDatabase sq  = this.getReadableDatabase();
        String q="SELECT "+tbl_id+","+Question+","+ansOne+","+ansTwo+","+ansThree+","+ansFour+","+MainAns+" From "+TABLE_NAME+" WHERE  ID = "+QusID ;
        // String q="SELECT * FROM "+TABLE_NAME;
        Cursor c= sq.rawQuery(q,null);
        while (c.moveToNext()){

            s1 = c.getString(c.getColumnIndex(tbl_id));
            s2 = c.getString(c.getColumnIndex(Question));
            s3 = c.getString(c.getColumnIndex(ansOne));
            s4 = c.getString(c.getColumnIndex(ansTwo));
            s5 = c.getString(c.getColumnIndex(ansThree));
            s6 = c.getString(c.getColumnIndex(ansFour));
            s7 = c.getString(c.getColumnIndex(MainAns));


            arrayView.add(new ModelClass(s1,s2,s3,s4,s5,s6,s7));
        }
        return arrayView;
    }



}
