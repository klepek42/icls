package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;

/**
 * Created by edgar on 13.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 20.02.2016
 * Updated by Max on 21.02.2016
 * Updated by Max on 22.02.2016
 * Updated by Max on 24.02.2016
 * Updated by Max on 27.02.2016
 * Updated by Max on 01.03.2016
 */

// Data initializes all the data that is relevant in the current activity
public class Data {

    private Activity mActivity;
    private User mCurrentUser;
    private IndexCard mCurrentIndexCard;
    private UserProgressCollection mCurrentUserUserProgresses;
    private IndexCardCollection mAllIndexCards;
    private ChallengeCollection mAllChallenges;
    private ChallengeCollection mChallengesCurrentIndexCard;
    private UserProgressCollection mCurrentUserUserProgressForCurrentIndexCard;
    private Date mLastAnsweredDate;
    private Date CurrentDate;
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

        if (savedInstanceState == null) {
            mCurrentUser = (User) intent.getSerializableExtra(Constants.KEY_PARAM_CHOSEN_USER);
        }
        else {
            restoreDataFromBundle(savedInstanceState);
        }

        Log.d("CurrentUser: " , ""+mCurrentUser.getName());

        // collects all the existing user progresses of current user from UserProgressDatabase
        mCurrentUserUserProgresses = UserProgressDatabase.getUserProgresses(mActivity, mCurrentUser.getName());
        // collects all the existing index cards from IndexCardsDatabase
        mAllIndexCards = IndexCardDatabase.getIndexCards();
        // collects all the existing challenges from ChallengeDatabase
        mAllChallenges = ChallengeDatabase.getAllChallenges(mActivity);
    }

    public void saveDataFromBundle(Bundle savedInstanceState) {
        savedInstanceState.putSerializable(Constants.KEY_PARAM_CHOSEN_USER, mCurrentUser);
    }

    public void restoreDataFromBundle(Bundle savedInstanceState) {
        mCurrentUser = (User) savedInstanceState.getSerializable(Constants.KEY_PARAM_CHOSEN_USER);
    }

    public UserProgressCollection getCurrentUserUserProgresses() {
        return mCurrentUserUserProgresses;
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

    // Checks for duplicate IndexCards that could cause errors later in application
    public boolean checkForDuplicates() throws IdNotFoundException {
        int index=1;
        int counter;
        String mCacheIndexCard;
        String mCheckIndexCard;
        boolean duplicate=false;

        if(mAllIndexCards.getSize()>1){
            while(index<mAllIndexCards.getSize()){
                mCacheIndexCard = mAllIndexCards.getIndexCard(index).getmName();
                counter=index+1;
                while(counter<=mAllIndexCards.getSize()) {
                    mCheckIndexCard = mAllIndexCards.getIndexCard(counter).getmName();
                    if(mCacheIndexCard.equals(mCheckIndexCard)){
                        duplicate = true;
                    }
                    counter++;
                }
                index++;
            }
        }
        return duplicate;
    }

    // Checks if any IndexCard records exist
    public boolean checkForRecords() {
        boolean recordsExist = false;
        if(mAllIndexCards.getSize() == 0) {
            recordsExist = true;
        }
        return recordsExist;
    }

    /**
     * Start of methods to calculate due Challenges. Methods are called in ApplicationLogic at onButtonStartLearningClicked
     */

    // I. -> Get ChallengeCollection with current Index Card out of all Challenges and save them as a new ChallengeCollection L1
    public ChallengeCollection getChallengesForSelectedIndexCard() {
        mChallengesCurrentIndexCard = new ChallengeCollection();
        for(int i=0; i<mAllChallenges.getSize(); i++) {
            if(mAllChallenges.getChallenge(i).getmIndexCard().getmID() == mCurrentIndexCard.getmID()) {
                mChallengesCurrentIndexCard.addChallenge(mAllChallenges.getChallenge(i));
            }
        }
        return mChallengesCurrentIndexCard;
    }

    // II. -> Get UserProgressCollection with current Index Card out of CurrentUserUserProgress and save them as a new UserProgressCollection L2
    public UserProgressCollection getUserProgressForCurrentIndexCard() throws UserProgressNotFoundException {
        mCurrentUserUserProgressForCurrentIndexCard = new UserProgressCollection();
        for(int i=0; i< mCurrentUserUserProgresses.getSize(); i++){
            for(int j=0; j<mChallengesCurrentIndexCard.getSize(); j++) {
                if(mCurrentUserUserProgresses.getUserProgress(i).getmChallengeID() == mChallengesCurrentIndexCard.getChallenge(j).getmID()) {
                    mCurrentUserUserProgressForCurrentIndexCard.addUserProgress(mCurrentUserUserProgresses.getUserProgress(i));
                }
            }
        }
        if (mCurrentUserUserProgressForCurrentIndexCard.getSize() == 0){
            throw new UserProgressNotFoundException("Fehler beim Erstellen von CurrentUserUserProgressForCurrentIndexCard");
        }

        return mCurrentUserUserProgressForCurrentIndexCard;

    }

    // III. -> Save the current date
    public void getCurrentTime() {
        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        CurrentDate = new Date(t);
    }

    // IV. -> Get TimeStamps out of L3 and save them in a format that is comparable to the current date
    @SuppressLint("SimpleDateFormat")
    public void getTimeStampLastAnswered(int index) throws ParseException {
        SimpleDateFormat mLastAnsweredFormat;
        String mTimeStampLastAnswered;
        mTimeStampLastAnswered = mCurrentUserUserProgressForCurrentIndexCard.getUserProgress(index).getmTimeStampAnswered();
        mLastAnsweredFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        mLastAnsweredDate = mLastAnsweredFormat.parse(mTimeStampLastAnswered);
    }

    // V. -> Converts Date to Calendar
    public static Calendar DateToCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    // VI. -> Save UserSettings of current User
    public void getCurrentUsersSettings() {
        mPeriodClass1 = mCurrentUser.getPeriodClass1();
        mPeriodClass2 = mCurrentUser.getPeriodClass2();
        mPeriodClass3 = mCurrentUser.getPeriodClass3();
        mPeriodClass4 = mCurrentUser.getPeriodClass4();
        mPeriodClass5 = mCurrentUser.getPeriodClass5();
        mPeriodClass6 = mCurrentUser.getPeriodClass6();
    }

     // VII. -> Check every record of L3 for due challenges by adding the minutes from users settings of the particular PeriodClass to the TimeStampLastAnswered and compare to current Date. Save them as a new ChallengeCollection L4 if due.
     public ChallengeCollection getDueChallengeList() throws ParseException, IdNotFoundException {
         ChallengeCollection mDueChallenges;
         mDueChallenges = new ChallengeCollection();
         int mCurrentClass;
         int mCacheChallengeId;
         Challenge mCacheChallenge;

         getCurrentTime();
         getCurrentUsersSettings();

         for(int n=0; n<mCurrentUserUserProgressForCurrentIndexCard.getSize(); n++) {
             getTimeStampLastAnswered(n);
             Calendar mLastAnsweredCalendar = DateToCalendar(mLastAnsweredDate);

             //TEST
             Log.d("mLastAnsweredDate: ", "" + mLastAnsweredDate);
             //EOT

             mCurrentClass = mCurrentUserUserProgressForCurrentIndexCard.getUserProgress(n).getmPeriodClass();

             switch (mCurrentClass) {
                 case 1: mLastAnsweredCalendar.add(Calendar.MINUTE, mPeriodClass1);
                     break;
                 case 2: mLastAnsweredCalendar.add(Calendar.MINUTE, mPeriodClass2);
                     break;
                 case 3: mLastAnsweredCalendar.add(Calendar.MINUTE, mPeriodClass3);
                     break;
                 case 4: mLastAnsweredCalendar.add(Calendar.MINUTE, mPeriodClass4);
                     break;
                 case 5: mLastAnsweredCalendar.add(Calendar.MINUTE, mPeriodClass5);
                     break;
                 case 6: mLastAnsweredCalendar.add(Calendar.MINUTE, mPeriodClass6);
                     break;
             }

             mLastAnsweredDate = mLastAnsweredCalendar.getTime();

             //TEST
             Log.d("mLastAnswered+PClass: ", "" + mLastAnsweredDate);
             Log.d("mCurrentDate: ", "" + CurrentDate);
             //EOT

             if(mLastAnsweredDate.before(CurrentDate) || mLastAnsweredDate.equals(CurrentDate)) {
                 mCacheChallengeId = mCurrentUserUserProgressForCurrentIndexCard.getUserProgress(n).getmChallengeID();
                 mCacheChallenge = mAllChallenges.getChallengeByKey(mCacheChallengeId);
                 mDueChallenges.addChallenge(mCacheChallenge);
             }
         }
         return mDueChallenges;
     }
}