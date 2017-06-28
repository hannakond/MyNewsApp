package com.example.android.mynewsapp;

/**
 * Created by anna on 28.06.2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyNewsAdapter extends ArrayAdapter<MyNews> {

    public MyNewsAdapter(Context context) {
        super(context, -1, new ArrayList<MyNews>());

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list, parent, false);
        }

        MyNews currentNews = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_view);
        titleTextView.setText(currentNews.getTitle());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_view);
        authorTextView.setText(currentNews.getAuthor());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_view);
        authorTextView.setText(currentNews.getDate());

        TextView topicTextView = (TextView) listItemView.findViewById(R.id.topic_view);
        authorTextView.setText(currentNews.getTopic());

        return listItemView;
    }
}
