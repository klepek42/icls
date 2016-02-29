package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

/**
 * Created by edgar on 17.02.2016.
 * Updated by Max on 20.12.2016
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
    private Date mLastAnsweredDate;
    private SimpleDateFormat mLastAnsweredFormat;
    private Date CurrentDate;

    private int mPeriodClass1;
    private int mPeriodClass2;
    private int mPeriodClass3;
    private int mPeriodClass4;
    private int mPeriodClass5;
    private int mPeriodClass6;

    public Data(Activity activity, Bundle savedInstanceState) throws ParseException {
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

    /**
     * Start of methods to calculate due Challenges. Methods are called in ApplicationLogic at onButtonStartLearningClicked
     */

    // I. -> Get ChallengesCollection with current Index out of all Challenges and save them as a new ChallengeCollection L1
    public ChallengeCollection getChallengesForSelectedIndexCard() throws NullPointerException {
        mChallengesCurrentIndexCard = new ChallengeCollection();
        for(int i=0; i<mAllChallenges.getSize(); i++) {
            if(mAllChallenges.getChallenge(i).getmIndexCard().getmID() == mCurrentIndexCard.getmID()) {
                mChallengesCurrentIndexCard.addChallenge(mAllChallenges.getChallenge(i));
            }
        }

        if (mChallengesCurrentIndexCard.getSize() == 0){
            Toast mNoChallengesForIndexCard = Toast.makeText(getActivity(), "Für die ausgewählte IndexCard stehen keine Challenges zur Verfuegung!", Toast.LENGTH_LONG);
            mNoChallengesForIndexCard.show();

            throw new NullPointerException();
        }
        return mChallengesCurrentIndexCard;
    }

    // II. -> Get UserProgressesCollection with current Index out of all UserProgresses and save them as a new UserProgressCollection L2
    public UserProgressCollection getUserProgressForCurrentIndexCard() throws NullPointerException {
        mUserProgressForCurrentIndexCard = new UserProgressCollection();
        for(int k=0; k<allUserProgresses.getSize(); k++){
            for(int l=0; l<mChallengesCurrentIndexCard.getSize(); l++) {
                if(allUserProgresses.getUserProgress(k).getmChallengeID() == mChallengesCurrentIndexCard.getChallenge(l).getmID()) {
                    mUserProgressForCurrentIndexCard.addUserProgress(allUserProgresses.getUserProgress(k));
                }
            }
        }

        if (mUserProgressForCurrentIndexCard.getSize() == 0){
            throw new NullPointerException();
        }

        return mUserProgressForCurrentIndexCard;
    }

    // III. -> Get UserProgressCollection with current User out of L2 and save them as a new UserProgressCollection L3
    public UserProgressCollection getUserProgressForCurrentIndexCardAndCurrentUser() throws NullPointerException {
        mUserProgressForCurrentIndexCardAndCurrentUser = new UserProgressCollection();
        for(int m=0; m<mUserProgressForCurrentIndexCard.getSize(); m++) {
            if(mUserProgressForCurrentIndexCard.getUserProgress(m).getmUserName().equals(mCurrentUser.getmName())) {
                mUserProgressForCurrentIndexCardAndCurrentUser.addUserProgress(allUserProgresses.getUserProgress(m));
            }
        }

        if (mUserProgressForCurrentIndexCardAndCurrentUser.getSize() == 0){
            throw new NullPointerException();
        }

        return mUserProgressForCurrentIndexCardAndCurrentUser;
    }

    // IV. -> Save the current date
    public void getCurrentTime() {
        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        CurrentDate = new Date(t);

        //TEST
        Log.d("CurrentDate: ", "" + CurrentDate);
        //EOT
    }

    // V. -> Get TimeStamps out of L3 and save them in a comparable format
    public void getTimeStampLastAnswered(int index) throws ParseException {
        String mTimeStampLastAnswered;

        mTimeStampLastAnswered = mUserProgressForCurrentIndexCardAndCurrentUser.getUserProgress(index).getmTimeStampAnswered();

        //TEST
        //mTimeStampLastAnswered = allUserProgresses.getUserProgress(0).getmTimeStampAnswered();
        //EOT

        mLastAnsweredFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        mLastAnsweredDate = mLastAnsweredFormat.parse(mTimeStampLastAnswered);
    }

    // Supporting method: Converts Date to Calendar
    public static Calendar DateToCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    // VI. -> Save UserSettings of current User
    public void getCurrentUsersSettings() {
        mPeriodClass1 = mCurrentUser.getmPeriodClass1();
        mPeriodClass2 = mCurrentUser.getmPeriodClass2();
        mPeriodClass3 = mCurrentUser.getmPeriodClass3();
        mPeriodClass4 = mCurrentUser.getmPeriodClass4();
        mPeriodClass5 = mCurrentUser.getmPeriodClass5();
        mPeriodClass6 = mCurrentUser.getmPeriodClass6();
    }

     // VII. -> Check every record of L3 for due challenges by adding the minutes from users settings of the particular PeriodClass to the TimeStampLastAnswered and compare to current Date. Save them as a new ChallengeCollection L4 if due.
     public ChallengeCollection getDueChallengeList() throws ParseException, IdNotFoundException {
         int mCurrentClass;
         int mCacheChallengeId;
         Challenge mCacheChallenge;

         getCurrentTime();

         for(int n=0; n<mUserProgressForCurrentIndexCardAndCurrentUser.getSize(); n++) {
             getTimeStampLastAnswered(n);
             Calendar mLastAnsweredCalendar = DateToCalendar(mLastAnsweredDate);

             Log.d("mLastAnsweredDate: ", "" + mLastAnsweredDate);
             Log.d("mLastAnsweredCalendar: ", "" + mLastAnsweredCalendar);

             mCurrentClass = mUserProgressForCurrentIndexCardAndCurrentUser.getUserProgress(n).getmPeriodClass();

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
                 default: //TODO Max: Fehlerhandling, wenn keine Klasse in UserProgress
                     break;
             }

             mLastAnsweredDate = mLastAnsweredCalendar.getTime();

             if(mLastAnsweredDate.before(CurrentDate) || mLastAnsweredDate.equals(CurrentDate)) {
                 mCacheChallengeId = mUserProgressForCurrentIndexCardAndCurrentUser.getUserProgress(n).getmChallengeID();
                 mCacheChallenge = mAllChallenges.getChallengeByKey(mCacheChallengeId);
                 mDueChallenges.addChallenge(mCacheChallenge);
             }
         }
         return mDueChallenges;
     }
}