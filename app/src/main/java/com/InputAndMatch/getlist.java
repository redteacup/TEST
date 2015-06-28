package com.InputAndMatch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by GoLD on 2015/6/28.
 */
public class getlist {
    ArrayList<Good> list = null;

    public ArrayList<Good> getlist(){
        HttpClient httpClient = new DefaultHttpClient();
        String url ="http://218.94.159.104:5000/LazyGift/getGoods";
        HttpPost httpPost = new HttpPost(url);
        try{
            HttpResponse response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String result = reader.readLine();

                JSONArray goods = new JSONArray(result);
                for(int i=0;i<goods.length();i++){
                    JSONObject good = goods.getJSONObject(i);
                    Good g = new Good();
                    g.id = good.getInt("id");
                    g.parentId = good.getInt("parentId");
                    g.name = good.getString("name");
                    list.add(g);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }

}
