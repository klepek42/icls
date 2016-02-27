package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.sql.Timestamp;
import java.util.Date;

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
    private UserProgressCollection UserProgressForCurrentIndexCardAndCurrentUser;

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

        /** TEST
        String CurrentTime;
        CurrentTime = getCurrentTimeStamp();
        Log.d("Current Time: ", "" + CurrentTime);
        */



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

    // Beginn Algorithmus DueChallenges. Aufruf der Methoden in ApplicationLogic bei

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
                UserProgressForCurrentIndexCardAndCurrentUser.addUserProgress(allUserProgresses.getUserProgress(m));
            }
        }
        return UserProgressForCurrentIndexCardAndCurrentUser;
    }

    // IV. -> Aktuelles Tagesdatum zwischenspeichern und in Format yyyy.MM.dd.HH.mm.ss umwandeln
    public String getCurrentTimeStamp() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return timestamp.toString();
    }

    /**
    // V. -> UserSettings zwischenspeichern

     //
     VI. -> Aus vorheriger Liste (L3) jeden Timestamp-Eintrag >= Timestamp+UserSetting der Klasse

     /**Klasse1: wenn LastPlayed+SettingsKlasse1 größerGleich Tagesdatum, dann auf dueChallengeList. Sonst, nächster Satz


     VII. -> 1.Eintrag von L3 auslesen und je nach FrageTypLayout nächste Acitivity rufen (case Anweisung). Parameter übergeben.
    */
}