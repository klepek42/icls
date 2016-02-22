package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Max on 22/02/16
 */
public class UserCollection implements Serializable{

    private ArrayList<User> mUserList;

    public UserCollection() {
        mUserList = new ArrayList<User>();
    }

    public User getUser (int challengeId){
        return mUserList.get(challengeId);

    }

    public void addUser(User user){
        mUserList.add(user);
    }

}
