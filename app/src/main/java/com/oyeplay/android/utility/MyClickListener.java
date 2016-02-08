package com.oyeplay.android.utility;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Yashwanth on 12/11/15.
 */
public class MyClickListener implements View.OnClickListener
{
    public  RecyclerView.ViewHolder holder;
    public int position;
    public String pos;

    public MyClickListener(RecyclerView.ViewHolder view, int position)
    {
        this.holder=view;
        this.position=position;
    }

    public MyClickListener(String pos) {
        this.pos = pos;
    }

    public void onClick(View v)
    {

    }
}
