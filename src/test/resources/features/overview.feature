#language: de
@Smoke @Login @Security
Funktionalität: die Übersichtsseite enthält eine Liste von Konten

  Szenariogrundriss: Der Nutzer kann sich ausloggen
    Angenommen der User "<username>" mit dem Passwort "<passwort>" ist angemeldet
    Wenn er den Abmelden Knopf drückt
    Dann ist er abgemeldet

    Beispiele:
      | username | passwort |
      | hallo    | geheim   |
      | welt     | geheim   |


  Szenario: Der Nutzer sieht seine eigenen Konten
    Angenommen der User "tester2-2" mit dem Passwort "geheim" ist angemeldet
    Dann sieht er die folgenden Konten
      | Name      | Kontonummer | Waehrung | Betrag |
      | Girokonto | 100000001   | EUR      | 500.00 |
    Und die Anwendung wird geschlossen


 # Scenario: the user has accounts
 # Given the user "tester2-2" is logged in
 # Then the following accounts are shown
 # | Kontonummer | Waehrung | Betrag   |
 # | 21020002    | EUR      | 0.0      |
 # | 21020003    | EUR      | 0.0      |
 # | 21020001    | EUR      | 10000.00 |
 # And the application is closed
#
 # Scenario: the user can add an account
 # Given the user "tester2-2" is logged in
 # When he presses the button to add a USD account
 # Then a new account is shown
 # And it has a balance of "USD 0,00"
 # And the application is closed
