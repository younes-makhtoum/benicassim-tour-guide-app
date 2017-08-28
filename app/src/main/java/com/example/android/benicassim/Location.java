package com.example.android.benicassim;

/**
 * {@link Location} represents a location where the user may want to go.
 * It always contains a title and a description, and depending on cases, can contain one or several of these details:
 * address / phone number / opening hours
 */
public class Location {
    /** Title of the location */
    private String mTitle;

    /** Description of the location */
    private String mDescription;

    /** Website of the location */
    private String mWebsite = NO_WEBSITE_PROVIDED;

    /** Address of the location  */
    private String mAddress = NO_ADDRESS_PROVIDED;

    /** Phone number of the location  */
    private String mPhoneNumber = NO_PHONE_NUMBER_PROVIDED;

    /** Opening hours of the location  */
    private String mOpeningHours = NO_OPENING_HOURS_PROVIDED;

    /** Image resource ID for the location */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant values that represents no additional details about the location */
    private static final String NO_WEBSITE_PROVIDED = "";
    private static final String NO_ADDRESS_PROVIDED = "";
    private static final String NO_PHONE_NUMBER_PROVIDED = "";
    private static final String NO_OPENING_HOURS_PROVIDED = "";
    /** Constant value that represents no image was provided for the location */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new location object with only title, description and image
     *
     * @param Title is the title of location
     * @param Description is a description of the location
     * @param ImageResourceId is the image resource ID of the location
     */
    public Location(String Title, String Description, int ImageResourceId) {
        mTitle = Title;
        mDescription = Description;
        mImageResourceId = ImageResourceId;
    }

    /**
     * Create a new location object with full details
     *
     * @param Title is the title of location
     * @param Description is a description of the location
     * @param Website is the website of the location
     * @param Address is the address of the location
     * @param PhoneNumber is a phone number to call the location
     * @param OpeningHours is the opening hours of the location
     */
    public Location(String Title, String Description, String Website, String Address, String PhoneNumber, String OpeningHours) {
        mTitle = Title;
        mDescription = Description;
        mWebsite = Website;
        mAddress = Address;
        mPhoneNumber = PhoneNumber;
        mOpeningHours = OpeningHours;
    }

    /**
     * Create a new location object with full details and picture
     *
     * @param Title is the title of location
     * @param Description is a description of the location
     * @param Website is the website of the location
     * @param Address is the address of the location
     * @param PhoneNumber is a phone number to call the location
     * @param OpeningHours is the opening hours of the location
     * @param ImageResourceId is the image resource ID of the location
     */
    public Location(String Title, String Description, String Website, String Address, String PhoneNumber, String OpeningHours, int ImageResourceId) {
        mTitle = Title;
        mDescription = Description;
        mWebsite = Website;
        mAddress = Address;
        mPhoneNumber = PhoneNumber;
        mOpeningHours = OpeningHours;
        mImageResourceId = ImageResourceId;
    }

    /**
     * Get the title of the location
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the description of the location
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Get the description of the location
     */
    public String getWebsite() {
        return mWebsite;
    }

    /**
     * Get the address of the location
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get the phone number of the location
     */
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     * Get the opening hours of the location
     */
    public String getOpeningHours() {
        return mOpeningHours;
    }

    /**
     * Get the image of the location
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is a website provided for the location
     */
    public boolean hasWebsite() {
        return !mWebsite.equals(NO_WEBSITE_PROVIDED);
    }

    /**
     * Returns whether or not there are relevant opening hours provided for the location
     */
    public boolean hasOpeningHours() {
        return !mOpeningHours.equals(NO_OPENING_HOURS_PROVIDED);
    }

    /**
     * Returns whether or not there are additional details provided for the location
     */
    public boolean hasOnlyBasicInfo() {
        return mAddress.equals(NO_ADDRESS_PROVIDED) || mPhoneNumber.equals(NO_PHONE_NUMBER_PROVIDED);
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}

