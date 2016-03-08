package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.app.Activity;
import android.content.Intent;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.02.2016: startActivityAddNewUser
 * Updated by Max on 21.02.2016: startActivityChooseIndexCard, startActivityEditUser
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

    public static void startActivityChallengeFreeAnswer(Activity callingActivity, ChallengeCollection dueChallengesForUserInIndexCard, int currentChallengeId, User chosenUser, IndexCard chosenIndexCard, UserProgressCollection userProgressCurrentUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, dueChallengesForUserInIndexCard);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD, chosenIndexCard);
        intent.putExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER, userProgressCurrentUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChallengeImagineAnswer(Activity callingActivity, ChallengeCollection dueChallengesForUserInIndexCard, int currentChallengeId, User chosenUser, IndexCard chosenIndexCard, UserProgressCollection userProgressCurrentUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, dueChallengesForUserInIndexCard);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD, chosenIndexCard);
        intent.putExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER, userProgressCurrentUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    //changed by Daniel 25.02.2016
    public static void startActivityChallengeMultipleChoice(Activity callingActivity, ChallengeCollection dueChallengesForUserInIndexCard, int currentChallengeId, User chosenUser, IndexCard chosenIndexCard, UserProgressCollection userProgressCurrentUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, dueChallengesForUserInIndexCard);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD, chosenIndexCard);
        intent.putExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER, userProgressCurrentUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityChooseIndexCard(Activity callingActivity, User chosenUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseIndexCard.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    /** Function not supported in this version of app
    public static void startActivityEditUser(Activity callingActivity, User chosenUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.EditUser.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }
    */

    //changed by Jonas 23.02.2016
    public static void startActivityFeedbackChallengeRest(Activity callingActivity, ChallengeCollection dueChallengesForUserInIndexCard, int currentChallengeId, User chosenUser, IndexCard chosenIndexCard, boolean isAnswerCorrect, UserProgressCollection userProgressCurrentUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, dueChallengesForUserInIndexCard);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD, chosenIndexCard);
        intent.putExtra(Constants.KEY_PARAM_IS_ANSWER_CORRECT, isAnswerCorrect);
        intent.putExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER, userProgressCurrentUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    //changed by Edgar 23.02.2016
    public static void startActivityFeedbackImagineAnswer(Activity callingActivity, ChallengeCollection dueChallengesForUserInIndexCard, int currentChallengeId, User chosenUser, IndexCard chosenIndexCard, UserProgressCollection userProgressCurrentUser){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer.Init.class);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, dueChallengesForUserInIndexCard);
        intent.putExtra(Constants.KEY_PARAM_CURRENT_CHALLENGE_ID, currentChallengeId);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD, chosenIndexCard);
        intent.putExtra(Constants.KEY_PARAM_USER_PROGRESS_CURRENT_USER, userProgressCurrentUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityFinalEndOfChallenges(Activity callingActivity, User chosenUser, IndexCard chosenIndexCard){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FinalEndOfChallenges.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD, chosenIndexCard);
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

    public static void startActivityStatistics(Activity callingActivity, User chosenUser, IndexCard chosenIndexCard, ChallengeCollection dueChallengesForUserInIndexCard){
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_INDEX_CARD, chosenIndexCard);
        intent.putExtra(Constants.KEY_PARAM_DUE_CHALLENGES_FOR_USER_IN_INDEX_CARD, dueChallengesForUserInIndexCard);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityLogout(Activity callingActivity, User chosenUser) {
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.FragLogout.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityDuplicateIndexCards(Activity callingActivity) {
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.DuplicateIndexCards.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityNoChallengesForCurrentIndex(Activity callingActivity, User chosenUser) {
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.NoChallengesForCurrentIndexCard.Init.class);
        intent.putExtra(Constants.KEY_PARAM_CHOSEN_USER, chosenUser);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }

    public static void startActivityNoIndexCardsAvailable(Activity callingActivity) {
        Intent intent;
        intent = new Intent(callingActivity,fhdw.mfwx413.flyingdutchmen.icls.activities.NoIndexCardsAvailable.Init.class);
        callingActivity.startActivity(intent);
        callingActivity.finish();
    }
}