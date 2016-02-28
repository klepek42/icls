package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;

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

    public Challenge getChallengeByKey (int key) throws IdNotFoundException{
        int i;
        Challenge foundChallenge;
        foundChallenge = new Challenge(-1, "","","","",-1,-1, new IndexCard(-1,""));
        for ( i = 0; i < mChallengeList.size(); i++)
        {
            if (mChallengeList.get(i).getmID() == key)
            {
                foundChallenge =  mChallengeList.get(i);
                break;
            }
        }
        if (foundChallenge.getmID() == -1){
            throw new IdNotFoundException("ChallengeCollection::getChallengeByKey: Ungültiger Wert für Key: " + key);
        }

        return foundChallenge;
    }

    public void addChallenge(Challenge challenge){
        mChallengeList.add(challenge);
    }

    public int getSize(){
        return mChallengeList.size();
    }
}
