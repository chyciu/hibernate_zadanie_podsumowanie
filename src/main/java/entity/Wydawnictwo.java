package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "wydawnictwo")
public class Wydawnictwo extends MainEntity{

    @Column
    private String nazwaWydawnictwa;

    @OneToMany(mappedBy = "wydawnictwo")
    private Set<Ksiazka> ksiazki;

    public Wydawnictwo () {
    }

    public Wydawnictwo(Date dataDodania, Integer idDodajacego, String nazwaWydawnictwa) {
        super(dataDodania, idDodajacego);
        this.nazwaWydawnictwa = nazwaWydawnictwa;
    }

}
