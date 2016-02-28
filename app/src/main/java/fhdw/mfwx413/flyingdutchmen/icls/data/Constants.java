package fhdw.mfwx413.flyingdutchmen.icls.data;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.02.2016: Adding constants for default period-classes in minutes
 * Updated by Daniel on 21.02.2016: Adding constant for default timestamp of a challenge
 * Updated by Jonas on 23.02.2016: Adding constants for navigation between activities
 *
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
    public static final String KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE = "P1";
    public static final String KEY_PARAM_CURRENT_CHALLENGE_ID = "P2";
    public static final String KEY_PARAM_CHOSEN_USER = "P3";
    public static final String KEY_PARAM_CHOSEN_FILE = "P4";
    public static final String KEY_PARAM_IS_ANSWER_CORRECT = "P5";


}
