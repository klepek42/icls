package fhdw.mfwx413.flyingdutchmen.icls.data;

/**
 * Responsibility: Jonas Krabs
 */
public class Challenge {

    private int mID;
    private String mQuestiontext;
    private String mAnswerOne;
    private String mAnswerTwo;
    private String mAnswerThree;
    private int mcorrectAnswer;
    private int mQuestionTypeLayout;
    private IndexCard mIndexCard;

    public Challenge(int mID, String mQuestiontext, String mAnswerOne, String mAnswerTwo, String mAnswerThree, int mcorrectAnswer, int mQuestionTypeLayout, IndexCard mIndexCard) {
        this.mID = mID;
        this.mQuestiontext = mQuestiontext;
        this.mAnswerOne = mAnswerOne;
        this.mAnswerTwo = mAnswerTwo;
        this.mAnswerThree = mAnswerThree;
        this.mcorrectAnswer = mcorrectAnswer;
        this.mQuestionTypeLayout = mQuestionTypeLayout;
        this.mIndexCard = mIndexCard;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmQuestiontext() {
        return mQuestiontext;
    }

    public void setmQuestiontext(String mQuestiontext) {
        this.mQuestiontext = mQuestiontext;
    }

    public String getmAnswerOne() {
        return mAnswerOne;
    }

    public void setmAnswerOne(String mAnswerOne) {
        this.mAnswerOne = mAnswerOne;
    }

    public String getmAnswerTwo() {
        return mAnswerTwo;
    }

    public void setmAnswerTwo(String mAnswerTwo) {
        this.mAnswerTwo = mAnswerTwo;
    }

    public String getmAnswerThree() {
        return mAnswerThree;
    }

    public void setmAnswerThree(String mAnswerThree) {
        this.mAnswerThree = mAnswerThree;
    }

    public int getMcorrectAnswer() {
        return mcorrectAnswer;
    }

    public void setMcorrectAnswer(int mcorrectAnswer) {
        this.mcorrectAnswer = mcorrectAnswer;
    }

    public int getmQuestionTypeLayout() {
        return mQuestionTypeLayout;
    }

    public void setmQuestionTypeLayout(int mQuestionTypeLayout) {
        this.mQuestionTypeLayout = mQuestionTypeLayout;
    }

    public IndexCard getmIndexCard() {
        return mIndexCard;
    }

    public void setmIndexCard(IndexCard mIndexCard) {
        this.mIndexCard = mIndexCard;
    }
}
