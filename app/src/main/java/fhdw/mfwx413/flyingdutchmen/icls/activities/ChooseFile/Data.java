package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;

/**
 * Created by edgar on 17.02.2016.
 */
public class Data {

    private Activity mActivity;
    private User mCurrentUser;
    private UserProgressCollection allUserProgresses;
    private IndexCard mCurrentIndexCard;
    private IndexCardCollection mAllIndexCards;
    private ChallengeCollection mAllChallenges;
    private ChallengeCollection mChallengesCurrentIndexCard;
    private UserProgressCollection mUserProgressForCurrentIndexCard;
    private UserProgressCollection mUserProgressForCurrentIndexCardAndCurrentUser;
    private ChallengeCollection mDueChallenges;
    private Challenge mChacheChallenge;
    private String mCurrentTime;
    private String mTimeStampBeantwortung;
    private List<String> mTimeStampsLastAnsweredStrings;
    private List<Date> mTimeStampsLastAnsweredDates;

    private int mPeriodClass1;
    private int mPeriodClass2;
    private int mPeriodClass3;
    private int mPeriodClass4;
    private int mPeriodClass5;
    private int mPeriodClass6;

    public Data(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        mActivity = activity;
        intent = activity.getIntent();

        allUserProgresses = UserProgressDatabase.getAllUserProgresses(mActivity);
        mAllIndexCards = IndexCardDatabase.getIndexCards(mActivity);
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);

        if (savedInstanceState == null) {
            mCurrentUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
        }
        else {
            restoreDataFromBundle(savedInstanceState);
        }

        // TEST
        // getCurrentTimeStamp();
        // Log.d("Current Time: ", "" + mCurrentTime);

        getCurrentUsersSettings();


    }

    public void saveDataFromBundle(Bundle savedInstanceState) {
        savedInstanceState.putSerializable(Constants.KEY_PARAM_CHOSEN_USER, mCurrentUser);
    }

    public void restoreDataFromBundle(Bundle savedInstanceState) {
        mCurrentUser = (User) savedInstanceState.getSerializable(Constants.KEY_PARAM_CHOSEN_USER);
    }

    public IndexCardCollection getAllIndexCards() {
        return mAllIndexCards;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public IndexCard getCurrentIndexCard() {
        return mCurrentIndexCard;
    }

    public void setCurrentIndexCard(IndexCard mCurrentIndexCard) {
        this.mCurrentIndexCard = mCurrentIndexCard;
    }

    // Beginn Algorithmus DueChallenges. Aufruf der Methoden in ApplicationLogic bei onButtonStartLearningClicked

     //I. -> Aus allen Challenges die mit passender Indexcard sortieren: Liste aller Fragen der gewählten IndexCard (L1)
    public ChallengeCollection getChallengesForSelectedIndexCard(){
        for(int i=0; i<mAllChallenges.getSize(); i++) {
            if(mAllChallenges.getChallenge(i).getmIndexCard().getmID() == mCurrentIndexCard.getmID()) {
                mChallengesCurrentIndexCard.addChallenge(mAllChallenges.getChallenge(i));
            }
        }
        return mChallengesCurrentIndexCard;

    }

     // II. -> Aus UserProgressCollection die mit übrig gebliebener ChallengeId sortieren: Liste des UserProgress mit allen Fragen der gewählten IndexCard (L2)
    public UserProgressCollection getUserProgressForCurrentIndexCard() {
        for(int k=0; k<allUserProgresses.getSize(); k++){
            for(int l=0; l<mChallengesCurrentIndexCard.getSize(); l++) {
                if(allUserProgresses.getUserProgress(k).getmChallengeID() == mChallengesCurrentIndexCard.getChallenge(l).getmID()) {
                    mUserProgressForCurrentIndexCard.addUserProgress(allUserProgresses.getUserProgress(k));
                }
            }
        }
        return mUserProgressForCurrentIndexCard;
    }

     // III. -> Aus vorheriger Liste (L2) den ausgewählten User sortieren: Liste des UserProgress mit allen Fragen der gewählten IndexCard & gewähltem User (L3)

    public UserProgressCollection getUserProgressForCurrentIndexCardAndCurrentUser() {
        for(int m=0; m<mUserProgressForCurrentIndexCard.getSize(); m++) {
            if(mUserProgressForCurrentIndexCard.getUserProgress(m).getmUserName().equals(mCurrentUser.getmName())) {
                mUserProgressForCurrentIndexCardAndCurrentUser.addUserProgress(allUserProgresses.getUserProgress(m));
            }
        }
        return mUserProgressForCurrentIndexCardAndCurrentUser;
    }

    // IV. -> Aktuelles Tagesdatum zwischenspeichern und in Format yyyy.MM.dd.HH.mm.ss umwandeln
    public void getCurrentTimeStamp() {
        // mCurrentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        Date CurrentDate = new Date(t);

        /** Date aftermPeriodClass1 = new Date(t + mPeriodClass1 * 60000);
        Log.d("", "" + CurrentDate);
        Log.d("", "" + aftermPeriodClass1);
        */
    }

    // V. TimeStampsLastAnswered zwischenspeichern und in passendes Format umwandeln

    /**public void getTimeStampsLastAnswered() {
        for(int n=0; n<mUserProgressForCurrentIndexCardAndCurrentUser.getSize(); n++) {
            mTimeStampsLastAnsweredStrings.add(n, mUserProgressForCurrentIndexCardAndCurrentUser.getUserProgress(n).getmTimeStampAnswered());
            SimpleDateFormat mChacheLastAnswered = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            mTimeStampsLastAnsweredDates.add(mChacheLastAnswered.parse(mTimeStampsLastAnsweredStrings.get(n)));


                    //= mChacheLastAnswered.parse(mTimeStampsLastAnsweredStrings(n));
        }
    }*/

    // VI. -> UserSettings zwischenspeichern

    public void getCurrentUsersSettings() {
        mPeriodClass1 = mCurrentUser.getmPeriodClass1();
        mPeriodClass2 = mCurrentUser.getmPeriodClass2();
        mPeriodClass3 = mCurrentUser.getmPeriodClass3();
        mPeriodClass4 = mCurrentUser.getmPeriodClass4();
        mPeriodClass5 = mCurrentUser.getmPeriodClass5();
        mPeriodClass6 = mCurrentUser.getmPeriodClass6();
    }
     // VII. -> Aus vorheriger Liste (L3) jeden Timestamp-Eintrag >= Timestamp+UserSetting der Klasse: Liste fälliger Challenges (L4)

     //Klasse1: wenn LastPlayed+SettingsKlasse1 größerGleich Tagesdatum, dann auf dueChallengeList.

     /**public ChallengeCollection getDueChallengeList(){
         for(int n=0; n<mUserProgressForCurrentIndexCardAndCurrentUser.getSize(); n++) {

             //String Test;
             //Test = mUserProgressForCurrentIndexCardAndCurrentUser.getUserProgress(n).getmTimeStampBeantwortung()+mPeriodClass1;

             if(mUserProgressForCurrentIndexCardAndCurrentUser.getUserProgress(n).getmZeitklasse() == 1 && ) {
                 int mCacheId = mUserProgressForCurrentIndexCardAndCurrentUser.getUserProgress(n).getmChallengeID();

                 // mChacheChallenge = ChallengeCollection.getChallenge(mCacheId);
                 // mDueChallenges.addChallenge();
             }
         }
         return mDueChallenges;
     }*/

    // VIII. -> Einträge von L4 auslesen und je nach FrageTypLayout entsprechende Acitivity rufen. Parameter übergeben.

}