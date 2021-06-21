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
- Selenide má vlastnú implementáciu drivera (neplatí pri remote driver).
- Driver verzia sa dynamicky nastaví sama podľa nainštalovaného browsera.
- Driver treba s Cucumberom zavrieť cez cucumber.@After hook. 


Konfigurácia
====================
- Browser sa konfiguruje hlavne v BaseSteps.java.static 
- Knižnica com.typesafe.config načíta konfiguráciu zo súboru
  src/test/resources/application.conf


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
  
- opakovanie kroku pri chybe
    - príklad na opakovanie kroku je login


Javascript
====================
- Element na ktorom chcem vyvolať javascript akciu (napr. click()),
  síce môže byť viditeľný, ale ešte nemá naviazaný javascript event.
  Treba explicitne počkať cez sleep(xxx).
  

Jenkins
====================
- Zmena oproti čistému Selenidu. 
  Nespúsťajú sa kategórie naviazané na @Category, ale
  spušťajú sa runnery naviazené na class runners.RunnerClassName
  Bolo to treba upraviť v pom.xml

- Shell
    - v adresári shell sú scripty, ktoré spúšťajú testy 
      a úlohy pred a po testoch
    - run-test a run-failed-test sú vytvorené kôli spúšťaniu failed testov.
      Prvý regulérny MAVEN build totiž pri zlyhaní zafarbí celý výsledok 
      na červeno. Ak chceme aby bol výsledok zafarbený podľa výsledku 
      failed testov musí sa to urobiť cez dva shelly a prvý musí mať 
      nastevené ignorovanie chýb buildu.
      Toto nieje potrebné ak chceme červené testy prvého buildu vidieť ako 
      červené aj vo výsledku.
   

Deploy
=======================
V Githube je nastavený webhook na pipelinu v Jenkinse,
ktoré spúšťa script v /home/tatrytec/custom-scripts/deploy-cucumber.tatrytec.eu.sh