package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgress;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 20.02.2016
 * Updated by Edgar on 21.02.2016
 * Updated by Jonas on 26.02.2016
 * Updated by Jonas on 05.03.2016
 */

// application logic connects the data with the gui and defines the exact events after an user-interaction
public class ApplicationLogic{

    private Data mData;
    private Gui mGui;
    private Context context;
    private ArrayList<String> userNames = new ArrayList<>();
    private String mSelectedName;

    public ApplicationLogic(Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
        fillSpinner();
    }

    private void initialUpdateDataToGui() {
    }

    // calls a new activity to add a new user
    public void onButtonAddUserClicked() {
        Navigation.startActivityAddNewUser(mData.getActivity());
    }

    // calls the activity choose File and transmits the selected user from spinner as the current user
    public void onButtonConfirmUserClicked() throws IdNotFoundException {
        mData.setCurrentUser(mData.getAllUsers().getUser(mSelectedName));
        checkUserProgresses();
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getCurrentUser());
    }

    /**
     * No onStandardBackButtonClicked since this is the first thing the user sees if the app was started and there is no going back within the app.
     * The app closes if the back button is pressed.
     */

    /** Function not supported in this version of app
    public void onButtonEditUserClicked() throws IdNotFoundException {
        mData.setCurrentUser(mData.getAllUsers().getUser(mSelectedName));
        Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
    }
    */

    // fill the spinner with all user names that were collected in the data class
    private void fillSpinner() {

        for(int i = 0; i < mData.getAllUsers().getSize(); i++) {
            userNames.add(mData.getAllUsers().get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, userNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGui.getChooseUser().setAdapter(adapter);
    }

    // set selected User from Spinner
    public void onUserSelected(int position){
        Log.d("Selected User ", ""+userNames.get(position));
        mSelectedName = userNames.get(position);
    }

    //Jonas 05.03.2016
    //since the user can add or delete challenges directly in the challenge.csv the app has to check
    //if there was a change on the csv
    //if there was a change the userprogresses have to be updated
    public void checkUserProgresses(){
        ChallengeCollection allChallenges = ChallengeDatabase.getAllChallenges();
        UserProgressCollection userProgresses = UserProgressDatabase.getUserProgresses(context, mData.getCurrentUser().getName());
        boolean userProgressesHaveToBeUpdated = false;

        //check if there are new challenges in the challenge.csv
        for(int i = 0; i < allChallenges.getSize(); i++){
            Challenge challenge = allChallenges.getChallenge(i);
            boolean challengeFoundInUserProgresses = false;
            for (int j = 0; j < userProgresses.getSize(); j++){
                //if there is an entry for the challenge in the userprogresses everything is fine and the next challenge can be checked
                if(challenge.getmID() == userProgresses.getUserProgress(j).getmChallengeID()){
                    challengeFoundInUserProgresses = true;
                    break;
                }
            }
            //if there is no entry for the challenge in the userprogresses the challenge is new and a new userProgress has to be added to the list
            if (challengeFoundInUserProgresses == false){
                UserProgress newUserProgress = new UserProgress(mData.getCurrentUser().getName(), challenge.getmID(), 1, Constants.DEFAULT_TIMESTAMP);
                userProgresses.addUserProgress(newUserProgress);
                userProgressesHaveToBeUpdated = true;
            }
        }
        //if there were new challenges found and the progressCollection was updated the collection has to be saved in the csv
        if(userProgressesHaveToBeUpdated == true){
            UserProgressDatabase.writeSpecificUserProgresses(userProgresses, mData.getCurrentUser().getName(), context);
            Log.d("ICLS-INFO", "Neue Challenges wurden gefunden und die Userprogresses aktualisiert");
            userProgressesHaveToBeUpdated = false;
        }
        else{
            Log.d("ICLS-INFO", "Es wurden keine neuen Challenges gefunden.");
        }

        //check if there were challenges deleted in the challenge.csv
        for (int i = 0; i < userProgresses.getSize(); i++){
            UserProgress userProgress = userProgresses.getUserProgress(i);
            boolean challengeFromProgressFoundInAllChallenges = false;
            for (int j = 0; j < allChallenges.getSize(); j++){
                //if there is an entry for the challengeID of the progress in the challenge.csv everything is fine and the next progress can be checked
                if (userProgress.getmChallengeID() == allChallenges.getChallenge(j).getmID()){
                    challengeFromProgressFoundInAllChallenges = true;
                    break;
                }
            }
            //if there is no entry for the challenge of the progress in the challenge.csv this challenge was deleted and the progress has to be deleted to
            if (challengeFromProgressFoundInAllChallenges == false){
                userProgresses.removeUserProgress(i);
                i--;
                userProgressesHaveToBeUpdated = true;
            }
        }
        //if there progresses deleted and the progressCollection was updated the collection has to be saved in the csv
        if(userProgressesHaveToBeUpdated == true){
            UserProgressDatabase.writeSpecificUserProgresses(userProgresses, mData.getCurrentUser().getName(), context);
            Log.d("ICLS-INFO", "Es wurden Progresses gefunden, zu denen keine Challenges mehr existieren. Die Progresses wurden geloescht");
            userProgressesHaveToBeUpdated = false;
        }
        else{
            Log.d("ICLS-INFO", "Es wurden seit der letzten Anmeldung des Benutzers keine Challenges geloescht.");
        }
    }
}