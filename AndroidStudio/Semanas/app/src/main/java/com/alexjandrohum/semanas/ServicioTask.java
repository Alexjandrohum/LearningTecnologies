package com.alexjandrohum.semanas;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

public class ServicioTask extends AsyncTask <Void, Void, String> {
    private Context httpContext;
    ProgressDialog processDialog;
    public String resultadoapi="";
    public String linkrequestAPI="";

    public ServicioTask (Context ctx, String linkAPI){
        this.httpContext=ctx;
        this.linkrequestAPI=linkAPI;

    }

    @Override
    protected  void onPreExecute(){
        super.onPreExecute();
        processDialog= ProgressDialog.show(httpContext, "Procesando Solicitud", "Por favor espere");
    }

    @Override
    protected String doInBackground(Void... params){
        String result=null;

        String wsURL =linkrequestAPI;
        URL url=null;
        try{
            url=new URL(wsURL);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();

            JSONObject parametrosPost=new JSONObject();
            parametrosPost.put("Matricula: ", "15791015");
            parametrosPost.put("Contrasena: ", "1234567q");

            urlConnection.setReadTimeout(1500);
            urlConnection.setConnectTimeout(1500);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);


            OutputStream os=urlConnection.getOutputStream();
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(parametrosPost));
            writer.flush();
            writer.close();
            os.close();


            int responseCode=urlConnection.getResponseCode();
            if (responseCode==HttpURLConnection.HTTP_OK){
                BufferedReader in=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                StringBuffer sb=new StringBuffer("");
                String linea="";
                while ((linea=in.readLine())!=null){
                    sb.append(linea);
                    break;
                }
                in.close();
                result=sb.toString();
            }
            else {
                result=new String("Error: "+responseCode);
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }


    @Override
    protected  void onPostExecute(String s){
        super.onPostExecute(s);
        processDialog.dismiss();
        resultadoapi=s;
        Toast.makeText(httpContext,resultadoapi,Toast.LENGTH_LONG);
    }

    public String getPostDataString(JSONObject params) throws Exception{
        StringBuilder result=new StringBuilder();
        boolean first=true;
        Iterator<String> itr=params.keys();
        while (itr.hasNext()){
            String key=itr.next();
            Object value=params.get(key);

            if(first)
                first=false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));
        }
        return result.toString();
    }


}