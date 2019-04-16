# introduction-to-java-2
## Probleme:

1. Se da o interfata CalculateService cu o metoda calculate() care intoarce un tip generic, subclasa a clasei Number
Interfata CalculateService va trebui sa aiba trei implementari: una care va calcula suma, una care va calcula media, una care va numara duplicatele
Se va crea un package exceptions care va contine toate exceptiile declarate
Se vor face validari si se vor arunca exceptii pe cazurile negative :

o    Pentru toate implementarile : lista primita ca input sa nu fie goala si sa nu fie null
o    Pentru implementarea calculului sumei : suma sa nu depaseasca valoarea Integer.MAX_INT
o    Pentru implementarea calculului mediei : lista primita sa nu contina numere negative
o    Pentru implementarea numararii duplicatelor : lista sa contina si elemente unice

**Se vor crea teste unitare pentru fiecare din cele 3 implementari



2. Se va implementa un HashMap fara a folosi colectiile din Java.
Pentru functia de hash care repartizeaza perechea cheie-valoare in HashMap puteti folosi functia modulo. Index-ul bucket-ului in care se va stoca perechea va fi dat de rezultatul operatiei :
hashCode_cheie % numar_bucketuri
HashMap-ul va avea doi parametri generici corespunzatori tipurilor cheii si valorii stocate de acesta
Cheia si valoarea vor fi stocate intr-un obiect asemanator cu obiectul Map.Entry
Se vor implementa urmatoarele metode :

o    put(key, value)
o    get(key)
o    remove(key)
o    containsKey(key)
o    containsValue(value)
o    entrySet()

**Se va crea un package exceptions care sa contina toate exceptiile declarate. Se vor arunca exceptii in cazuri exceptionale (ex. parametrul key este null etc.)
Se vor crea teste unitare pentru toate metodele create care sa acopere cat mai multe cazuri (favorabile si nefavorabile) - JUnit
