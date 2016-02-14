package com.oyeplay.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanAmenities;
import com.oyeplay.android.utility.MajorUtils;

import java.util.ArrayList;

/**
 * Created by yashwanth on 25/09/15.
 */
public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.RecyclerViewHolderMy> {
    // Recyclerview will extend to recycler view adapter
    public ArrayList<BeanAmenities> arrayList = new ArrayList<>();
    private Context context;
    private MyClickListener myClickListener;
    RecyclerViewHolderMy mainHolder;

    public AmenitiesAdapter(Context context, ArrayList<BeanAmenities> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    public AmenitiesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderMy holder, int position) {
        final BeanAmenities model = arrayList.get(position);
        mainHolder = holder;

        System.out.println(arrayList);
        System.out.println(arrayList.size());

        // setting title
        mainHolder.title.setText(model.getName());

        MajorUtils.logit("it works","dasddsadsa");

    }

    @Override
    public RecyclerViewHolderMy onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.item_aminities, viewGroup, false);
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
        public TextView title;

        public RecyclerViewHolderMy(View view) {
            super(view);
            // Find all views ids
            view.setOnClickListener(this);

            this.title = (TextView) view.findViewById(R.id.textView_title);

        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) {
            }
        }
    }
}