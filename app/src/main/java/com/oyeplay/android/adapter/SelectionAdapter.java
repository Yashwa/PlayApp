package com.oyeplay.android.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanSports;

import java.util.ArrayList;

/**
 * Created by yashwanth on 25/09/15.
 */
public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.RecyclerViewHolderMy> {
    // Recyclerview will extend to recycler view adapter
    public ArrayList<BeanSports> arrayList;
    private Context context;
    public ArrayList<Integer> selectedItems = new ArrayList<>();
    private MyClickListener myClickListener;
    RecyclerViewHolderMy mainHolder;

    public SelectionAdapter(Context context, ArrayList<BeanSports> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    public SelectionAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderMy holder, int position) {
        final BeanSports model = arrayList.get(position);
        mainHolder = holder;

        // This will convert drawbale image into bitmap
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), model.getImage());

        // setting title
        mainHolder.title.setText(model.getTitle());
        mainHolder.title1.setText(model.getTitle());
        mainHolder.id.setText(String.valueOf("(" + model.getId()) + ")");
        mainHolder.imageview.setImageBitmap(image);
        mainHolder.imageview.setTag(position);
        mainHolder.relativeLayout.setTag(position);


        mainHolder.imageview.setOnClickListener(new com.oyeplay.android.utility.MyClickListener
                ((RecyclerView.ViewHolder) mainHolder, position) {
            @Override
            public void onClick(View v) {
                // Add code to redirect the group profile page (activity)and also pass the useful parameter to other other activity
//                mainHolder.relativeLayout.findViewWithTag(position).setVisibility(View.VISIBLE);
                System.out.println(mainHolder.relativeLayout.getTag());
                Toast.makeText(context, String.valueOf(position), Toast.LENGTH_LONG).show();

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
                R.layout.selection_item, viewGroup, false);
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
        public TextView title, title1, id;
        public ImageView imageview;
        public RelativeLayout relativeLayout;

        public RecyclerViewHolderMy(View view) {
            super(view);
            // Find all views ids
            view.setOnClickListener(this);

            this.relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
            this.title = (TextView) view.findViewById(R.id.textView_item_title);
            this.title1 = (TextView) view.findViewById(R.id.textView_item_title1);
            this.imageview = (ImageView) view.findViewById(R.id.imageView_interest);
            this.id = (TextView) view.findViewById(R.id.textView_item_id);

        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) {
                myClickListener.myItemClicked(view, getAdapterPosition(), relativeLayout);
            }
        }
    }
}