package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.text.SimpleDateFormat;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;

/**
 * Created by Daniel on 22.02.2016.
 * Responsibility: Daniel zur Linden
 */
public class UserFortschritt {
    private int mUserID;
    private int mChallengeID;
    private int mZeitklasse;
    private String mTimeStampBeantwortung;

    public UserFortschritt(int mUserID, int mChallengeID, int mZeitklasse, String mTimeStampBeantwortung) {
        this.mUserID = mUserID;
        this.mChallengeID = mChallengeID;
        this.mZeitklasse = mZeitklasse;
        this.mTimeStampBeantwortung = mTimeStampBeantwortung;
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


