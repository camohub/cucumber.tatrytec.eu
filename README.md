TestWatcher, ScreenShooter, onFail
====================
- TestWatcher - Selenium - sa nepoužíva. Slúži na zachytenie eventu failed() a finished(), 
  aby sa napr. urobil screenshot. O to sa aktuálne stará Selenide.
  Ukážka je v BaseSteps.java. Táto trieda prepisuje pôvodnú JUnit triedu TestWatcher.

- Screenshooter - Selenide - sa nepoužíva. Ukážka je implmentovaná v BaseSteps.java.
  Tiež je to implenentácia triedy JUnit TestWatcher.
  
- onFail - cucumber.@After hook - tu je implementácia screenshootera,
  cez metódu Selenide.screenshoot() v spojení s volaním scenario.isFailed().


Driver
====================
Selenide má vlastnú implementáciu drivera. 
Driver verzia sa dynamicky nastaví sama podľa nainštalovaného browsera.
Driver treba s Cucumberom zavrieť cez cucumber.@After


Konfigurácia
====================
Browser sa konfiguruje hlavne v BaseSteps.java.static
Knižnica com.typesafe.config načíta konfiguráciu zo súboru


Cucumber
====================
- Poradie
  - features - abecedne podľa adresárov a potom podľa súborov
  - scenarios - podľa poradia v kóde  
  - hooks - parameter order=3
  
- features
    - parametre - dobrá ukážka parametrov je Login.feature
- steps 
    - @Before @After, príklad s parametrami je LoginSteps 
- hooks 
    - @Before @After
    - @tagy sa dajú použiť aj v hookoch napr. @maximize
    - poradie sa nastaví parametrom order=4
- tags
    - @tagmi sa dá otagovať celá feature alebo len scenario
    - používajú sa v runneroch na filtrovanie scenárov
    - používajú sa aj v hookoch na priradenie akcií ku tagom


Jenkins
====================
Zmena oproti čistému Selenidu. 
Nespúsťajú sa kategórie naviazané na @Category, ale
spušťajú sa runnery naviazené na class runners.RunnerClassName
Bolo to treba upraviť v pom.xml