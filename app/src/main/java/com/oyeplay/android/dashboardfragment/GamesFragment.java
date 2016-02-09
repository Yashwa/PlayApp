package com.oyeplay.android.dashboardfragment;

import android.content.Context;
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
    public static GamesFragment newInstance(String param1){//, String param2) {
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

        groupArrayList = SetStandardGroups();
        menuAdapter = new ExpandableAdapter(getActivity(), groupArrayList);
        expandableListView.setAdapter(menuAdapter);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public ArrayList<BeanGroup> SetStandardGroups() {

        String group_names[] = {"Offers", "Description", "Amenities", "Guidelines to use playground", "Rate Card",
                "Reviews"};


        String cateogry_names[] = {"20% OFF on weekdays"};


        ArrayList<BeanGroup> list = new ArrayList<BeanGroup>();
        ArrayList<BeanChild> ch_list;
        int i = 0;
        int j = 0;
        for (i = 0; i < group_names.length; i++) {
            BeanGroup gru = new BeanGroup();
            gru.setName((group_names[i]));
            ch_list = new ArrayList<BeanChild>();
            for (j = 0; j < cateogry_names.length; j++) {
                BeanChild ch = new BeanChild();
                ch.setName(cateogry_names[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);
        }

        return list;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
