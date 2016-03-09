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
@Table(name = "zakazchik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zakazchik.findAll", query = "SELECT z FROM Zakazchik z"),
    @NamedQuery(name = "Zakazchik.findByIdZakazchik", query = "SELECT z FROM Zakazchik z WHERE z.idZakazchik = :idZakazchik"),
    @NamedQuery(name = "Zakazchik.findByFIOZakazchik", query = "SELECT z FROM Zakazchik z WHERE z.fIOZakazchik = :fIOZakazchik"),
    @NamedQuery(name = "Zakazchik.findByTelefonZakazchika", query = "SELECT z FROM Zakazchik z WHERE z.telefonZakazchika = :telefonZakazchika"),
    @NamedQuery(name = "Zakazchik.findByAdresZakazchika", query = "SELECT z FROM Zakazchik z WHERE z.adresZakazchika = :adresZakazchika")})
public class Zakazchik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idZakazchik")
    private Integer idZakazchik;
    @Column(name = "FIOZakazchik")
    private String fIOZakazchik;
    @Basic(optional = false)
    @Column(name = "TelefonZakazchika")
    private String telefonZakazchika;
    @Basic(optional = false)
    @Column(name = "AdresZakazchika")
    private String adresZakazchika;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZakazchik")
    private List<Zakaz> zakazList;

    public Zakazchik() {
    }

    public Zakazchik(Integer idZakazchik) {
        this.idZakazchik = idZakazchik;
    }

    public Zakazchik(Integer idZakazchik, String telefonZakazchika, String adresZakazchika) {
        this.idZakazchik = idZakazchik;
        this.telefonZakazchika = telefonZakazchika;
        this.adresZakazchika = adresZakazchika;
    }

    public Integer getIdZakazchik() {
        return idZakazchik;
    }

    public void setIdZakazchik(Integer idZakazchik) {
        this.idZakazchik = idZakazchik;
    }

    public String getFIOZakazchik() {
        return fIOZakazchik;
    }

    public void setFIOZakazchik(String fIOZakazchik) {
        this.fIOZakazchik = fIOZakazchik;
    }

    public String getTelefonZakazchika() {
        return telefonZakazchika;
    }

    public void setTelefonZakazchika(String telefonZakazchika) {
        this.telefonZakazchika = telefonZakazchika;
    }

    public String getAdresZakazchika() {
        return adresZakazchika;
    }

    public void setAdresZakazchika(String adresZakazchika) {
        this.adresZakazchika = adresZakazchika;
    }

    @XmlTransient
    public List<Zakaz> getZakazList() {
        return zakazList;
    }

    public void setZakazList(List<Zakaz> zakazList) {
        this.zakazList = zakazList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZakazchik != null ? idZakazchik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zakazchik)) {
            return false;
        }
        Zakazchik other = (Zakazchik) object;
        if ((this.idZakazchik == null && other.idZakazchik != null) || (this.idZakazchik != null && !this.idZakazchik.equals(other.idZakazchik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restogroupdb.Zakazchik[ idZakazchik=" + idZakazchik + " ]";
    }
    
}
