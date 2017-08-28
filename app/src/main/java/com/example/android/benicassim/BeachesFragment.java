package com.example.android.benicassim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BeachesFragment.OnFragmentInteractionListener} interface to handle interaction events.
 */
public class BeachesFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BeachesFragment() {
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
        locations.add(new Location(getString(R.string.beach_name_1), getString(R.string.beach_description_1), R.drawable.img_beach_voramar));
        locations.add(new Location(getString(R.string.beach_name_2), getString(R.string.beach_description_2), R.drawable.img_beach_heliopolis));
        locations.add(new Location(getString(R.string.beach_name_3), getString(R.string.beach_description_3), R.drawable.img_beach_torreon));
        locations.add(new Location(getString(R.string.beach_name_4), getString(R.string.beach_description_4), R.drawable.img_beach_almadraba));
        locations.add(new Location(getString(R.string.beach_name_5), getString(R.string.beach_description_5), R.drawable.img_beach_els_terrers));

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
        void onBeachesFragmentInteraction(Uri uri);
    }
}
