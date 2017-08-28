package com.example.android.benicassim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LeisureParksFragment.OnFragmentInteractionListener} interface to handle interaction events.
 */
public class LeisureParksFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public LeisureParksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.leisure_park_name_1), getString(R.string.leisure_park_description_1), getString(R.string.leisure_park_web_1), getString(R.string.leisure_park_address_1), getString(R.string.leisure_park_phone_1), getString(R.string.leisure_park_opening_hours_1), R.drawable.img_leisure_park_aquarama));
        locations.add(new Location(getString(R.string.leisure_park_name_2), getString(R.string.leisure_park_description_2), getString(R.string.leisure_park_web_2), getString(R.string.leisure_park_address_2), getString(R.string.leisure_park_phone_2), getString(R.string.leisure_park_opening_hours_2), R.drawable.img_leisure_park_desierto_las_palmas));
        locations.add(new Location(getString(R.string.leisure_park_name_3), getString(R.string.leisure_park_description_3), getString(R.string.leisure_park_web_3), getString(R.string.leisure_park_address_3), getString(R.string.leisure_park_phone_3), getString(R.string.leisure_park_opening_hours_3), R.drawable.img_leisure_park_moli_de_la_font));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void onLeisureParksFragmentInteraction(Uri uri);
    }
}
