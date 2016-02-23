package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Luisa Leifer
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initialUpdateGui();
    }

    private void initialUpdateGui() {
        /*User user;
        int currentUser;

        currentUser = mData.getmCurrentUser();
        user = mData.getmUserCollection().getUser(currentUser);*/
    }

    public void onButtonSaveNewUserClicked(){
        String givenUser;
        Boolean acceptUser;

        givenUser = mGui.getmNameOfUser().getText().toString();

        if (givenUser.isEmpty()){
            //Toast --> no input
            Toast.makeText(mData.getActivity(), "Bitte einen Namen eingeben!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (givenUser.matches("[a-zA-Z]")) {
                //Toast accepted
                Toast.makeText(mData.getActivity(), "Username wurde akzeptiert!", Toast.LENGTH_SHORT).show();
                //Navigation to ChooseFile
                Navigation.startActivityChooseFile(mData.getActivity(), mData.getmGivenUser());
            } else {
                //Toast rejekted --> no special signs, no mutated vowels, no numbers
                Toast.makeText(mData.getActivity(), "Der Username darf keine Umlaute, Sonderzeichen und Ziffern enthalten!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onButtonAbortNewUserClicked(){
        Navigation.startActivityStartMenu(mData.getActivity());
    }
}
