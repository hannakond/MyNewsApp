package com.example.android.mynewsapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MyNewsLoader extends AsyncTaskLoader<List<MyNews>> {
    private static final String LOG_TAG = MyNewsLoader.class.getName();
    public MyNewsLoader(Context context) {
        super(context);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public List<MyNews> loadInBackground() {
        List<MyNews> newsList = null;
        try {
            URL url = QueryUtils.createUrl();
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            newsList = QueryUtils.parseJson(jsonResponse);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error Loader LoadInBackground: ", e);
        }
        return newsList;
    }
}