Readme - Befuellung challenges.csv und index.csv

Im nachfolgenden Readme wird beschrieben, wie die beiden Dateien challenges.csv und index.csv befuellt werden muessen.
Das ist besonders fuer den Benutzer des Karteikarten-Lernsystems von Bedeutung.
Sie bieten naemlich die Moeglichkeit, neue Challenges und neue Karteien hinzuzufuegen, zu bearbeiten und zu loeschen.
Aus diesem Grund hat der Benutzer auch direkten Zugriff auf diese beiden Dateien.
Damit bilden sie die einzige Ausnahme, denn auf andere Dateien ist der Zugriff von Außen nicht erlaubt.
Wie die Endung bereits vermuten laesst, handelt es sich um zwei CSV-Dateien.

Sie stellen die Schnittstelle der einzelnen Fragen und Karteien zur Applikation dar.
Aus diesem Grund muss sie auch klar definiert werden.
Andernfalls ist eine korrekte Nutzung des Karteikarten-Lernsystems und ein reibungsloser Ablauf derselbigen nicht moeglich.
Werden die nachfolgend definierten Vorgaben nicht eingehalten, kann das dazu fuehren, dass der Inhalt der einzelnen Karteien und Challenges nicht korrekt geladen wird.
Im schlimmsten Fall kann das sogar zu einem Abbruch des Programms fuehren, oder es wird einfach nicht gestartet.
Also wird fuer beide Dateien die Struktur der einzelnen Zeile fest vorgegeben, um eben jene Fehler zu vermeiden.


__________________________________________________________________________________________________________________________________
challenges.csv

Eine Challenge stellt in diesem Programm eine Frage dar, die der gerade ausgewaehlte Benutzer beantworten muss.
Sie muss dabei immer einen eigenen Typ besitzen. Ueber diesen Typ wird gesteuert, um was fuer eine Art von Challenge es sich handelt.
Außerdem entscheidet diese ID, was fuer ein Layout fuer die Frage in der Applikation selbst gestartet werden muss.
In der Applikation wird zwischen folgenden Typen unterschieden: ChallengeFreeAnswer, ChallengeImagineAnswer und ChallengeMultipleChoice.

ChallengeFreeAnswer bezeichnet Challenges, bei denen eine Frage gestellt wird, die in einem Freitext beantwortet werden muss.
Es wird hierbei zwischen zwei weiteren Moeglichkeiten unterschieden.
Entweder muss der Freitext genau einer richtigen Antwort entsprechen, oder es gibt eine Reihe an richtigen Antworten.
Dann muss der Freitext einer dieser Antworten entsprechen.
Um das richtige Layout in der Applikation zu starten wird aber dennoch bei beiden die selbe Nummer "1", als Fragetyp-Layout-ID zugeordnet.

Bei der ChallengeImagineAnswer wird eine Frage gestellt, die dann im Kopf beantwortet werden muss.
Nach der geistigen Beantwortung der Frage und Weiterklicken wird dann die wirklich korrekte Antwort angezeigt.
Dann muss ehrlich entschieden werden, ob man richtig lag oder nicht.
Das Layout des Fragetyps hat hier die Nummer "2".

Dem letzten Layout ist die ID "3" zugeordnet.
Hierbei handelt es sich um die ChallengeMultipleChoice.
Bei diesem Challenge Typ wird dem Benutzer eine Frage gestellt, die er dann beantworten muss, indem er aus einer Reihe von angezeigten Auswahlmoeglichkeiten auswaehlt.
Dabei koennen auch mehrere Antworten korrekt sein.

Was ebenfalls von Bedeutung ist, ist die Index Card Nummer, die der Challenge zugeordnet ist.
Ueber diese Index Card Nummer wird gesteuert, welche Kategorie eine Challenge hat.
Als Kategorie ist hiermit ein Fachgebiet gemeint, zu dem eine Frage gehoert, wie zum Beispiel Biologie und Mathematik.
Dazu aber mehr in dem spaeteren Abschnitt index.csv.

Anders als sich nun vermuten laesst sind in der Datei challenges.csv alle Fragen jeder Kategorie aufgezaehlt.
Es wird nicht fuer jedes Fachgebiet eine eigene CSV-Datei erstellt, sondern es erfolgt eine gemeinsame Sammlung in challenges.csv.
Diese Fragen stehen dann alle dem Programm zur Verfuegung.
Eine gesonderte Aufzeichnung je Kartei findet demnach nicht statt.

Um nun ein erfolgreiches Laden des Frageninhalts aus dem Programm in die Datei zu gewaehrleisten, muss folgendes Format fuer jede Zeile eingehalten werden:

"Fragen ID";"Frage";"Antwort1";"Antwort2";"Antwort3";"Nummer der korrekten Antwort";"Frage Typ Layout";"Index Card ID"

Die Trennung der einzelnen "Elemente" erfolgt immer mit Semikolons.
Daher muss hierbei unbedingt betont werden, dass die Antwortmoeglichkeiten und Fragen keine Semikolons beinhalten duerfen.
Selbstverstaendlich werden die Anfuehrungszeichen in der eigentlichen Datei weggelassen.
Die Einhaltung der Reihenfolge ist logischerweise essentiell und muss zwingend eingehalten werden.

Die "Fragen ID" wird immer einfach fortlaufend vergeben.
Es ist eine Ziffer, die einzigartig vergeben wird.
Die Moeglichkeit, dass zwei verschiedene Fragen die selbe ID besitzen, darf nicht gegeben sein.
Das waere fehlerhaft.
Stattdessen muss der User beim Anlegen neuer Challenges einfach beachten, was die hoechste zuletzt vergebene Challenge ID war.
Nun muss dieser Wert einfach mit eins addiert werden, um die ID der neuen Frage zu erhalten.

Im Feld "Frage" kann einfach der Fragentext angegeben werden.

In den drei nachfolgenden Spalten "Antwort1","Antwort2" und "Antwort3" koennen die Antworten angegeben werden.
Es muessen aber nicht zwangsweise drei Antwortmoeglichkeiten gegeben werden.
Das ist abhaengig vom oden beschriebenen Fragentyp.
Ist die Challenge vom Typ ChallengeFreeAnswer oder ChallengeImagineAnswer muessen nicht immer drei Antwortmoeglichkeiten mitgegeben werden.
Hier kann es auch sein, dass nur eine Antwort oder eine von zwei Antworten richtig ist.
Werden aber nur zwei oder gar nur eine Antwort mitgegeben, bleibt das verbleibende Feld einfach leer.
Auf das Semikolon darf dennoch nicht verzichtet werden. Zum Beispiel:

"Fragen ID";"Frage";"Antwort1";;;"Nummer der korrekten Antwort";"Frage Typ Layout";"Index Card ID"

Ist die Challenge vom Typ ChallengeMultipleChoice muessen hingegen immer drei Antwortmoeglichkeiten angegeben werden.
In diesem Layout und Fragentyp werden immer drei Antworten erwartet.

Fuer die Angabe im Feld "Nummer der korrekten Antwort" muss der Benutzer etwas nachdenken und rechnen.
Es sollte einem dafuer das Prinzip der Oktalnotation bei der Datei-Rechtevergabe bekannt sein.
Fuer die jenigen, die mit dieser Notation nicht vertraut sind, soll nun eine kurze Erklaerung folgen.
Diese ist direkt auf das Programm bezogen.

Den drei Feldern fuer die Antwortmoeglichkeiten sind drei verschiedene Werte zugewiesen.
Antwortmoeglichkeit 1 ist der Wert "1" zugeordnet, fuer Antwortmoeglichkeit 2 ist der Wert "2" bestimmt und die 3 Antwortmoeglichkeit hat den Wert "4".
Dann wird geschaut, welche Antwort bzw. Antworten richtig sind und die jeweiligen Zahlenwerte  werden addiert.
In dem Feld mit der korrekten Antwort wird nun diese Summe eingetragen.
Darueber kann dann in der Programmlogik genau errechnet werden, welche Antwort bzw. Antworten richtig sind.
Die Ziffernmoeglichkeiten, die sich dadurch ergeben sind die Zahlen 1 bis 7.
Die verschiedenen Zahlen haben folgende Bedeutung:
1: Antwort 1 ist korrekt, Antwort 2 ist falsch und Antwort 3 ist falsch, denn 1 + 0 + 0 = 1
2: Antwort 1 ist falsch, Antwort 2 ist korrekt und Antwort 3 ist falsch, denn 0 + 2 + 0 = 2
3: Antwort 1 ist korrekt, Antwort 2 ist korrekt und Antwort 3 ist falsch, denn 1 + 2 + 0 = 3
4: Antwort 1 ist falsch, Antwort 2 ist falsch und Antwort 3 ist korrekt, denn 0 + 0 + 4 = 4
5: Antwort 1 ist korrekt, Antwort 2 ist falsch und Antwort 3 ist korrekt, denn 1 + 0 + 4 = 5
6: Antwort 1 ist falsch, Antwort 2 ist korrekt und Antwort 3 ist korrekt, denn 0 + 2 + 4 = 6
7: Antwort 1 ist korrekt, Antwort 2 ist korrekt und Antwort 3 ist korrekt, denn 1 + 2 + 4 = 7

Auf diese Weise kann genau ueber den Zahlenwert gesteuert werden, welche Antwort bzw. Antworten richtig sind.
Um die Ermittlung der richtigen Antwort im Programm muss sich der User natuerlich nicht kuemmern.
Diese Aufgabe uebernimmt die Programmlogik.

Die Fragen und Antworten werden dem User in den verschiedenen Activities natuerlich angezeigt.
Der Inhalt dieser Datei ist also absolut relevant fuer die korrekte Anzeige der Fragen und Antworten in den Activities.

In den verbleibenden beiden Feldern "Frage Typ Layout" und "Index Card ID" werden die beiden oben beschriebenen Elemente passend eingefuegt.
Das Layout des Fragetyps muss sich der Benutzer fuer die einzutragende Frage selbst ueberlegen.
Natuerlich muss sie zu der Anzahl der angegebenen Antworten passen.
Ist beispielsweise in der Datei index.csv der Kartei Biologie die ID "2" zugeordnet, und es handelt sich bei der aktuellen Frage um eine Frage, die diesem Bereich zuzuordnen ist, wird in "Index Card ID" die Nummer "2" eingetragen.

Das sind die Vorgaben, die je Zeile in der Datei challenge.csv einghalten werden muessen.
Nun wird noch die zweite fuer den User relevante Datei index.csv behandelt werden.


__________________________________________________________________________________________________________________________________
index.csv

In dieser Datei befinden sich alle Karteien, die im Programm zur Verfuegung stehen.
Eine Zeile stellt dabei eine Kartei also eine Index Card dar.
Die Datei kann beliebig mit weiteren Zeilen erweitert werden.
Es koennen Zeilen hinzugefuegt, veraendert und geloescht werden.

Eine Kartei stellt sozusagen ein Themengebiet dar, dass mehrere Challenges unter sich haben kann.
Denn eine Challenge, unabhaengig von ihrem Layout Typ, ist einer solchen Kartei zugeordnet.
Es ist also einfach eine Art Ueberschrift fuer eine Sammlung von mehreren Challenges, die einem gleichen Fachgebiet zugehoerig sind.
Es kann natuerlich auch sein, dass nur eine Challenge einer Index-Card zugeordnet ist.
Beispielhaft koennten hier die Fachgebiete Sport, Biologie und Mathematik angefuehrt werden.
Jede dieser Fachrichtungen bzw. Index Card besaeße eine Nummer ueber die sie eindeutig zu identifizieren waere.

Die Zuordnung einer Challenge zu einer Karteikarte erfolgt, wie oben beschrieben, in der Datei challenge.csv.
Dafuer steht ja dort das Feld "Index Card ID" zur Verfuegung.
In diesem Feld wird eben jene eindeutige Nummer eingetragen, die eine Karteikarte identifiziert.

Nun soll sich angschaut werden, wie der strukturierte Aufbau der Datei index.csv aussieht.
Index Cards muessen in folgendem Format in der Datei hinterlegt und gespeichert werden:

"Index Card ID";"Index Card Name"

Auch hier gilt es gleiche wie zuvor, dass die Trennung der beiden Elemente ueber ein Semikolon erfolgt und deshalb auch im Namen der Karteikarte kein Semikolon verwendet werden darf.
Ebenso werden auch hier die Anfuehrungszeichen bei Angabe der ID und des Namens weggelassen.

Wie man sieht ist der Inhalt einer Zeile vergleichsweise klein, denn er enthaelt nur die ID und den Namen der Karteikarte.
Er ist aber nicht minder wichtig, weshalb sich auch hier strikt an das vorgegebene Format gehalten werden muss.

Das Feld "Index Card ID" beinhaltet die eindeutige ID der Karteikarte.
Aufgrund der Tatsache, dass sie einmalig sein soll, wird eine Nummer nur einmal vergeben.
Sie ist also einzigartig und wird dementsprechend bei der Anlage einer neuen Kartei fortlaufend nummeriert.
Genau wie bei der challenge.csv-Datei uebernimmt auch hier der User die Aufgabe zu kontrollieren, dass die richtige ID vergeben wird.

In dem Feld "Index Card Name" steht der Name der Index Card.
Auch er ist einzigartig bzw. das Anlegen von Karteikarten mit demselben Namen erscheint sehr unsinnig.
Dieser Name wird dem Benutzer angezeigt, wenn er zur Activity "ChooseFile" gelangt.
Dort hat der die Moeglichkeit eine aktuelle Karteikarte auszuwaehlen.
Anschließend koennen Aktionen wie das Starten der Fragen dieser Karteikarte oder das Anzeigen der entsprechenden Statisitk gestartet werden.


__________________________________________________________________________________________________________________________________
Haelt sich der Benutzer an diese Vorgaben und Vereinbarungen, steht dem Hinzufuegen neuer Challenges und Index Cards in das Karteikarten-Lernsystem nichts mehr im Wege.

Zuletzt sei nun nochmals erwaehnt, dass sowohl Challenges als auch Index Cards benutzeruebergreifend zur Verfuegung stehen.
Das heisst, dass jeder Benutzer Zugriff auf jede Index Card und jede Challenge besitzt.
Wuerde also Benutzer A eine neue Karteikarte "Chemie" anlegen und anschließend drei Challenges in der challenge.csv-Datei ergaenzen, so waere diese Ergaenzung auch fuer Benutzer B sichtbar.
Gleiches gilt natuerlich fuer andere Operationen wie Loeschen oder Veraendern von Zeilen in den beiden jeweiligen Dateien.