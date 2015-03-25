# harkkatyo1
Käyttöliittymien harjoitustyö1: Elokuvalippujen varausjärjestelmä


Ohjeet, Käyttöliittymät 2015, Harjoitustyö:

Elokuvalippujen varausjärjestelmä
Harjoitustyön tavoitteena on toteuttaa elokuvalippujen varaukseen tarkoitettu sovellus graafisella käyttöliittymällä. 
Työ tehdään kurssin alussa muodostetuissa 3-4 hengen ryhmissä. Sovelluksen toteuttamiseen käytettävät ohjelmointikielet ja käyttöliittymätekniikat saa valita vapaasti.
Harjoitustyö on palautettava 22.3. mennessä.

Työn vaatimukset:
- Lipunmyyntijärjestelmä sisältää vähintään kaksi elokuvateatteria
- Elokuvateattereissa on vähintään kaksi erikokoista salia
- Käyttäjät kirjautuvat järjestelmään



== Asiakkaan ja ylläpitäjän näkymät:

o Ylläpitäjä
Elokuvien lisääminen, muokkaus ja poisto
Näytösten lisääminen, muokkaus ja poisto
Käyttäjien lisääminen (sovellusympäristöstä riippuen myös
rekisteröintilomake uusille käyttäjille)

o Asiakas
Omat varaukset
Varauksen muokkaus / poisto
Ohjelmiston selaaminen
Paikkojen varaaminen näytökseen
· Elokuvateatteri, sali, näytös ja paikat
· Graafinen näkymä (esim. salin pohjapiirros), josta käyttäjä voi valita paikat
· Muiden käyttäjien varaamat paikat eivät valittavissa
- Tietojen tallennus

o Tietokanta, tai Tiedot talteen tekstitiedostoihin (oma syntaksi, xml, ...)

Yksi tiedoston rivi vastaa tietokannan tietuetta, joten esimerkiksi varaus
voisi olla muotoa: teatteri;sali;näytös;paikka;käyttäjä

Valmiiden merkkauskielten (esim. xml) etuna olemassa olevat jäsentimet.
Tarkoitus on tietysti tehdä sovelluksesta mahdollisimman helppokäyttöinen ja selkeä, joten
muistakaa:
- käyttäjien ohjeistus 
- varmistusdialogit 
- toimintojen helppous 
(esim. elokuvan näytöksiä kerralla useammalle viikolle valittuun aikaan, varauslistasta suora siirtymä salinäkymään, jne.)
