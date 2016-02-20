package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.app.Activity;
import android.content.Intent;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016: startActivityAddNewUser
 */
public class Navigation {

    public static void startActivityAddNewUser(Activity callingActivity) {
        Intent intent;
        intent = new Intent(callingActivity, fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChallengeFreeAnswer(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChallengeImagineAnswer(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChallengeMultipleChoice(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChooseFile(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityEditUser(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.EditUser.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityFeedbackChallengeRest(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityFeedbackImagineAnswer(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityFinalEndOfChallenges(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FinalEndOfChallenges.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivitySettingMenu(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityStartMenu(Activity callingActivity, int currentChallengeId, int numberCorrectChallenges){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityStatistics(Activity callingActivity, int currentChallengeId, int numberCorrectChallenges){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

}