package com.example.root.curemedical;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.root.curemedical.Models.OrthopaedicsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my hp on 3/13/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<OrthopaedicsModel> list;
Context context;
    private NetworkImageView mNetworkImageView;

/*
    @Override
    public void onClick(View v) {
        if(v.getId()!=R.id.b_give_tabgive) {
            Class ch=null;
            try {
                ch=Class.forName("com.example.myhp.edbooks.tabgive.Bookdetailsgive");
                Bundle b=new Bundle();
                //b.putInt();

                Intent in=new Intent(context,ch);
                context.startActivity(in);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            Class cl=null;
            try {
                cl=Class.forName("com.example.myhp.edbooks.Given.SelectTaker");
                Intent intent=new Intent(context,cl);
                context.startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
*/
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name,when;
        public View mainview;
    NetworkImageView mNetworkImageView;
        public ViewHolder(View v, MyAdapter myAdapter) {
            super(v);
            mainview=v;
            name=(TextView)v.findViewById(R.id.tv_ortho);
            when=(TextView)v.findViewById(R.id.tv_when);
            mNetworkImageView=(NetworkImageView)v.findViewById(R.id.networkImageView);



        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter( Context context, List<OrthopaedicsModel> list) {

this.context=context;
        this.list=list;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleviewer_orthopaedics, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v,this);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(list.get(position).getName());
        holder.when.setText(list.get(position).getWhen());
        //int loader = R.mipmap.ic_launcher;
        ImageLoader mImageLoader;
        // Imageview to show

        // Image url
      //  String image_url = list.get(position).getMedia();

        // ImageLoader class instance
       // ImageLoader imgLoader = new ImageLoader(context);


        // whenever you want to load an image from url
        // call DisplayImage function
        // url - image url to load
        // loader - loader image, will be displayed before getting image
        // image - ImageView
        //imgLoader.DisplayImage(image_url, loader, holder.image);
            mImageLoader = CustomVolleyRequestQueue.getInstance(context)
                    .getImageLoader();
            //Image URL - This can point to any image file supported by Android
        if(!list.get(position).getMedia().equals("none")) {
            String url = list.get(position).getMedia();
            mImageLoader.get(url, ImageLoader.getImageListener(holder.mNetworkImageView,
                    R.mipmap.ic_launcher, android.R.drawable
                            .ic_dialog_alert));
            holder.mNetworkImageView.setImageUrl(url, mImageLoader);
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }
}