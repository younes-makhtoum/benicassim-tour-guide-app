package com.example.android.benicassim;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.benicassim.R.id.imageView;

/**
 * Created by Younes on 10/06/2017.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param locations  A list of location objects to display in a list
     */
    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, locations);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID location_title_text_view
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.location_title_text_view);
        // Get the title for the current Location object and set it to the Title TextView
        titleTextView.setText(currentLocation.getTitle());

        // Find the TextView in the list_item.xml layout with the ID location_description_text_view
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.location_description_text_view);
        // Get the title for the current Location object and set it to the Title TextView
        descriptionTextView.setText(currentLocation.getDescription());

        // Find the TextViews in the list_item.xml layout with the ID:
        // location_website_text_view,
        // location_address_text_view,
        // location_phone_number_text_view,
        // location_opening_hours_text_view
        // location_picture_image_view
        TextView websiteTextView = (TextView) listItemView.findViewById(R.id.location_website_text_view);
        final TextView addressTextView = (TextView) listItemView.findViewById(R.id.location_address_text_view);
        TextView phoneNumberTextView = (TextView) listItemView.findViewById(R.id.location_phone_number_text_view);
        TextView openingHoursTextView = (TextView) listItemView.findViewById(R.id.location_opening_hours_text_view);
        ImageView pictureImageView = (ImageView) listItemView.findViewById(R.id.location_picture_image_view);

        // Check if only basic information are provided for the location, and accordingly hide or display the additional details for the location
        if (currentLocation.hasOnlyBasicInfo()) {
            // Hide the views for location with basic information
            addressTextView.setVisibility(View.GONE);
            phoneNumberTextView.setVisibility(View.GONE);
        } else {
            // Display the additional information in the respective views and display them
            addressTextView.setText(currentLocation.getAddress());
            phoneNumberTextView.setText(currentLocation.getPhoneNumber());
            addressTextView.setVisibility(View.VISIBLE);
            phoneNumberTextView.setVisibility(View.VISIBLE);
        }

        // Check if a website is provided for the location or not
        if (currentLocation.hasWebsite()) {
            // If a website is available, display the URL on the resource ID
            websiteTextView.setText(currentLocation.getWebsite());
            // Make sure the related view is visible
            websiteTextView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the view
            websiteTextView.setVisibility(View.GONE);
        }

        // Check if opening hours are provided for the location or not
        if (currentLocation.hasOpeningHours()) {
            // If opening hours are available, display them on the resource ID
            openingHoursTextView.setText(currentLocation.getOpeningHours());
            // Make sure the related view is visible
            openingHoursTextView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the view
            openingHoursTextView.setVisibility(View.GONE);
        }

        // Check if an image is provided for this location or not
        if (currentLocation.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            pictureImageView.setImageResource(currentLocation.getImageResourceId());
            // Make sure the view is visible
            pictureImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            pictureImageView.setVisibility(View.GONE);
        }

        // Set a click listener on the location's address TextView
        addressTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the addressTextView is clicked on.
            @Override
            public void onClick(View view) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "geo:0,0?q=" + Uri.encode(addressTextView.getText().toString())));
                if (geoIntent.resolveActivity(view.getContext().getPackageManager()) != null)
                    view.getContext().startActivity(geoIntent);
            }
        });

        // Return the whole list item layout (containing at most 5 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

