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

    // method that is invoked if the safe button is clicked
    public void onButtonSaveNewUserClicked(){
        // save given user from the input field
        String givenUser;
        givenUser = mGui.getmNameOfUser().getText().toString();

        // create empty user and set given user
        User newUser = new User();
        newUser.setCreateUser(givenUser);

        // checks if the input field is empty
        if (givenUser.isEmpty()){
            // toast information --> no input
            Toast.makeText(mData.getActivity(), "Bitte einen Namen eingeben!", Toast.LENGTH_LONG).show();
        }
        else {
            // checks if just alphabetic character are given
            if (givenUser.matches("[a-zA-Z]++")) {
                // save new User and check if not exists
                UserCollection uc = mData.getmAllUsers();

                // checks if user not exist
                if(uc.doesUserExist(newUser) == false) {
                    // toast accepted
                    Toast.makeText(mData.getActivity(), "Username wurde akzeptiert!", Toast.LENGTH_LONG).show();

                    // add new user to all users
                    mData.getmAllUsers().addUser(newUser);

                    // export all users and new user to users.csv (create new csv file)
                    UserDatabase.writeAllUsers(mActivity, uc);

                    // create UserProgress file for user
                    ChallengeCollection allChallenges = ChallengeDatabase.getAllChallenges();
                    UserProgressCollection userProgressCollection = new UserProgressCollection();

                    // add all challenges to UserProgress
                    for(int i = 0; i < allChallenges.getSize(); i++) {
                        UserProgress userProgress = new UserProgress(givenUser, allChallenges.getChallenge(i).getmID(), 1, Constants.DEFAULT_TIMESTAMP);
                        userProgressCollection.addUserProgress(userProgress);
                    }
                    UserProgressDatabase.writeSpecificUserProgresses(userProgressCollection, givenUser, mActivity);

                    try {
                        // save the given user
                        mData.setmGivenUser(mData.getmAllUsers().getUser(givenUser));
                    }
                    // if something went wrong by updating the UserProgresses the StartMenu activity is called
                    catch(IdNotFoundException e){
                        // toast unexpected error
                        Toast.makeText(mData.getActivity(), "Unerwarteter Fehler", Toast.LENGTH_LONG).show();
                        // navigation to activity StartMenu
                        Navigation.startActivityStartMenu(mData.getActivity());
                    }
                    // navigation to activity ChooseFile and send the required data
                    Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getmGivenUser());
                }
                else {
                    // toast rejected if username already exists
                    Toast.makeText(mData.getActivity(), "Username bereits vorhanden!", Toast.LENGTH_LONG).show();
                }

            } else {
                // toast rejected --> no special signs, no mutated vowels, no numbers
                Toast.makeText(mData.getActivity(), "Der Username darf keine Leerzeichen, Umlaute, Sonderzeichen und Ziffern enthalten!", Toast.LENGTH_LONG).show();
            }
        }
    }

    // method that is invoked if the abort button is clicked
    public void onButtonAbortNewUserClicked(){
        // navigation to activity StartMenu
        Navigation.startActivityStartMenu(mData.getActivity());
    }
}
