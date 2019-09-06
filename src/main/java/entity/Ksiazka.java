package entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ksiazka")
public class Ksiazka extends MainEntity {

    @Column
    private String tytul;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "ksiazka_klient")
    private Set<Klient> klienci;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ksiazka_autor")
    private Set<Autor> autorzy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idWydawnictwa")
    private Wydawnictwo wydawnictwo;


    public Ksiazka () {
    }

    public Ksiazka(Date dataDodania, Integer idDodajacego, String tytul) {
        super(dataDodania, idDodajacego);
        this.tytul = tytul;
    }

    public Set<Klient> getKlienci() {
        if (klienci == null) {
            klienci = new HashSet<>();
        }
        return klienci;
    }

    public void addKlient (Klient klient) {
        getKlienci().add(klient);
    }

    public void setWydawnictwo(Wydawnictwo wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public void addAutor (Autor autor) {
        if (autorzy == null) {
            autorzy = new HashSet<>();
        }
        autorzy.add(autor);
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
