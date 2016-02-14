package com.oyeplay.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanAmenities;
import com.oyeplay.android.bean.BeanChild;
import com.oyeplay.android.bean.BeanGroup;
import com.oyeplay.android.bean.BeanSports;
import com.oyeplay.android.userinterface.ReviewsActivity;
import com.oyeplay.android.utility.MajorUtils;

import java.util.ArrayList;


public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<BeanGroup> groups;
    private ArrayList<BeanChild> Items;
    public ArrayList<BeanAmenities> amenities = new ArrayList<>();

    public ExpandableAdapter(Context context, ArrayList<BeanGroup> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<BeanChild> chList = groups.get(groupPosition).getItems();
        return chList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        BeanChild child = (BeanChild) getChild(groupPosition, childPosition);
        if (convertView == null) {

            if (groupPosition == 2) {
                LayoutInflater infalInflater = (LayoutInflater) context
                        .getSystemService(context.LAYOUT_INFLATER_SERVICE);

                convertView = infalInflater.inflate(R.layout.content_aminities, null);

                RecyclerView recyclerView = (RecyclerView) convertView.findViewById(R.id.recyclerView_amenities);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

                amenities.add(new BeanAmenities("Washroom"));
                amenities.add(new BeanAmenities("Washroom"));
                amenities.add(new BeanAmenities("Washroom"));
                amenities.add(new BeanAmenities("Washroom"));
                amenities.add(new BeanAmenities("Washroom"));
                amenities.add(new BeanAmenities("Washroom"));

                AmenitiesAdapter adapter = new AmenitiesAdapter(context, amenities);
                amenities = adapter.arrayList;
                recyclerView.setAdapter(adapter);// set adapter on recyclerview
                adapter.notifyDataSetChanged();// Notify the adapter

                
            } else {
                LayoutInflater infalInflater = (LayoutInflater) context
                        .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.menu_child, null);

                TextView tv = (TextView) convertView.findViewById(R.id.textView_name);
                MajorUtils.logit("html", child.getName().toString());
                tv.setText(Html.fromHtml(child.getName().toString()));

            }

        }
//        TextView tv = (TextView) convertView.findViewById(R.id.textView_name);
//        MajorUtils.logit("html", child.getName().toString());
//        tv.setText(Html.fromHtml(child.getName().toString()));


        return convertView;
    }


    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<BeanChild> chList = groups.get(groupPosition).getItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        BeanGroup group = (BeanGroup) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.menu_header, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.arrow);

        if (isExpanded) {
            imageView.setImageResource(R.drawable.ic_chevron_down);
        } else {
            imageView.setImageResource(R.drawable.ic_chevron_right);
        }

        final TextView tv = (TextView) convertView.findViewById(R.id.textView_header);
        tv.setText(group.getName());
        return convertView;
    }

    @Override
    public boolean hasStableIds() {

        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return true;
    }

    ArrayList<BeanChild> getBox() {
        ArrayList<BeanChild> box = new ArrayList<BeanChild>();
        for (BeanChild p : Items) {
            if (p.isBox())
                box.add(p);
        }
        return box;
    }


}

