package entity;

import javax.persistence.*;
import java.sql.Date;


    @MappedSuperclass
    public class MainEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected long id;
        @Column
        protected Date dataDodania;
        @Column
        protected Integer idDodajacego;


        public MainEntity () {

        }

        public MainEntity(Date dataDodania, Integer idDodajacego) {
            this.dataDodania = dataDodania;
            this.idDodajacego = idDodajacego;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Date getDataDodania() {
            return dataDodania;
        }

        public void setDataDodania(Date dataDodania) {
            this.dataDodania = dataDodania;
        }

        public Integer getIdDodajacego() {
            return idDodajacego;
        }

        public void setIdDodajacego(Integer idDodajacego) {
            this.idDodajacego = idDodajacego;
        }

    }
