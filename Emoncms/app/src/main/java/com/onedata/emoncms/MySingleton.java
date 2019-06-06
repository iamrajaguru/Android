package com.onedata.emoncms;

import android.content.Context;

import com.android.volley.Request;
import org.json.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.concurrent.SynchronousQueue;

public class MySingleton {
    private static MySingleton minst;
    private RequestQueue rq;
    private static Context cnt;

    private MySingleton(Context cntx)
    {
        cnt=cntx;
        rq=getRequestQ();
    }

    public RequestQueue getRequestQ(){

        if(rq==null){

            rq= Volley.newRequestQueue(cnt.getApplicationContext());
        }
        return rq;
    }


    public static synchronized MySingleton getInstance(Context cntnx){
        if(minst==null){
            minst=new MySingleton(cntnx);
        }
        return minst;
    }
    public<T> void addToRequestQue(Request request){
        rq.add(request);

    }
}
