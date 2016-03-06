package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;

/**
 * Responsibility Jonas Krabs
 */
public class ChallengeCollection implements Serializable{

    private final ArrayList<Challenge> mChallengeList;

    public ChallengeCollection() {
        //noinspection Convert2Diamond
        mChallengeList = new ArrayList<Challenge>();
    }

    //get a challenge from a specific position of the collection
    //the id specifies the position of the challenge in the collection
    public Challenge getChallenge (int id){
        return mChallengeList.get(id);

    }

    //get a specific challenge in the collection
    //the key specifies the challenge by representing a challengeId that is saved in the csv
    //the method runs through the collection searching for a challenge whose id fits to the key
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
            //if there was no challenge found whose id fits to the key the method throws an exception
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
