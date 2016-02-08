package com.oyeplay.android.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanClubDetails;
import com.oyeplay.android.bean.BeanClubDetails;

import java.util.ArrayList;

/**
 * Created by yashwanth on 25/09/15.
 */
public class ClubListAdapter extends RecyclerView.Adapter<ClubListAdapter.RecyclerViewHolderMy> {
    // Recyclerview will extend to recycler view adapter
    public ArrayList<BeanClubDetails> arrayList;
    private Context context;
    public ArrayList<Integer> selectedItems = new ArrayList<>();
    private MyClickListener myClickListener;
    RecyclerViewHolderMy mainHolder;

    public ClubListAdapter(Context context, ArrayList<BeanClubDetails> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    public ClubListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderMy holder, int position) {
        final BeanClubDetails model = arrayList.get(position);
        mainHolder = holder;

        mainHolder.name.setText(model.getName());
        mainHolder.address.setText(model.getAddress());
        mainHolder.price.setText(String.valueOf("$" + model.getPrice()));
        mainHolder.ratingBar.setRating(model.getRating());
    }

    public ArrayList<Integer> selectedItems() {
        ArrayList<Integer> selectedItems;
        selectedItems = this.selectedItems;
        return selectedItems;
    }

    @Override
    public RecyclerViewHolderMy onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.clublist_item, viewGroup, false);
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
        public TextView name, address, price;
        public ImageView imageview_banner, imageview_logo;
        public RatingBar ratingBar;
        Button button_book;

        public RecyclerViewHolderMy(View view) {
            super(view);
            // Find all views ids
            view.setOnClickListener(this);

            this.name = (TextView) view.findViewById(R.id.textView_name);
            this.address = (TextView) view.findViewById(R.id.textView_address);
            this.price = (TextView) view.findViewById(R.id.textView_price);

            this.imageview_banner = (ImageView) view.findViewById(R.id.imageView_banner);
            this.imageview_logo = (ImageView) view.findViewById(R.id.imageView_clubLogo);
            this.ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
            this.button_book = (Button)view.findViewById(R.id.button_book);

        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) {
                myClickListener.myItemClicked(view, getAdapterPosition());
            }
        }
    }
}