package com.oyeplay.android.dashboardfragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.oyeplay.android.R;
import com.oyeplay.android.adapter.ExpandableAdapter;
import com.oyeplay.android.bean.BeanChild;
import com.oyeplay.android.bean.BeanGroup;
import com.oyeplay.android.userinterface.ReviewsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GamesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GamesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GamesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GamesFragment newInstance(String param1) {//, String param2) {
        GamesFragment fragment = new GamesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_games, container, false);
        ExpandableListView expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
        ArrayList<BeanGroup> groupArrayList;
        ExpandableAdapter menuAdapter;
        String json = getArguments().getString("json");
        String selection = getArguments().getString("selection");
        try {
            JSONObject mjson = new JSONObject(json);

            groupArrayList = SetStandardGroups(mjson, selection);

            menuAdapter = new ExpandableAdapter(getActivity(), groupArrayList);
            expandableListView.setAdapter(menuAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(groupPosition == 5){
                    Intent intent = new Intent(getContext(), ReviewsActivity.class);
                    getContext().startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public ArrayList<BeanGroup> SetStandardGroups(JSONObject jsonObject, String selection) throws JSONException {


        JSONObject sportdata = jsonObject.getJSONObject("data").getJSONObject("cbg").getJSONObject(selection);


        String group_names[] = {"Offers", "Description", "Amenities", "Guidelines to use playground", "Rate Card",
                "Reviews"};


        String cateogry_names[] = {validatedata(sportdata.getString("offers"), "No offers right now"),
                validatedata(sportdata.getString("de"),jsonObject.getJSONObject("data").getString("title")),
                getfacilities(sportdata.getString("facilities")),
                "", "", ""};


        ArrayList<BeanGroup> list = new ArrayList<BeanGroup>();
        ArrayList<BeanChild> ch_list;
        int i = 0;

        for (i = 0; i < group_names.length; i++) {
            BeanGroup gru = new BeanGroup();
            gru.setName((group_names[i]));


            ch_list = new ArrayList<BeanChild>();


            BeanChild ch = new BeanChild();
            ch.setName(cateogry_names[i]);
            ch_list.add(ch);

            gru.setItems(ch_list);
            list.add(gru);
        }

        return list;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public String validatedata(String validate,String backup){

        if (validate==null ||validate=="null"){return  backup;}else{return validate;}
    }
    public String getfacilities(String g) throws JSONException {
        String value = "";
        JSONArray jsonArray = new JSONArray(g);
        for (int i = 0; i < jsonArray.length(); i++) {

            value = value + String.valueOf(i) + "." + jsonArray.get(i)+"<br /><br />";

        }
        return value;
    }
}
