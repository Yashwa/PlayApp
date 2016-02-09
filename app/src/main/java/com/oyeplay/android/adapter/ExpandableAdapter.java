package com.oyeplay.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.bean.BeanChild;
import com.oyeplay.android.bean.BeanGroup;

import java.util.ArrayList;


public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<BeanGroup> groups;
    private ArrayList<BeanChild> Items;

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
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.menu_child, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.textView_name);
        tv.setText(child.getName().toString());
//        TextView p1 = (TextView) convertView.findViewById(R.id.textView_price);
//        p1.setText(child.getPrice().toString());
//        TextView qt = (TextView) convertView.findViewById(R.id.textView_quantity);
//        qt.setText(child.getQuantity().toString());

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
        TextView tv = (TextView) convertView.findViewById(R.id.textView_header);
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

