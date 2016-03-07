package fhdw.mfwx413.flyingdutchmen.icls.data;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.02.2016: Adding constants for default period-classes in minutes
 * Updated by Daniel on 21.02.2016: Adding constant for default timestamp of a challenge
 * Updated by Jonas on 23.02.2016: Adding constants for navigation between activities
 * Updated by Daniel on 01.03.2016: Adding constants for Bundles
 */
public class Constants {
    public static final String KEY_PARAM_ID = "X1";

    // Constants for default period-classes in minutes
    public static final int PERIOD_CLASS_1 = 5;
    // 1hour
    public static final int PERIOD_CLASS_2 = 60;
    // 24 hours
    public static final int PERIOD_CLASS_3 = 1440;
    // 7 days
    public static final int PERIOD_CLASS_4 = 10080;
    // 30 days
    public static final int PERIOD_CLASS_5 = 43200;
    // 180 days
    public static final int PERIOD_CLASS_6 = 259200;
    // end of constants for default period-classes

    //Constant for default timestamp in format "yyyy.MM.dd.HH.mm.ss"
    public static final String DEFAULT_TIMESTAMP = "2000.01.01.00.00.00";

    //Constants for navigation between activities
    public static final String KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD = "P1";
    public static final String KEY_PARAM_CURRENT_CHALLENGE_ID = "P2";
    public static final String KEY_PARAM_CHOSEN_USER = "P3";
    public static final String KEY_PARAM_CHOSEN_INDEX_CARD = "P4";
    public static final String KEY_PARAM_IS_ANSWER_CORRECT = "P5";
    public static final String KEY_PARAM_USER_PROGRESS_CURRENT_USER = "P6";

    //Constants for Bundles
    public static final String BUNDLE_KEY_CURRENT_CHALLENGE_ID = "K1";
    public static final String BUNDLE_KEY_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD = "K2";
    public static final String BUNDLE_KEY_CHOSEN_USER = "K3";
    public static final String BUNDLE_KEY_CHOSEN_INDEX_CARD = "K4";
    public static final String BUNDLE_KEY_IS_ANSWER_CORRECT = "K5";
    public static final String BUNDLE_KEY_USER_PROGRESS_CURRENT_USER = "K6";

}
