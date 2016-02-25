package fhdw.mfwx413.flyingdutchmen.icls.activities.FinalEndOfChallenges;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCard;
import fhdw.mfwx413.flyingdutchmen.icls.data.IndexCardDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.IdNotFoundException;

/**
 * Responsibility: Luisa Leifer
 */
public class Data {

    // static variables for bundle
    private static final String KEY_CHOSEN_USER = "K1";
    private static final String KEY_CHOSEN_FILE = "K2";

    private Activity mActivity;
    private User mChosenUser;
    private IndexCard mChosenFile;

    public Data(Activity activity, Bundle bundle) {
        mActivity = activity;
        //Intent intent;

        if(bundle == null) {
            //if bundle isn't filled, the data will be initialized by the extras of the intent
            //intent = mActivity.getIntent();
            mChosenUser = new User("Testuser", 5, 60, 1440, 10080, 43200, 259200);
            try {
                mChosenFile = IndexCardDatabase.getIndexCards(mActivity).getIndexCard(4);
            }
            catch (IdNotFoundException e){
                Log.e("ICLS-LOG", "FinalEndOfChallenges::Data: ", e);
            }
        }
        else{
            //restore Data if bundle is filled
            restoreDataFromBundle(bundle);
        }

    }

    //save data in bundle if activity stops
    public void saveDataFromBundle(Bundle bundle) {
        bundle.putSerializable(KEY_CHOSEN_USER, mChosenUser);
        bundle.putSerializable(KEY_CHOSEN_FILE, mChosenFile);
    }

    //restore data from given bundle
    public void restoreDataFromBundle(Bundle bundle) {
        mChosenUser = (User) bundle.getSerializable(KEY_CHOSEN_USER);
        mChosenFile = (IndexCard) bundle.getSerializable(KEY_CHOSEN_FILE);
    }

    public Activity getActivity() {
        return mActivity;
    }

    public User getmChosenUser() {return mChosenUser;}

    public IndexCard getmChosenFile() {return mChosenFile;}

}
