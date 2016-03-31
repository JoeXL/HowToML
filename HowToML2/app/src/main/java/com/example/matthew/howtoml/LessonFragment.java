package com.example.matthew.howtoml;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JoeXL on 25/03/2016.
 */
public class LessonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* Set the layout to use the fragment_lesson file */
        View rootView = inflater.inflate(R.layout.fragment_lesson, container, false);
        return rootView;

        /* Below is a direct copy/paste from a tutorial I followed. This fragment in particular takes an input ID
        * and then uses that to decide what image to load into the PlanetFragment. The file fragment_planet is
        * simply an ImageView, so our will obviously be a bit more complex. Don't know if this will be of any help
        * as you might already have figured out how to load the correct page content. Either way it may be useful as
        * an example.*/
        //View rootView = inflater.inflate(R.layout.fragment_planet, container, false); //Same as what we already have but for the PlanetFragment class from the tutorial
        //int i = getArguments().getInt(ARG_PLANET_NUMBER); //Think the getArgument uses the Bundle in the parameters
        //String planet = getResources().getStringArray(R.array.planets_array)[i];
        //int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()), "drawable", getActivity().getPackageName());
        //((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
        //getActivity().setTitle(planet);
        //return rootView;
    }
}
