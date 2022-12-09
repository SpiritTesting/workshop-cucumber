#language: de
@Ueberweisung @Regression
Funktionalität: die Überweisung soll korrekt durchgeführt werden.

  d.h. bei einer Überweisung wird der überwiesene Betrag von einem aufs andere Konto transferiert. Die
  Beträge der Konten werden angepasst.

  Szenariogrundriss: die Überweisung wird erfolgreich durchgeführt
    Angenommen der User "user-01" mit dem Passwort "geheim" ist angemeldet
    Und der User hat 2 Konten
    Wenn er sich den Kontostand des 1. Kontos als "kontostand1" merkt
    Und er sich den Kontostand des 2. Kontos als kontostand2" merkt
    Und der User navigiert auf die Kontodetails des 1. Kontos
    Und er als "Empfänger:" "<empfaenger>" eingibt
    Und er als "Kontonummer:" "<kontonummer>" eingibt
    Und er als "Betrag:" "<betrag>" eingibt
    Und er als "Verwendungszweck:" "<verwendungszweck>" eingibt
    Und er den Senden Knopf drückt
    Dann ist der verfügbare Betrag gleich dem kontostand abzueglich des betrags
    Und die Transaktionsliste enthält eine Transaktion von jetzt mit "<empfaenger>" und "<betrag">
    Und die Kontouebersicht zeigt fuer das Konto 100000001 den kontostand1 abzueglich des betrags
    Und die Kontouebersicht zeigt fuer das Konto 100000002 den kontostand2 zuzueglich des betrags

    Beispiele:
      | empfaenger | kontonummer | betrag | verwendungszweck |
      | Hannes     | 100000002   | 21,37  | Bier aus         |
      | Hannes     | 100000002   | 40,16  | Hallo Welt       |

Szenariogrundriss: die Überweisung schlägt fehl
  Angenommen der User "user-01" mit dem Passwort "geheim" ist angemeldet
  Und der User hat 2 Konten
  Und der User navigiert auf die Kontodetails des 1. Kontos
  Wenn er als "Empfänger:" "Hugo" eingibt
  * er als "Kontonummer:" "100000002" eingibt
  * er als "Betrag:" "<betrag>" eingibt
  * er als "Verwendungszweck:" "Testüberweisung" eingibt
  Dann ist der Senden Knopf inaktiv
  Dann es erscheint eine Fehlermeldung "<fehlermeldung>"

  Beispiele:
   | betrag   | fehlermeldung                                           |
   | 0,012    | Bitte geben Sie eine Zahl mit zwei Nachkommastellen ein |
   | -50,00   | NULL                                                    |
   | 5000,00  | Leider steht Ihnen nicht genug Guthaben zur Verfügung   |
