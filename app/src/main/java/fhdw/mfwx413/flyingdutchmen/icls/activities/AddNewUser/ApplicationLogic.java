package fhdw.mfwx413.flyingdutchmen.icls.activities.AddNewUser;

/**
 * Created by edgar on 17.02.2016.
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

    }

    public void onButtonAbortNewUserClicked(){

    }
}
