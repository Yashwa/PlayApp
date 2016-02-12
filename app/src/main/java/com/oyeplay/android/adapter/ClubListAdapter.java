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
import com.oyeplay.android.bean.BeanGrounds;
import com.oyeplay.android.userinterface.DashboardActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yashwanth on 25/09/15.
 */
public class ClubListAdapter extends RecyclerView.Adapter<ClubListAdapter.RecyclerViewHolderMy> {
    // Recyclerview will extend to recycler view adapter
    public List<com.oyeplay.android.bean.R> arrayList;
    private Context context;
    public ArrayList<Integer> selectedItems = new ArrayList<>();
    private MyClickListener myClickListener;
    RecyclerViewHolderMy mainHolder;

    public ClubListAdapter(Context context, BeanGrounds grounds) {
        this.context = context;
        this.arrayList = grounds.getData().getRs();
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
        final com.oyeplay.android.bean.R ground = arrayList.get(position);
        mainHolder = holder;

        mainHolder.name.setText(ground.getCn());


        if (ground.getDt() != null) {
            mainHolder.address.setText(ground.getArea() + "|" + ground.getDt() + "km");
        } else {
            mainHolder.address.setText(ground.getArea());
        }
//        if (ground.getSp() != null) {
//            mainHolder.price.setText(ground.getSp().toString());
//        } else {
//            mainHolder.price.setText("***");
//        }


        if (ground.getIs() != null) {
            List list = (List) ground.getIs();
            Picasso.with(context)
                    .load(list.get(0).toString())
                    .error(R.drawable.img_club_fb)

                    .placeholder(R.drawable.ic_launcher)
                    .into(holder.imageview_banner);
        }

        Picasso.with(context)
                .load(ground.getDu())
                .error(R.drawable.img_club_fb)

                .placeholder(R.drawable.ic_launcher)
                .into(holder.imageview_logo);
        if (ground.getAr() != null) {
            if ((ground.getAr() == Math.floor((double) ground.getAr())) && !Double.isInfinite((double) ground.getAr())) {
                mainHolder.ratingBar.setRating((int) ground.getAr());
            } else {

                try {
                    mainHolder.ratingBar.setRating(Integer.parseInt(String.valueOf(ground.getAr()).split(".")[0]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }

            }

        } else {
            mainHolder.ratingBar.setRating(0);
        }
        if (ground.getSba()) {
            mainHolder.button_book.setVisibility(View.VISIBLE);
        } else {
            mainHolder.button_book.setVisibility(View.GONE);
        }

        mainHolder.imageview_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DashboardActivity.class);
                intent.putExtra("name", ground.getCn());
                intent.putExtra("city", ground.getCin());
                context.startActivity(intent);
            }
        });
        mainHolder.button_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DashboardActivity.class);
                intent.putExtra("name", ground.getCn());
                intent.putExtra("city", ground.getCin());
                context.startActivity(intent);
            }
        });
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
        CardView card_ground;

        public RecyclerViewHolderMy(View view) {
            super(view);
            // Find all views ids
            view.setOnClickListener(this);
            this.card_ground = (CardView) view.findViewById(R.id.card_ground);
            this.name = (TextView) view.findViewById(R.id.textView_name);
            this.address = (TextView) view.findViewById(R.id.textView_address);
            this.price = (TextView) view.findViewById(R.id.textView_price);

            this.imageview_banner = (ImageView) view.findViewById(R.id.imageView_banner);
            this.imageview_logo = (ImageView) view.findViewById(R.id.imageView_clubLogo);
            this.ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            this.button_book = (Button) view.findViewById(R.id.button_book);

        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) {
                myClickListener.myItemClicked(view, getAdapterPosition());
            }
        }
    }
}