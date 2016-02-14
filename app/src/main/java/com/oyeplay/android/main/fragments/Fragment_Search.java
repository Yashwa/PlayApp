package com.oyeplay.android.main.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.oyeplay.android.R;
import com.oyeplay.android.userinterface.ProfessionalsActivity;
import com.oyeplay.android.userinterface.ReviewsActivity;
import com.oyeplay.android.userinterface.SelectionActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Search extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RelativeLayout rel_playground,rel_adventuresports,rel_events,rel_players,rel_games,rel_professionsla,rel_centers;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Fragment_Search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Search newInstance(String param1, String param2) {
        Fragment_Search fragment = new Fragment_Search();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
      rel_centers = (RelativeLayout) view.findViewById(R.id.rel_centers);
        rel_adventuresports = (RelativeLayout) view.findViewById(R.id.rel_adventuresports);
        rel_playground = (RelativeLayout) view.findViewById(R.id.rel_playground);
        rel_events = (RelativeLayout) view.findViewById(R.id.rel_events);
        rel_players = (RelativeLayout) view.findViewById(R.id.rel_palyers);
        rel_games = (RelativeLayout) view.findViewById(R.id.rel_games);
        rel_professionsla = (RelativeLayout) view.findViewById(R.id.rel_professionals);

        rel_centers.setOnClickListener(this);
        rel_adventuresports.setOnClickListener(this);
        rel_playground.setOnClickListener(this);
        rel_events.setOnClickListener(this);
        rel_players.setOnClickListener(this);
        rel_games.setOnClickListener(this);
        rel_professionsla.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.rel_centers:
                break;

            case R.id.rel_playground:

                Intent playground = new Intent(getActivity(), SelectionActivity.class);
                launch(playground);
                break;

            case R.id.rel_adventuresports:
                Intent intent = new Intent(getActivity(), ProfessionalsActivity.class);
                launch(intent);

                break;

            case R.id.rel_events:
                break;

            case R.id.rel_games:
                break;

            case R.id.rel_palyers:
                break;

            case R.id.rel_professionals:
                break;



        }
    }

    public void launch(Intent intnet){
        getActivity().startActivity(intnet);
    }
}
