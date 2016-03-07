package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

import android.app.Activity;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgress;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Luisa Leifer
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Activity mActivity;

    public ApplicationLogic(Data data, Gui gui, Activity activity) {
        mData = data;
        mGui = gui;
        mActivity = activity;
        initialUpdateGui();
    }

    private void initialUpdateGui() {

    }

    public void onButtonSaveNewUserClicked() throws IdNotFoundException {
        String givenUser;
        givenUser = mGui.getmNameOfUser().getText().toString();

        User newUser = new User();
        newUser.setCreateUser(givenUser);

        if (givenUser.isEmpty()){
            // Toast information --> no input
            Toast.makeText(mData.getActivity(), "Bitte einen Namen eingeben!", Toast.LENGTH_LONG).show();
        }
        else {
            if (givenUser.matches("[a-zA-Z]++")) {
                // save new User and check if not exists
                UserCollection uc = mData.getmAllUsers();

                if(uc.doesUserExist(newUser) == false) {
                    // Toast accepted
                    Toast.makeText(mData.getActivity(), "Username wurde akzeptiert!", Toast.LENGTH_LONG).show();

                    mData.getmAllUsers().addUser(newUser);

                    // Export all users + new user to users.csv (create new csv file)
                    UserDatabase.writeAllUsers(mActivity, uc);

                    // create UserProgress File for User
                    ChallengeCollection allChallenges = ChallengeDatabase.getAllChallenges();

                    UserProgressCollection userProgressCollection = new UserProgressCollection();

                    for(int i = 0; i < allChallenges.getSize(); i++) {
                        UserProgress userProgress = new UserProgress(givenUser, allChallenges.getChallenge(i).getmID(), 1, Constants.DEFAULT_TIMESTAMP);
                        userProgressCollection.addUserProgress(userProgress);
                    }
                    UserProgressDatabase.writeSpecificUserProgresses(userProgressCollection, givenUser, mActivity);

                    // Navigation to ChooseFile
                    mData.setmCurrentUser(mData.getmAllUsers().getUser(givenUser));
                    Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getmGivenUser());
                }
                else {
                    // Toast rejekted --> username already exists
                    Toast.makeText(mData.getActivity(), "Username bereits vorhanden!", Toast.LENGTH_LONG).show();
                }

            } else {
                // Toast rejekted --> no special signs, no mutated vowels, no numbers
                Toast.makeText(mData.getActivity(), "Der Username darf keine Leerzeichen, Umlaute, Sonderzeichen und Ziffern enthalten!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onButtonAbortNewUserClicked(){
        // Navigation to StartMenu
        Navigation.startActivityStartMenu(mData.getActivity());
    }
}
