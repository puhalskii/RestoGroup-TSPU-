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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sotrudnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sotrudnik.findAll", query = "SELECT s FROM Sotrudnik s"),
    @NamedQuery(name = "Sotrudnik.findByIdSotrudnik", query = "SELECT s FROM Sotrudnik s WHERE s.idSotrudnik = :idSotrudnik"),
    @NamedQuery(name = "Sotrudnik.findByFIOSotrudnika", query = "SELECT s FROM Sotrudnik s WHERE s.fIOSotrudnika = :fIOSotrudnika"),
    @NamedQuery(name = "Sotrudnik.findByVozrast", query = "SELECT s FROM Sotrudnik s WHERE s.vozrast = :vozrast"),
    @NamedQuery(name = "Sotrudnik.findByGender", query = "SELECT s FROM Sotrudnik s WHERE s.gender = :gender"),
    @NamedQuery(name = "Sotrudnik.findByAdress", query = "SELECT s FROM Sotrudnik s WHERE s.adress = :adress"),
    @NamedQuery(name = "Sotrudnik.findByTelefon", query = "SELECT s FROM Sotrudnik s WHERE s.telefon = :telefon"),
    @NamedQuery(name = "Sotrudnik.findByPassportNum", query = "SELECT s FROM Sotrudnik s WHERE s.passportNum = :passportNum")})
public class Sotrudnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSotrudnik")
    private Integer idSotrudnik;
    @Basic(optional = false)
    @Column(name = "FIOSotrudnika")
    private String fIOSotrudnika;
    @Basic(optional = false)
    @Column(name = "Vozrast")
    private String vozrast;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "Adress")
    private String adress;
    @Basic(optional = false)
    @Column(name = "Telefon")
    private String telefon;
    @Basic(optional = false)
    @Column(name = "PassportNum")
    private String passportNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSotrudnik")
    private List<Zakaz> zakazList;
    @JoinColumn(name = "idDolznost", referencedColumnName = "idDolzhost")
    @ManyToOne
    private Dolzhost idDolznost;

    public Sotrudnik() {
    }

    public Sotrudnik(Integer idSotrudnik) {
        this.idSotrudnik = idSotrudnik;
    }

    public Sotrudnik(Integer idSotrudnik, String fIOSotrudnika, String vozrast, String gender, String adress, String telefon, String passportNum) {
        this.idSotrudnik = idSotrudnik;
        this.fIOSotrudnika = fIOSotrudnika;
        this.vozrast = vozrast;
        this.gender = gender;
        this.adress = adress;
        this.telefon = telefon;
        this.passportNum = passportNum;
    }

    public Integer getIdSotrudnik() {
        return idSotrudnik;
    }

    public void setIdSotrudnik(Integer idSotrudnik) {
        this.idSotrudnik = idSotrudnik;
    }

    public String getFIOSotrudnika() {
        return fIOSotrudnika;
    }

    public void setFIOSotrudnika(String fIOSotrudnika) {
        this.fIOSotrudnika = fIOSotrudnika;
    }

    public String getVozrast() {
        return vozrast;
    }

    public void setVozrast(String vozrast) {
        this.vozrast = vozrast;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    @XmlTransient
    public List<Zakaz> getZakazList() {
        return zakazList;
    }

    public void setZakazList(List<Zakaz> zakazList) {
        this.zakazList = zakazList;
    }

    public Dolzhost getIdDolznost() {
        return idDolznost;
    }

    public void setIdDolznost(Dolzhost idDolznost) {
        this.idDolznost = idDolznost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSotrudnik != null ? idSotrudnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sotrudnik)) {
            return false;
        }
        Sotrudnik other = (Sotrudnik) object;
        if ((this.idSotrudnik == null && other.idSotrudnik != null) || (this.idSotrudnik != null && !this.idSotrudnik.equals(other.idSotrudnik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restogroupdb.Sotrudnik[ idSotrudnik=" + idSotrudnik + " ]";
    }
    
}
