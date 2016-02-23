package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

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
        acceptUser = false;

        if (givenUser.matches("[a-zA-Z]")) {
            acceptUser = true;
            //Toast accepted
            //Navigation to ChooseFile
        }
        else {
            acceptUser = false;
            //Toast rejekted --> no special signs, no mutated vowels, no numbers
        }
        //Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonAbortNewUserClicked(){
        Navigation.startActivityStartMenu(mData.getActivity());
    }
}
