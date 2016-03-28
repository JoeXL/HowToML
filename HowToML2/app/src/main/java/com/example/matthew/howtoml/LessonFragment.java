package com.example.matthew.howtoml;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by JoeXL on 25/03/2016.
 */
public class LessonFragment extends Fragment {

    public static LessonFragment newInstance(int index) {
        LessonFragment f = new LessonFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container == null) {
            return null;
        }

        ScrollView scroller = new ScrollView(getActivity());
        return scroller;

    }
}
