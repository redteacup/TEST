package com.example.liveangel.test;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;

//import com.app.variable.MyAppVariable;
import com.order.detail.OrderDetail;
import com.order.manager.OrderManagerActivity;
import com.place.order.ConfirmOrderActivity;
import com.setting.address.DAddressSettingActivity;
import com.InputAndMatch.inputAndMatch;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize button
        Button orderButton = (Button) findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(Main.this, ConfirmOrderActivity.class);
                startActivity(intent);
//                Main.this.finish();
            }
        });


        Button orderManagerButton = (Button) findViewById(R.id.orderManager);
        orderManagerButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(Main.this, OrderManagerActivity.class);
                startActivity(intent);

            }
        });

        Button daddress_set_btn = (Button) this.findViewById(R.id.Daddress_set_button);
        daddress_set_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Main.this, DAddressSettingActivity.class);
                startActivity(intent);
            }
        });



        Button goodButton = (Button) this.findViewById(R.id.goodButton);
        daddress_set_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Main.this,inputAndMatch.class);
                startActivity(intent);
            }
        });
     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // TESTjjj
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnClickOrderDetail(View view) {
        Intent intent = new Intent(Main.this,OrderDetail.class);
        intent.putExtra("order_id", "1");
        startActivity(intent);
    }



}
