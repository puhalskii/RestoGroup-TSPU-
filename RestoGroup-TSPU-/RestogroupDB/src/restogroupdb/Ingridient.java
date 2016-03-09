/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restogroupdb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "ingridient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingridient.findAll", query = "SELECT i FROM Ingridient i"),
    @NamedQuery(name = "Ingridient.findByIdIngridient", query = "SELECT i FROM Ingridient i WHERE i.idIngridient = :idIngridient"),
    @NamedQuery(name = "Ingridient.findByNaimenovanieIngridienta", query = "SELECT i FROM Ingridient i WHERE i.naimenovanieIngridienta = :naimenovanieIngridienta"),
    @NamedQuery(name = "Ingridient.findByDatavypuska", query = "SELECT i FROM Ingridient i WHERE i.datavypuska = :datavypuska"),
    @NamedQuery(name = "Ingridient.findBySrokGodnosti", query = "SELECT i FROM Ingridient i WHERE i.srokGodnosti = :srokGodnosti"),
    @NamedQuery(name = "Ingridient.findByObem", query = "SELECT i FROM Ingridient i WHERE i.obem = :obem"),
    @NamedQuery(name = "Ingridient.findByStoimost", query = "SELECT i FROM Ingridient i WHERE i.stoimost = :stoimost")})
public class Ingridient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIngridient")
    private Integer idIngridient;
    @Basic(optional = false)
    @Column(name = "NaimenovanieIngridienta")
    private String naimenovanieIngridienta;
    @Basic(optional = false)
    @Column(name = "Datavypuska")
    @Temporal(TemporalType.DATE)
    private Date datavypuska;
    @Basic(optional = false)
    @Column(name = "SrokGodnosti")
    private String srokGodnosti;
    @Column(name = "Obem")
    private String obem;
    @Basic(optional = false)
    @Column(name = "Stoimost")
    private String stoimost;
    @OneToMany(mappedBy = "idIngridient")
    private List<Bludo> bludoList;
    @JoinColumn(name = "idPostavshik", referencedColumnName = "idPostavshik")
    @ManyToOne(optional = false)
    private Postavshik idPostavshik;

    public Ingridient() {
    }

    public Ingridient(Integer idIngridient) {
        this.idIngridient = idIngridient;
    }

    public Ingridient(Integer idIngridient, String naimenovanieIngridienta, Date datavypuska, String srokGodnosti, String stoimost) {
        this.idIngridient = idIngridient;
        this.naimenovanieIngridienta = naimenovanieIngridienta;
        this.datavypuska = datavypuska;
        this.srokGodnosti = srokGodnosti;
        this.stoimost = stoimost;
    }

    public Integer getIdIngridient() {
        return idIngridient;
    }

    public void setIdIngridient(Integer idIngridient) {
        this.idIngridient = idIngridient;
    }

    public String getNaimenovanieIngridienta() {
        return naimenovanieIngridienta;
    }

    public void setNaimenovanieIngridienta(String naimenovanieIngridienta) {
        this.naimenovanieIngridienta = naimenovanieIngridienta;
    }

    public Date getDatavypuska() {
        return datavypuska;
    }

    public void setDatavypuska(Date datavypuska) {
        this.datavypuska = datavypuska;
    }

    public String getSrokGodnosti() {
        return srokGodnosti;
    }

    public void setSrokGodnosti(String srokGodnosti) {
        this.srokGodnosti = srokGodnosti;
    }

    public String getObem() {
        return obem;
    }

    public void setObem(String obem) {
        this.obem = obem;
    }

    public String getStoimost() {
        return stoimost;
    }

    public void setStoimost(String stoimost) {
        this.stoimost = stoimost;
    }

    @XmlTransient
    public List<Bludo> getBludoList() {
        return bludoList;
    }

    public void setBludoList(List<Bludo> bludoList) {
        this.bludoList = bludoList;
    }

    public Postavshik getIdPostavshik() {
        return idPostavshik;
    }

    public void setIdPostavshik(Postavshik idPostavshik) {
        this.idPostavshik = idPostavshik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngridient != null ? idIngridient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingridient)) {
            return false;
        }
        Ingridient other = (Ingridient) object;
        if ((this.idIngridient == null && other.idIngridient != null) || (this.idIngridient != null && !this.idIngridient.equals(other.idIngridient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restogroupdb.Ingridient[ idIngridient=" + idIngridient + " ]";
    }
    
}
