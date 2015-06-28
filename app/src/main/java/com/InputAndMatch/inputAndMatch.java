package com.InputAndMatch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.liveangel.test.R;

import org.apache.http.util.EncodingUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by GoLD on 2015/6/1.
 */
public class inputAndMatch extends Activity{

    String[] goods = null;
    ArrayList<Good> list = null;
    getlist gl;
  //  String fileName = "data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        list = gl.getlist();
        for(int i=0;i<list.size();i++){
            goods[i] = list.get(i).name;
        }

        // 创建一个ArrayAdapter封装数组
        com.InputAndMatch.ArrayAdapter<String> av = new com.InputAndMatch.ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, goods);
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        auto.setAdapter(av);

    }

    public void getId(){
        String name = null;
        //String name = auto.getText().toString();
        int id = 0;
        int parentId = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).name==name){
                id = list.get(i).id;
                parentId = list.get(i).parentId;
                return;
            }
        }

    }


    /*public void writeFileData(String data){
        try{
            FileOutputStream fout = openFileOutput(fileName,MODE_PRIVATE);
            byte[] bytes = data.getBytes();
            fout.write(bytes);
            fout.close();

        }catch (Exception e){

        }
    }

    public String readFileData(){
        String result="";
        try{
            FileInputStream fin = openFileInput(fileName);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            result = EncodingUtils.getString(buffer, "UTF-8");
        }catch (Exception e){

        }
        return result;
    }*/

}
