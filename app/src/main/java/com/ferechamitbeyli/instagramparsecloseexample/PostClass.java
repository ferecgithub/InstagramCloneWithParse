package com.ferechamitbeyli.instagramparsecloseexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {
    private final ArrayList<String> userNameList;
    private final ArrayList<String> userCommentList;
    private final ArrayList<Bitmap> userImageList;
    private final Activity context;

    public PostClass(ArrayList<String> userNameList, ArrayList<String> userCommentList, ArrayList<Bitmap> userImageList, Activity context) {
        super(context, R.layout.custom_view, userNameList);
        this.userNameList = userNameList;
        this.userCommentList = userCommentList;
        this.userImageList = userImageList;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);
        TextView userNameText = customView.findViewById(R.id.customViewUsernameTextId);
        TextView commentText = customView.findViewById(R.id.customViewCommentTextId);
        ImageView imageView = customView.findViewById(R.id.customViewImageViewId);

        userNameText.setText(userNameList.get(position));
        commentText.setText(userCommentList.get(position));
        imageView.setImageBitmap(userImageList.get(position));

        return customView;
    }
}
