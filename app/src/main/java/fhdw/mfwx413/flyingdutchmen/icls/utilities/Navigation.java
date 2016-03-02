package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.app.Activity;
import android.content.Intent;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.02.2016: startActivityAddNewUser
 * Updated by Max on 21.02.2016: startActivityChooseFile, startActivityEditUser
 * Updated by Jonas on 23.02.2016: startActivityFeedbackChallengeRest
 * Updated by Daniel on 25.02.2016: startActivityChallengeMultipleChoice
 */
public class Navigation {

    public static void startActivityAddNewUser(Activity callingActivity) {
        Intent intent;
        intent = new Intent(callingActivity, fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChallengeFreeAnswer(Activity callingActivity, ChallengeCollection dueChallengesOfUserInFile, int currentChallengeId, User chosenUser, IndexCard chosenFile){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE, dueChallengesOfUserInFile);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_FILE, chosenFile);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChallengeImagineAnswer(Activity callingActivity, ChallengeCollection dueChallengesOfUserInFile, int currentChallengeId, User chosenUser, IndexCard chosenFile){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE, dueChallengesOfUserInFile);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_FILE, chosenFile);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    //changed by Daniel 25.02.2016
    public static void startActivityChallengeMultipleChoice(Activity callingActivity, ChallengeCollection dueChallengesOfUserInFile, int currentChallengeId, User chosenUser, IndexCard chosenFile){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE, dueChallengesOfUserInFile);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_FILE, chosenFile);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChooseFile(Activity callingActivity, User chosenUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityEditUser(Activity callingActivity, User chosenUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.EditUser.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    //changed by Jonas 23.02.2016
    public static void startActivityFeedbackChallengeRest(Activity callingActivity, ChallengeCollection dueChallengesOfUserInFile, int currentChallengeId, User chosenUser, IndexCard chosenFile, boolean isAnswerCorrect){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE, dueChallengesOfUserInFile);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_FILE, chosenFile);
        intent.putExtra(Constants.KEY_PARAM_IS_ANSWER_CORRECT, isAnswerCorrect);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    //changed by Edgar 23.02.2016
    public static void startActivityFeedbackImagineAnswer(Activity callingActivity, ChallengeCollection dueChallengesOfUserInFile, int currentChallengeId, User chosenUser, IndexCard chosenFile){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_OF_USER_IN_FILE, dueChallengesOfUserInFile);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_FILE, chosenFile);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityFinalEndOfChallenges(Activity callingActivity, User chosenUser, IndexCard chosenFile){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FinalEndOfChallenges.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivitySettingMenu(Activity callingActivity, User chosenUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityStartMenu(Activity callingActivity){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityStatistics(Activity callingActivity, User chosenUser, IndexCard chosenFile, ChallengeCollection mDueChallenges){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_FILE, chosenFile);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startFragmentLogout(Activity callingActivity, User chosenUser) {
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FragLogout.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }
}