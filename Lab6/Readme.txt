Java Lab 6
Am incercat sa folosesc JavaFX impreuna cu Scenebuilder.
-Interfata singura este terminata dar am avut probleme la adaugarea elementelor precum polygon.

Am utilizat un canvas de la Miscellaneous dar nu gaseam metode pentru a adauga un polygon, aveam metode pentru a putea desena *manual* doar cu mouse-ul.
ConfigPanel pastreaza informatiile pentru forma ce urmeaza sa fie desenata.
Controller pastreaza toate obiectele din interfata grafica precum butoane, textfields etc si in acesta am adaugat functionalitati la acestea.
ControlPanel este goala intrucat nu puteam sa desenez si ca urmare sa salvez/adaug
Controller pare sa inlocuiasca clasa MainFrame ca urmare MainFrame este goala.
CustomPolygon creeaza un polygon cu un anumit nr de laturi si cu o raza anume, la pozitia specificata.
Drawingpanel ar fi trebuit sa creeze un polygon folosind clasa CustomPolygon.