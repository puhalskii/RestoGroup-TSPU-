/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restogroupdb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "dolzhost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dolzhost.findAll", query = "SELECT d FROM Dolzhost d"),
    @NamedQuery(name = "Dolzhost.findByIdDolzhost", query = "SELECT d FROM Dolzhost d WHERE d.idDolzhost = :idDolzhost"),
    @NamedQuery(name = "Dolzhost.findByImyaDolzhnosti", query = "SELECT d FROM Dolzhost d WHERE d.imyaDolzhnosti = :imyaDolzhnosti"),
    @NamedQuery(name = "Dolzhost.findByOklad", query = "SELECT d FROM Dolzhost d WHERE d.oklad = :oklad"),
    @NamedQuery(name = "Dolzhost.findByTrebovaniya", query = "SELECT d FROM Dolzhost d WHERE d.trebovaniya = :trebovaniya"),
    @NamedQuery(name = "Dolzhost.findByObyazannosti", query = "SELECT d FROM Dolzhost d WHERE d.obyazannosti = :obyazannosti")})
public class Dolzhost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDolzhost")
    private Integer idDolzhost;
    @Column(name = "ImyaDolzhnosti")
    private String imyaDolzhnosti;
    @Column(name = "Oklad")
    private String oklad;
    @Column(name = "Trebovaniya")
    private String trebovaniya;
    @Column(name = "Obyazannosti")
    private String obyazannosti;
    @OneToMany(mappedBy = "idDolznost")
    private List<Sotrudnik> sotrudnikList;

    public Dolzhost() {
    }

    public Dolzhost(Integer idDolzhost) {
        this.idDolzhost = idDolzhost;
    }

    public Integer getIdDolzhost() {
        return idDolzhost;
    }

    public void setIdDolzhost(Integer idDolzhost) {
        this.idDolzhost = idDolzhost;
    }

    public String getImyaDolzhnosti() {
        return imyaDolzhnosti;
    }

    public void setImyaDolzhnosti(String imyaDolzhnosti) {
        this.imyaDolzhnosti = imyaDolzhnosti;
    }

    public String getOklad() {
        return oklad;
    }

    public void setOklad(String oklad) {
        this.oklad = oklad;
    }

    public String getTrebovaniya() {
        return trebovaniya;
    }

    public void setTrebovaniya(String trebovaniya) {
        this.trebovaniya = trebovaniya;
    }

    public String getObyazannosti() {
        return obyazannosti;
    }

    public void setObyazannosti(String obyazannosti) {
        this.obyazannosti = obyazannosti;
    }

    @XmlTransient
    public List<Sotrudnik> getSotrudnikList() {
        return sotrudnikList;
    }

    public void setSotrudnikList(List<Sotrudnik> sotrudnikList) {
        this.sotrudnikList = sotrudnikList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDolzhost != null ? idDolzhost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dolzhost)) {
            return false;
        }
        Dolzhost other = (Dolzhost) object;
        if ((this.idDolzhost == null && other.idDolzhost != null) || (this.idDolzhost != null && !this.idDolzhost.equals(other.idDolzhost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restogroupdb.Dolzhost[ idDolzhost=" + idDolzhost + " ]";
    }
    
}
