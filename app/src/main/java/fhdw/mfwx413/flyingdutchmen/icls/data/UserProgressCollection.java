package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Responsibility: Daniel zur Linden
 */
public class UserProgressCollection implements Serializable {

    //create a UserProgressCollection by making a ArrayList with UserProgresses
    private final ArrayList<UserProgress> mUserProgresses;

    public UserProgressCollection() {
        mUserProgresses = new ArrayList<UserProgress>();
    }

    //get a specific UserProgress by its ID
    public UserProgress getUserProgress(int Id) {
        return mUserProgresses.get(Id);
    }

    //add a UserProgress to the ArrayList of UserProgresses
    public void addUserProgress(UserProgress userProgress) {
        mUserProgresses.add(userProgress);
    }

    //get the size of the ArrayList of UserProgresses
    public int getSize() {
        return mUserProgresses.size();
    }

    //remove a specific UserProgress in the ArrayList of UserProgresses by its ID
    public void removeUserProgress(int id) {
        mUserProgresses.remove(id);
    }
}


