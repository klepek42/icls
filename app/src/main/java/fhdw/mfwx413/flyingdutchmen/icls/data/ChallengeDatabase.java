package fhdw.mfwx413.flyingdutchmen.icls.data;

/**
 * Created by Krabs on 18.02.2016.
 * das ist eine testklasse... ich kann noch nicht absehen, ob wir sie wirklich brauchen
 * solange das einlesen aus den csv-Dateien noch nicht realisiert ist, ist sie aber auf jeden Fall
 * notwendig
 * Im Moment gehe ich aber stark davon aus, dass wir die Klasse brauchen werden
 */
public class ChallengeDatabase {

    private static IndexCardCollection allIndexCards;

    public static ChallengeCollection getAllChallenges(){

        allIndexCards = IndexCardDatabase.getIndexCards();

        ChallengeCollection allChallenges;
        allChallenges = new ChallengeCollection();

        allChallenges.addChallenge(
                new Challenge(1, "Wie heißt der Torwart der deutschen Nationalmanschaft?", "Manuel Neuer", "", "", 1, 1, allIndexCards.getIndexCard(6))
        );

        allChallenges.addChallenge(
                new Challenge(2, "Wie heißt der höchste Berg Europas", "Mont Blanc", "", "", 1, 1, allIndexCards.getIndexCard(1))
        );

        allChallenges.addChallenge(
                new Challenge(3, "Welches Musikfestival fand bis 2014 jährlich am Nürburgring statt?", "Rock am Ring", "", "", 1, 1, allIndexCards.getIndexCard(4))
        );

        return allChallenges;
    }

}
