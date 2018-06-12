# FitnessUrejanje

FitnessUrejanje je fitnes aplikacija za receptorje in trenerje. Program je ustvarila ekipa študentov iz [Mariborske Univerze](https://www.um.si) iz [Fakultete za Elektrotehniko, Računalništvo in Informatiko](https://feri.um.si). Ekipo sestavljajo [Cerar Timotej](https://github.com/timicerar), [Ribič Jože](https://github.com/r1b1c), [Škrinjar Gregor](https://github.com/gregaskrinjar) in [Vovk Timi](https://github.com/timiv1). 

>Program je povezan s [fitnes programom za člane fitnes studia](https://github.com/timicerar/FitnessClani). Programa uporabljata isto podatkovno bazo in sta namenjena, kot dopolnilo drug drugemu.

## Vsebina
* [Uporaba](#uporaba)
* [Funkcionalnosti](#Funkcionalnosti)
* [Vzpostavitev](#Vzpostavitev)
* [ER-Diagram](#ER-Diagram)
* [Avtorji](#avtorji)
* [Licenca](#licenca)

## Uporaba
Namen te aplikacije je komunikacija med trenerji, receptorji in uporabniki fitnes studia.

Aplikacija omogoča:
* Trenerjem, da kreirajo programe, ki jih lahko nato persionalizirajo. Omogočeno jim je dodajanje vaj in urejanje vseh podrobnosti v zvezi z njimi.
* Receptorjem, da dodajajo, odstranjujejo in spremnijajo člane fitnes studia (dostopajo do osnovnih CRUD metod).
* Članom fitnes studija dostop do programov (prijava na programe) in vaj, ki jih trenerji ustvarjajo ter njihove podrobnosti. Člani lahko tudi dodajajo meritve (teža, višina in obseg pasu), ki se prikažejo na grafu.

## Funkcionalnosti


## Vzpostavitev
Za vpostavitev aplikacije si je potrebno namestiti:
* Intellij IDEA Ultimate 2018.1.1. (ta verzija je bila uporabljena v času razvoja)
  * V Intelliju si potrebno naložiti vtičnik / plugin za "Lombok Plugin" (anotacije za getterje in setterje)
* Pri kloniranju je potrebno ustvariti Maven projekt.
* Potrebujete strežnik WildFly 12.0.0. Final v katerega je potrebno dodati:
  * JDBC modul za MySQL
     * Ime sheme za podatkovno bazo naj bo "praktikum_db" 
  * Uporabnike:
    * Administrativnega uporabnika (user)
    * Aplikacijska uporabnika (trener in receptor)
  * JMS modul (ActiveMQ)
    * Potrebno je dodati sporočilo vrsto (jms/queue/test) in temo (jms/topic/test)

#### Postopek kako klonirati projetk iz GitHuba v Intellij IDEA


#### Postopek kako dodati vtičnik za Lombok Plugin


## ER-Diagram
![er-diagram](https://user-images.githubusercontent.com/23579188/40772756-25bb6bc6-64c1-11e8-95f4-87c1d415194a.png)

## Avtorji
- [Cerar Timotej](https://github.com/timicerar), [Ribič Jože](https://authenteq.com), [Škrinjar Gregor](https://github.com/gregaskrinjar) and [Vovk Timi](https://github.com/timiv1).

## Licenca
```
   This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
    ```
