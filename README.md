TestWatcher
====================
// Neplatí ak sa použije SELENIDE miesto SELENIA
Prepisuje pôvodnú JUnit triedu TestWatcher, aby bolo možné
zachytiť udalosť failed() a finished()


Driver
====================
Selenide má vlastnú implementáciu drivera. 
Driver verzia sa dynamicky nastaví sáma podľa nainštalovaného brovsera.
Driver treba s Cucumberom zavrieť cez cucumber.@After


Browser konfigurácia
====================


Konfigurácia
====================
Nastavenia browsera je v triede BasePage.static
Knižnica com.typesafe.config načíta konfiguráciu zo súboru


Cucumber
====================
- features
    - parametre - dobrá ukážka parametrov je Login.feature
- steps 
    - @Before @After, príklad s parametrami je LoginSteps 
- hooks 
    - @Before @After
