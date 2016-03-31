package com.example.matthew.howtoml;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JoeXL on 27/03/2016.
 */
public class HomepageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* Set the layout to use the fragment_homepage file */
        View rootView = inflater.inflate(R.layout.fragment_homepage, container, false);
        return rootView;
    }

}
