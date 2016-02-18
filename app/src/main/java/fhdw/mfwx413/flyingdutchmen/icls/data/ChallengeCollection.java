package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.util.ArrayList;

/**
 * Created by Krabs on 18.02.2016.
 * das ist eine testklasse... ich kann noch nicht absehen, ob wir sie wirklich brauchen
 * solange das einlesen aus den csv-Dateien noch nicht realisiert ist, ist sie aber auf jeden Fall
 * notwendig
 * Im Moment gehe ich aber stark davon aus, dass wir die Klasse brauchen werden
 */
public class ChallengeCollection {

    private ArrayList<Challenge> mChallengeList;


    public ChallengeCollection() {
        mChallengeList = new ArrayList<Challenge>();
    }

    public Challenge getChallenge (int challengeId){
        return mChallengeList.get(challengeId);

    }

    public void addChallenge(Challenge challenge){
        mChallengeList.add(challenge);
    }
}
