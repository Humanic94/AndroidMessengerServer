/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer;

import ChatServer.Domain.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Humanic
 */
public class loadUsers extends AsyncTask<String, Long, List<User>> {
    @Override 
    protected List<User> doInBackground(String... path){
        List<User> result = new ArrayList<>();
        
        HttpURLConnection con = null;
        try{
            URL url = new URL(path[0]);
            con = (HttpURLConnection)url.openConnection();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>(){
                SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd´T´HH:mm:ss:SSSXXX")
                SimpleDateFormat DF2 = new SimpleDateFormat("yyyy-MM-dd´T´HH:mm:ss.XXX")
                @Override
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
                    String value = json.getAsString();
                    try{
                        return value.length() > 25 ? DF.parse(value) : DF2.parse(value);
                    }catch(ParseException e){
                        e.printStackTrace();
                    }
                }
               });
            Gson gson = new Gson();
            User[] users = gson.fromJson(br, User[].class);
        }catch(MalformedURLException e){
                e.printStackTrace();
        }catch(IOException i){
            i.printStackTrace();
        }
        return result;
    }
}
