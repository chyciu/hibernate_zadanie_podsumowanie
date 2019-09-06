package entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "klient")
public class Klient extends MainEntity {

    @Column
    private String imie;
    @Column
    private String nazwisko;

    @Embedded
    private Adres adres;

    @ManyToMany(mappedBy = "klienci")
    private Set<Ksiazka> ksiazki;

    public Klient () {
    }

    public Klient(Date dataDodania, Integer idDodajacego, String imie, String nazwisko, Adres adres) {
        super(dataDodania, idDodajacego);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
    }

    public Set<Ksiazka> getKsiazki() {
        if (ksiazki == null) {
            ksiazki = new HashSet<>();
        }
        return ksiazki;
    }

    public void addKsiazki (Ksiazka ksiazka) {
        getKsiazki().add(ksiazka);
        ksiazka.addKlient(this);
    }
}
