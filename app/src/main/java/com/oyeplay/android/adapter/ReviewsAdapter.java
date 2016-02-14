package com.oyeplay.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanReviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yashwanth on 25/09/15.
 */
public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.RecyclerViewHolderMy> {
    // Recyclerview will extend to recycler view adapter
    public ArrayList<BeanReviews> arrayList;
    private Context context;
    private MyClickListener myClickListener;
    RecyclerViewHolderMy mainHolder;

    public ReviewsAdapter(Context context) {
        this.context = context;
    }

    public ReviewsAdapter(Context context, ArrayList<BeanReviews> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderMy holder, int position) {
        final BeanReviews reviews = arrayList.get(position);
        mainHolder = holder;

        mainHolder.name.setText(reviews.getName());
        mainHolder.timestamp.setText(reviews.getTimestamp());
        mainHolder.review.setText(reviews.getReview());
        mainHolder.ratingBar.setRating(reviews.getRating());
    }


    @Override
    public RecyclerViewHolderMy onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.review_item, viewGroup, false);
        RecyclerViewHolderMy listHolder = new RecyclerViewHolderMy(mainGroup);
        return listHolder;
    }

    public interface MyClickListener {
        void myItemClicked(View view, int position);
    }

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public class RecyclerViewHolderMy extends RecyclerView.ViewHolder implements View.OnClickListener {  //, CompoundButton.OnCheckedChangeListener {
        // View holder for gridview recycler view as we used in listview
        public TextView name, timestamp, review;
        public ImageView imageView_dp;
        public RatingBar ratingBar;

        public RecyclerViewHolderMy(View view) {
            super(view);
            // Find all views ids
            view.setOnClickListener(this);
            this.name = (TextView) view.findViewById(R.id.textView_name);
            this.review = (TextView) view.findViewById(R.id.textView_review);
            this.timestamp = (TextView) view.findViewById(R.id.textView_timestamp);
            this.imageView_dp = (ImageView) view.findViewById(R.id.roundedImage);
            this.ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) {
                myClickListener.myItemClicked(view, getAdapterPosition());
            }
        }
    }
}