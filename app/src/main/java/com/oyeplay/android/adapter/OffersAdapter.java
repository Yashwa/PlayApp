package com.oyeplay.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanOffers;

import java.util.ArrayList;

/**
 * Created by yashwanth on 25/09/15.
 */
public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.RecyclerViewHolderMy> {
    // Recyclerview will extend to recycler view adapter
    public ArrayList<BeanOffers> arrayList;
    private Context context;
    private MyClickListener myClickListener;
    RecyclerViewHolderMy mainHolder;

    public OffersAdapter(Context context) {
        this.context = context;
    }

    public OffersAdapter(Context context, ArrayList<BeanOffers> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderMy holder, int position) {
        final BeanOffers reviews = arrayList.get(position);
        mainHolder = holder;

        mainHolder.heading.setText(reviews.getHeading());
        mainHolder.timestamp.setText(reviews.getTimestamp());
        mainHolder.offer.setText(reviews.getOffer());
        mainHolder.originalPrice.setText(reviews.getOriginalPrice());
        mainHolder.offerPrice.setText(reviews.getOfferPrice());
        mainHolder.noOfTickets.setText(String.valueOf(reviews.getNoOfTickets()));
    }


    @Override
    public RecyclerViewHolderMy onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.offer_list_item, viewGroup, false);
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
        public TextView heading, timestamp, offer, originalPrice, offerPrice, noOfTickets;
        ImageView img_minus, img_plus;

        public RecyclerViewHolderMy(View view) {
            super(view);
            // Find all views ids
            view.setOnClickListener(this);
            this.heading = (TextView) view.findViewById(R.id.textView_offer_heading);
            this.offer = (TextView) view.findViewById(R.id.textView_offer);
            this.timestamp = (TextView) view.findViewById(R.id.date);
            this.originalPrice = (TextView) view.findViewById(R.id.original_price);
            this.offerPrice = (TextView) view.findViewById(R.id.offer_price);
            this.noOfTickets = (TextView) view.findViewById(R.id.tickets);
            this.img_minus = (ImageView) view.findViewById(R.id.img_minus);
            this.img_plus = (ImageView) view.findViewById(R.id.img_plus);
        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) {
                myClickListener.myItemClicked(view, getAdapterPosition());
            }
        }
    }
}