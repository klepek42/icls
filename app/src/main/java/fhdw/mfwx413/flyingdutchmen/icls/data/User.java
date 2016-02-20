package fhdw.mfwx413.flyingdutchmen.icls.data;

/**
 * Responsibility: Max Schumacher
 */
public class User {

    // UserID (unique)
    protected int mID;
    // UserName (unique)
    private String mName;
    // intervals for period-classes 1-6 in minutes
    private int mPeriodClass1;
    private int mPeriodClass2;
    private int mPeriodClass3;
    private int mPeriodClass4;
    private int mPeriodClass5;
    private int mPeriodClass6;

    public String getmName() {
        return mName;
    }

    // Get intervals of period-classes for the SettingsMenu
    public int getmPeriodClass1() {
        return mPeriodClass1;
    }

    public int getmPeriodClass2() {
        return mPeriodClass2;
    }

    public int getmPeriodClass3() {
        return mPeriodClass3;
    }

    public int getmPeriodClass4() {
        return mPeriodClass4;
    }

    public int getmPeriodClass5() {
        return mPeriodClass5;
    }

    public int getmPeriodClass6() {
        return mPeriodClass6;
    }

    // For creation of new User with default settings for periodClasses (constructor)
    public void setCreateUser(String mName) {
        this.mID = getNextId();
        this.mName = mName;
        this.mPeriodClass1 = Constants.PERIOD_CLASS_1;
        this.mPeriodClass2 = Constants.PERIOD_CLASS_2;
        this.mPeriodClass3 = Constants.PERIOD_CLASS_3;
        this.mPeriodClass4 = Constants.PERIOD_CLASS_4;
        this.mPeriodClass5 = Constants.PERIOD_CLASS_5;
        this.mPeriodClass6 = Constants.PERIOD_CLASS_6;
    }

    // Reset to default period-class settings
    public void setDefaultPeriodClasses(String mName) {
        this.mName = mName;
        this.mPeriodClass1 = Constants.PERIOD_CLASS_1;
        this.mPeriodClass2 = Constants.PERIOD_CLASS_2;
        this.mPeriodClass3 = Constants.PERIOD_CLASS_3;
        this.mPeriodClass4 = Constants.PERIOD_CLASS_4;
        this.mPeriodClass5 = Constants.PERIOD_CLASS_5;
        this.mPeriodClass6 = Constants.PERIOD_CLASS_6;
    }

    // Update settings of users period-classes
    public void setPeriodClasses(int mPeriodClass1, int mPeriodClass2, int mPeriodClass3, int mPeriodClass4, int mPeriodClass5, int mPeriodClass6) {
        this.mPeriodClass1 = mPeriodClass1;
        this.mPeriodClass2 = mPeriodClass2;
        this.mPeriodClass3 = mPeriodClass3;
        this.mPeriodClass4 = mPeriodClass4;
        this.mPeriodClass5 = mPeriodClass5;
        this.mPeriodClass6 = mPeriodClass6;
    }

    // Update UserName
    public void setmName(String mName){
        this.mName = mName;
    }

    /** TO BE CHANGED **/
     // Create unique UserID's
    protected static int index = 0;
    protected static int getNextId() {
        return ++index;
    }

}
