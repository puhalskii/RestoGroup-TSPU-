/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restogroupdb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "postavshik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postavshik.findAll", query = "SELECT p FROM Postavshik p"),
    @NamedQuery(name = "Postavshik.findByIdPostavshik", query = "SELECT p FROM Postavshik p WHERE p.idPostavshik = :idPostavshik"),
    @NamedQuery(name = "Postavshik.findByImyaPostavshika", query = "SELECT p FROM Postavshik p WHERE p.imyaPostavshika = :imyaPostavshika"),
    @NamedQuery(name = "Postavshik.findByBuisnessID", query = "SELECT p FROM Postavshik p WHERE p.buisnessID = :buisnessID")})
public class Postavshik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPostavshik")
    private Integer idPostavshik;
    @Basic(optional = false)
    @Column(name = "ImyaPostavshika")
    private String imyaPostavshika;
    @Basic(optional = false)
    @Column(name = "BuisnessID")
    private int buisnessID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPostavshik")
    private List<Ingridient> ingridientList;

    public Postavshik() {
    }

    public Postavshik(Integer idPostavshik) {
        this.idPostavshik = idPostavshik;
    }

    public Postavshik(Integer idPostavshik, String imyaPostavshika, int buisnessID) {
        this.idPostavshik = idPostavshik;
        this.imyaPostavshika = imyaPostavshika;
        this.buisnessID = buisnessID;
    }

    public Integer getIdPostavshik() {
        return idPostavshik;
    }

    public void setIdPostavshik(Integer idPostavshik) {
        this.idPostavshik = idPostavshik;
    }

    public String getImyaPostavshika() {
        return imyaPostavshika;
    }

    public void setImyaPostavshika(String imyaPostavshika) {
        this.imyaPostavshika = imyaPostavshika;
    }

    public int getBuisnessID() {
        return buisnessID;
    }

    public void setBuisnessID(int buisnessID) {
        this.buisnessID = buisnessID;
    }

    @XmlTransient
    public List<Ingridient> getIngridientList() {
        return ingridientList;
    }

    public void setIngridientList(List<Ingridient> ingridientList) {
        this.ingridientList = ingridientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostavshik != null ? idPostavshik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postavshik)) {
            return false;
        }
        Postavshik other = (Postavshik) object;
        if ((this.idPostavshik == null && other.idPostavshik != null) || (this.idPostavshik != null && !this.idPostavshik.equals(other.idPostavshik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restogroupdb.Postavshik[ idPostavshik=" + idPostavshik + " ]";
    }
    
}
