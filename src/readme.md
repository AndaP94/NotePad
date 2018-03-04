# Das kleine Adressbuch

A) Notizen und Verfasser

Erstellen Sie eine Notiz-Klasse die Notizen aus einem Notizbuch repräsentiert. Diese Klasse soll folgende Informationen aufnehmen können: notiznummer (int), notiztext (String), erledigt (boolean). Außerdem soll zu jeder Notiz ein Verfasser gespeichert werden. Verfasser werden von einer separaten Klasse repräsentiert, die folgende Datenfelder haben soll: verfassernummer (int), vorname (String), nachname (String). Jede Notiz hat dabei genau einen Verfasser (wobei beim Verfasser keine Informationen über die für ihn gespeicherten Notizen vorgesehen sind).

Beide Klassen sollen jeweils einen Konstruktor bereitstellen, der über übergebene Parameter alle Datenfeldwerte setzt. Sie sollen außerdem einen zweiten parameterlosen Konstruktor definieren, der alle Datenfeldwerte auf sinnvolle Startwerte setzt.

Alle Datenfelder der beiden Klassen sind von außen nicht zugreifbar und sollen über sinnvolle Getter- und Settermethoden verwendbar sein. Insbesondere das Setzen sinnloser Datenfeldwerte soll über die Setter-Methoden verhindert werden.


B) Notizbuch

Erstellen Sie eine Klasse Notizbuch, die viele der oben genannten Notizen aufnehmen können soll. Die Klasse hat einen parameterlosen Konstruktor, der die Liste sinnvoll initialisiert.

Folgende Methoden sollen bereitstehen:
•	notizAufnehmen: Soll eine als Parameter übergebene Notiz in die Liste aufnehmen. Wenn sich bei der Aufnahme einer Notiz herausstellen sollte, dass bereits eine Notiz mit derselben Nummer in der Liste ist, dann soll die neue Notiz eine neue Nummer erhalten. Diese neue Nummer soll einfach um 1 höher sein, als die bisher höchste Notiznummer in der Liste. Für die Implementierung dieser Funktion sind die folgenden beiden privaten Hilfsmethoden zu verwenden.
•	private Hilfsmethode höchsteNotizummer: liefert die höchste Notiznummer im Notizbuch
•	private Hilfsmethode notizMitNummerVorhanden: liefert true, wenn eine Notiz mit der mitgegebenen Notiznummer (Parameter) vorhanden ist
•	gibNotizMitNummer: Soll die Notiz mit der angegebenen Notiznummer zurückliefern.
•	anzahlNotizen: Soll die Anzahl aller gespeicherten Notizen zurückliefern
•	anzahlNotizenVonVerfasserNr: Soll die Anzahl aller gespeicherten Notizen eines Verfassers (Nummer als Parameter) zurückliefern
•	gibNotizenVonVerfasser: Soll alle Notizen zurückliefern (in Form einer ArrayList<notiz>) die ein bestimmter Verfasser (der Verfasser wird als Objekt per Parameter übergeben) verfasst hat.
•	gibNotizenMitTextinhalt: Soll alle Notizen zurückliefern (in Form einer AraryList<notiz>), die einen bestimmen angegebenen Text (Parameter) in ihrem Notiztext enthalten.
•	notizÄndernMitNummer: Soll den Text einer Notiz mit einer gegebenen Nummer (Paramter) auf einen neuen Text (Parameter) ändern.
•	notizLoeschenAufPosition: Soll eine Notiz an der gegebenen Notizlistenposition löschen.
•	notizLoeschenMitNummer: Soll die Notiz mit der gegebenen Notiznummer (Parameter) löschen. Für das Löschen ist ein Iterator zu verwenden.
•	notizenLoeschenDerVerfasserNr: Soll alle Notizen einer bestimmten Verfassernummer (Parameter) löschen. Für das Löschen ist ein Iterator zu verwenden.

C Variante 1) Kommandozeilenanwendung

Schreiben Sie eine Kommandozeilenanwendung, die es dem Benutzer ermöglicht, sich über ein Kommandozeilenmenü einzuloggen (= Verfassername angeben) und dann im eingeloggten Zustand ein Notizbuch zu führen (= alle Funktionen aus B) als Menüpunkt bereitstellen).

C Variante 2) App-Klasse (weniger Punkte als C1, aber einfacher)

Zeigen Sie anhand einer kleinen ausführbaren Anwendungsklasse, wie Sie das neu programmierte Notizbuch anwenden können, d. h. Verfasser erstellen, Notiz erstellen, Notizbuch erstellen, Notiz aufnehmen und alle anderen Funktionalitäten aus B anwenden.
