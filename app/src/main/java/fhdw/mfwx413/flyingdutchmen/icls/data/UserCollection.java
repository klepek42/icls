package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;

/**
 * Created by Max on 22/02/16
 * Responsibility: Max Schumacher
 */
public class UserCollection implements Serializable{

    private ArrayList<User> mUserList;

    public UserCollection() {
        mUserList = new ArrayList<>();
    }

    // method to return an User identified by its Name out of an UserCollection
    public User getUser (String key) throws IdNotFoundException {
        int i;
        User foundUser;
        foundUser = new User("-1", 0,0,0,0,0,0);
        for ( i = 0; i < mUserList.size(); i++)
        {
            if (mUserList.get(i).getName().equals(key))
            {
                foundUser = mUserList.get(i);
            }
        }

        if(foundUser.getName().equals("-1")) {
            throw new IdNotFoundException("UserCollection::getUser: Ungültiger Key für User: " + key);
        }

        return foundUser;
    }

    // method to add a User to a UserCollection
    public void addUser(User user){
        mUserList.add(user);
    }

    // method that returns the size of a UserCollection
    public int getSize() {
        return mUserList.size();
    }

    // method that returns an User out of an UserCollection
    public User get(int index){
        return mUserList.get(index);
    }

    // method to check whether a user exists or not
    public boolean doesUserExist (User user){
        int i;
        for ( i = 0; i < mUserList.size(); i++)
        {
            if (mUserList.get(i).getName().equals(user.getName()))
            {
                return true;
            }
        }
        return false;
    }
}