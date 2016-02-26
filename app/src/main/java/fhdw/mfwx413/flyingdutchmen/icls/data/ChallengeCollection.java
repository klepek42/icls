package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Responsibility Jonas Krabs
 * This Class defines a Collection of Challenges and gives the opportunity to add
 * a challenge and to get a specific one
 */

// defines a list of challenges
public class ChallengeCollection implements Serializable{

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

    public int getSize(){
        return mChallengeList.size();
    }
}
