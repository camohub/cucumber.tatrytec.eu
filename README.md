TestWatcher
====================
// Neplatí ak sa použije SELENIDE miesto SELENIA
Prepisuje pôvodnú JUnit triedu TestWatcher, aby bolo možné
zachytiť udalosť failed() a finished()


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