package rozwiazanie;

import entity.*;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;

public class Rozwiazanie {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Autor autor1 = new Autor(Date.valueOf(LocalDate.now()), 1, "Robert", "Nowak");
        Autor autor2 = new Autor(Date.valueOf(LocalDate.now()), 1, "Jan", "Kowal");
        Autor autor3 = new Autor(Date.valueOf(LocalDate.now()), 1, "Magda", "Jankowska");

        Ksiazka ksiazka1 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookA");
        Ksiazka ksiazka2 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookB");
        Ksiazka ksiazka3 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookC");
        Ksiazka ksiazka4 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookD");
        Ksiazka ksiazka5 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookE");
        Ksiazka ksiazka6 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookF");
        Ksiazka ksiazka7 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookG");
        Ksiazka ksiazka8 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookH");
        Ksiazka ksiazka9 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookI");
        Ksiazka ksiazka10 = new Ksiazka(Date.valueOf(LocalDate.now()), 1, "BookJ");

        Wydawnictwo wydawnictwo1 = new Wydawnictwo(Date.valueOf(LocalDate.now()), 1, "Baza");
        Wydawnictwo wydawnictwo2 = new Wydawnictwo(Date.valueOf(LocalDate.now()), 1, "Omega");

        Adres adres1 = new Adres("Nowa", "2", "2", "98-123", "Sopot", "89876755");
        Adres adres2 = new Adres("Dolna", "3", "3", "98-234", "Gdynia", "7875655");
        Adres adres3 = new Adres("Górna", "5", "12", "98-133", "Sopot", "89345675");
        Adres adres4 = new Adres("Niska", "55", "4", "94-143", "Rumia", "98088805");
        Adres adres5 = new Adres("Wysoka", "65", "52", "68-323", "Reda", "78000055");

        Klient klient1 = new Klient(Date.valueOf(LocalDate.now()), 1, "Jan", "Nowakowski", adres1);
        Klient klient2 = new Klient(Date.valueOf(LocalDate.now()), 1, "Ola", "Janek", adres2);
        Klient klient3 = new Klient(Date.valueOf(LocalDate.now()), 1, "Kazik", "Hinc", adres3);
        Klient klient4 = new Klient(Date.valueOf(LocalDate.now()), 1, "Wacław", "Kaszuba", adres4);
        Klient klient5 = new Klient(Date.valueOf(LocalDate.now()), 1, "Ela", "Gorny", adres5);

        ksiazka1.setWydawnictwo(wydawnictwo1);
        ksiazka2.setWydawnictwo(wydawnictwo1);
        ksiazka3.setWydawnictwo(wydawnictwo1);
        ksiazka4.setWydawnictwo(wydawnictwo1);
        ksiazka5.setWydawnictwo(wydawnictwo2);
        ksiazka6.setWydawnictwo(wydawnictwo2);
        ksiazka7.setWydawnictwo(wydawnictwo2);
        ksiazka8.setWydawnictwo(wydawnictwo1);
        ksiazka9.setWydawnictwo(wydawnictwo2);
        ksiazka10.setWydawnictwo(wydawnictwo2);

        ksiazka1.addAutor(autor1);
        ksiazka2.addAutor(autor2);
        ksiazka3.addAutor(autor2);
        ksiazka4.addAutor(autor3);
        ksiazka5.addAutor(autor2);
        ksiazka6.addAutor(autor2);
        ksiazka7.addAutor(autor3);
        ksiazka8.addAutor(autor1);
        ksiazka9.addAutor(autor1);
        ksiazka10.addAutor(autor2);

        klient1.addKsiazki(ksiazka1);
        klient1.addKsiazki(ksiazka3);

        klient2.addKsiazki(ksiazka5);
        klient2.addKsiazki(ksiazka6);

        klient3.addKsiazki(ksiazka8);
        klient3.addKsiazki(ksiazka1);

        klient4.addKsiazki(ksiazka4);
        klient4.addKsiazki(ksiazka8);

        klient5.addKsiazki(ksiazka10);
        klient5.addKsiazki(ksiazka3);

        session.persist(ksiazka1);
        session.persist(ksiazka2);
        session.persist(ksiazka3);
        session.persist(ksiazka4);
        session.persist(ksiazka5);
        session.persist(ksiazka6);
        session.persist(ksiazka7);
        session.persist(ksiazka8);
        session.persist(ksiazka9);
        session.persist(ksiazka10);

        session.flush();
        session.close();

    }
}


//      zadanie1
//        zmapuj strukturę danych w hibernate wykorzystując:
//        • mapowanie relacji
//        • użycie obiektów wbudowanych dla części zaznaczonej na zielono (użyj @Embeded/@Embedeble)
//        • użyj to powtarzających się kolumn @MappedSuperclass

//      zadanie2
//        Wypełnić bazę danymi:
//        • dodać 3 autorów
//        • dodać 10 książek
//        • dodać 2 wydawnictwa
//        • dodać 5 klientów
//        • dodać powiązania między danymi
