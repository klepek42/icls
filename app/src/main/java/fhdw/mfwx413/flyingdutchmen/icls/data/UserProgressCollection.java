package fhdw.mfwx413.flyingdutchmen.icls.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by H00052647 on 23.02.2016.
 */
public class UserProgressCollection implements Serializable{

        private ArrayList<UserProgress> mUserProgresses;


        public UserProgressCollection() {
            mUserProgresses = new ArrayList<UserProgress>();
        }

        public UserProgress getUserProgress(int Id){
            return mUserProgresses.get(Id);

        }

        public void addUserProgress(UserProgress userProgress){
            mUserProgresses.add(userProgress);
        }
    }


