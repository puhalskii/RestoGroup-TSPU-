/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restogroupdb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "zakaz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zakaz.findAll", query = "SELECT z FROM Zakaz z"),
    @NamedQuery(name = "Zakaz.findByIdZakaza", query = "SELECT z FROM Zakaz z WHERE z.idZakaza = :idZakaza"),
    @NamedQuery(name = "Zakaz.findByDataVremyaZakaza", query = "SELECT z FROM Zakaz z WHERE z.dataVremyaZakaza = :dataVremyaZakaza"),
    @NamedQuery(name = "Zakaz.findByStoimost", query = "SELECT z FROM Zakaz z WHERE z.stoimost = :stoimost"),
    @NamedQuery(name = "Zakaz.findByOtmetkaOVypolnenii", query = "SELECT z FROM Zakaz z WHERE z.otmetkaOVypolnenii = :otmetkaOVypolnenii")})
public class Zakaz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idZakaza")
    private Integer idZakaza;
    @Basic(optional = false)
    @Column(name = "DataVremyaZakaza")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVremyaZakaza;
    @Column(name = "Stoimost")
    private String stoimost;
    @Column(name = "OtmetkaOVypolnenii")
    private String otmetkaOVypolnenii;
    @JoinColumn(name = "idBludo", referencedColumnName = "idBludo")
    @ManyToOne(optional = false)
    private Bludo idBludo;
    @JoinColumn(name = "idSotrudnik", referencedColumnName = "idSotrudnik")
    @ManyToOne(optional = false)
    private Sotrudnik idSotrudnik;
    @JoinColumn(name = "idZakazchik", referencedColumnName = "idZakazchik")
    @ManyToOne(optional = false)
    private Zakazchik idZakazchik;

    public Zakaz() {
    }

    public Zakaz(Integer idZakaza) {
        this.idZakaza = idZakaza;
    }

    public Zakaz(Integer idZakaza, Date dataVremyaZakaza) {
        this.idZakaza = idZakaza;
        this.dataVremyaZakaza = dataVremyaZakaza;
    }

    public Integer getIdZakaza() {
        return idZakaza;
    }

    public void setIdZakaza(Integer idZakaza) {
        this.idZakaza = idZakaza;
    }

    public Date getDataVremyaZakaza() {
        return dataVremyaZakaza;
    }

    public void setDataVremyaZakaza(Date dataVremyaZakaza) {
        this.dataVremyaZakaza = dataVremyaZakaza;
    }

    public String getStoimost() {
        return stoimost;
    }

    public void setStoimost(String stoimost) {
        this.stoimost = stoimost;
    }

    public String getOtmetkaOVypolnenii() {
        return otmetkaOVypolnenii;
    }

    public void setOtmetkaOVypolnenii(String otmetkaOVypolnenii) {
        this.otmetkaOVypolnenii = otmetkaOVypolnenii;
    }

    public Bludo getIdBludo() {
        return idBludo;
    }

    public void setIdBludo(Bludo idBludo) {
        this.idBludo = idBludo;
    }

    public Sotrudnik getIdSotrudnik() {
        return idSotrudnik;
    }

    public void setIdSotrudnik(Sotrudnik idSotrudnik) {
        this.idSotrudnik = idSotrudnik;
    }

    public Zakazchik getIdZakazchik() {
        return idZakazchik;
    }

    public void setIdZakazchik(Zakazchik idZakazchik) {
        this.idZakazchik = idZakazchik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZakaza != null ? idZakaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zakaz)) {
            return false;
        }
        Zakaz other = (Zakaz) object;
        if ((this.idZakaza == null && other.idZakaza != null) || (this.idZakaza != null && !this.idZakaza.equals(other.idZakaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restogroupdb.Zakaz[ idZakaza=" + idZakaza + " ]";
    }
    
}
