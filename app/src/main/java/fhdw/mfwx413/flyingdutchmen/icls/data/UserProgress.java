package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.text.SimpleDateFormat;

/**
 * Created by Daniel on 22.02.2016.
 * Responsibility: Daniel zur Linden
 */
public class UserProgress {
    private String mUserName;
    private int mChallengeID;
    private int mZeitklasse;
    private String mTimeStampBeantwortung;

    public UserProgress(String UserName, int ChallengeID, int Zeitklasse, String TimeStampBeantwortung) {
        this.mUserName = UserName;
        this.mChallengeID = ChallengeID;
        this.mZeitklasse = Zeitklasse;
        this.mTimeStampBeantwortung = TimeStampBeantwortung;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public int getmChallengeID() {
        return mChallengeID;
    }

    public void setmChallengeID(int mChallengeID) {
        this.mChallengeID = mChallengeID;
    }

    public int getmZeitklasse() {
        return mZeitklasse;
    }

    public void setmZeitklasse(int mZeitklasse) {
        this.mZeitklasse = mZeitklasse;
    }

    public String getmTimeStampBeantwortung() {
        return mTimeStampBeantwortung;
    }

    public void setmTimeStampBeantwortung(String mTimeStampBeantwortung) {
        this.mTimeStampBeantwortung = mTimeStampBeantwortung;
    }

    public void setDefaultTimeStamp(){
        setmTimeStampBeantwortung(Constants.DEFAULT_TIMESTAMP);
    }

    public void setCurrentTimeStamp(){
        setmTimeStampBeantwortung(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
    }

}


