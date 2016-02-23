package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Max on 22/02/16
 */
public class UserCollection implements Serializable{

    private User mErrorUser;
    private ArrayList<User> mUserList;

    public UserCollection() {
        mUserList = new ArrayList<User>();
    }

    public User getUser (String key){
    int i;
    for ( i = 0; i < mUserList.size(); i++)
    {
        if (mUserList.get(i).getmName().equals(key))
        {
            return mUserList.get(i);
        }
    }
    //nur um den Fall abzufangen, dass der übergebene key nicht existiert
    //muss definitiv noch geändert werden!!!
    return mErrorUser;
    //Todo Max: Den Fall behandeln, was passiert, wenn ein Key übergeben wird, der nicht existiert

    }

    public void addUser(User user){
        mUserList.add(user);
    }

    public int getSize() {
        return mUserList.size();
    }

    public User get(int index){
        return mUserList.get(index);
    }


}
