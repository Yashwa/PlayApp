package com.oyeplay.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanAmenities;
import com.oyeplay.android.bean.BeanChild;
import com.oyeplay.android.bean.BeanGroup;
import com.oyeplay.android.utility.MajorUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;


public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<BeanGroup> groups;
    private ArrayList<BeanChild> Items;
    public ArrayList<BeanAmenities> amenities = new ArrayList<>();
boolean isset = false;
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
        LayoutInflater infalInflater = (LayoutInflater) context
                .getSystemService(context.LAYOUT_INFLATER_SERVICE);


            MajorUtils.logit("position:"+String.valueOf(groupPosition)+groups.get(groupPosition).getName());

            if (groups.get(groupPosition).getName().equals("Amenities")) {
                convertView = infalInflater.inflate(R.layout.content_aminities, null);



                MajorUtils.logit("position" + "groups.get(groupPosition).getName()");


                try {
                    JSONArray facilitiesArray = new JSONArray(child.getName());


                    for (int i =0; i<facilitiesArray.length();i++){
;
                        amenities.add(new BeanAmenities( facilitiesArray.get(i).toString()));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



                   RecyclerView recyclerView = (RecyclerView) convertView.findViewById(R.id.recyclerView_amenities);


//                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

                   recyclerView.setLayoutManager(new LinearLayoutManager(context));





                   AmenitiesAdapter adapter = new AmenitiesAdapter(context, amenities);
                adapter.arrayList=amenities;
                   recyclerView.setAdapter(adapter);// set adapter on recyclerview


                   adapter.notifyDataSetChanged();

                // Notify the adapter

                isset= true;


            } else {

                convertView = infalInflater.inflate(R.layout.menu_child, null);

                TextView tv = (TextView) convertView.findViewById(R.id.textView_name);
                MajorUtils.logit("html", child.getName().toString());
                tv.setText(Html.fromHtml(child.getName().toString()));

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

