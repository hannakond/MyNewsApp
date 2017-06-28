package com.example.android.mynewsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<MyNews>>, SwipeRefreshLayout.OnRefreshListener {
    private MyNewsAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    final private static int LOADER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);
        adapter = new MyNewsAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyNews myNews = adapter.getItem(position);
                String url = myNews.getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }
        });
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }
    @Override
    public Loader<List<MyNews>> onCreateLoader(int i, Bundle bundle) {
        return new MyNewsLoader(this);
    }
    @Override
    public void onLoadFinished(Loader<List<MyNews>> loader, List<MyNews> data) {
        swipeRefreshLayout.setRefreshing(false);
        if (data != null) {
            adapter.setNotifyOnChange(false);
            adapter.clear();
            adapter.setNotifyOnChange(true);
            adapter.addAll(data);
        }
    }
    @Override
    public void onLoaderReset(Loader<List<MyNews>> loader) {
        adapter.clear();
    }
    @Override
    public void onRefresh() {
        getSupportLoaderManager().restartLoader(LOADER_ID, null, this);
    }
}