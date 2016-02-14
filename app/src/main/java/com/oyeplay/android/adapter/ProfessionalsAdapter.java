package com.oyeplay.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanProfessionals;
import com.oyeplay.android.bean.BeanProfessionals;
import com.oyeplay.android.userinterface.ProProfileActivity;

import java.util.ArrayList;

/**
 * Created by yashwanth on 25/09/15.
 */
public class ProfessionalsAdapter extends RecyclerView.Adapter<ProfessionalsAdapter.RecyclerViewHolderMy> {
    // Recyclerview will extend to recycler view adapter
    public ArrayList<BeanProfessionals> arrayList;
    private Context context;
    public ArrayList<Integer> selectedItems = new ArrayList<>();
    private MyClickListener myClickListener;
    RecyclerViewHolderMy mainHolder;

    public ProfessionalsAdapter(Context context, ArrayList<BeanProfessionals> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    public ProfessionalsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderMy holder, int position) {
        final BeanProfessionals model = arrayList.get(position);
        mainHolder = holder;

        // setting title
        mainHolder.name.setText(model.getName());
        mainHolder.age.setText(model.getAge());
        mainHolder.address.setText(model.getAddress());
        mainHolder.experience.setText(model.getExp());
        mainHolder.ratingBar.setRating(model.getRating());

        mainHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProProfileActivity.class);
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
                R.layout.item_professionals, viewGroup, false);
        RecyclerViewHolderMy listHolder = new RecyclerViewHolderMy(mainGroup);
        return listHolder;
    }

    public interface MyClickListener {
        void myItemClicked(View view, int position, RelativeLayout relativeLayout);
    }

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public class RecyclerViewHolderMy extends RecyclerView.ViewHolder implements View.OnClickListener {  //, CompoundButton.OnCheckedChangeListener {
        // View holder for gridview recycler view as we used in listview
        public TextView name, age, experience, address;
        public RatingBar ratingBar;
        public ImageView imageView_expertise;
        public LinearLayout linearLayout;

        public RecyclerViewHolderMy(View view) {
            super(view);
            // Find all views ids
            view.setOnClickListener(this);

            this.name = (TextView) view.findViewById(R.id.textView_name);
            this.age = (TextView) view.findViewById(R.id.textView_age);
            this.address = (TextView) view.findViewById(R.id.textView_address);
            this.experience = (TextView) view.findViewById(R.id.textView_exp);
            this.ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            this.imageView_expertise = (ImageView) view.findViewById(R.id.imageView_expertise);
            this.linearLayout = (LinearLayout)view.findViewById(R.id.linearLayout);
        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) {
            }
        }
    }
}