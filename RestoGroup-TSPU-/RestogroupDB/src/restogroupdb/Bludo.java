/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restogroupdb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "bludo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bludo.findAll", query = "SELECT b FROM Bludo b"),
    @NamedQuery(name = "Bludo.findByIdBludo", query = "SELECT b FROM Bludo b WHERE b.idBludo = :idBludo"),
    @NamedQuery(name = "Bludo.findByStoimost", query = "SELECT b FROM Bludo b WHERE b.stoimost = :stoimost"),
    @NamedQuery(name = "Bludo.findByVremyaPrigotovleniya", query = "SELECT b FROM Bludo b WHERE b.vremyaPrigotovleniya = :vremyaPrigotovleniya"),
    @NamedQuery(name = "Bludo.findByNaimenovanieBluda", query = "SELECT b FROM Bludo b WHERE b.naimenovanieBluda = :naimenovanieBluda")})
public class Bludo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBludo")
    private Integer idBludo;
    @Column(name = "Stoimost")
    private String stoimost;
    @Column(name = "VremyaPrigotovleniya")
    private String vremyaPrigotovleniya;
    @Column(name = "NaimenovanieBluda")
    private String naimenovanieBluda;
    @JoinColumn(name = "idIngridient", referencedColumnName = "idIngridient")
    @ManyToOne
    private Ingridient idIngridient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBludo")
    private List<Zakaz> zakazList;

    public Bludo() {
    }

    public Bludo(Integer idBludo) {
        this.idBludo = idBludo;
    }

    public Integer getIdBludo() {
        return idBludo;
    }

    public void setIdBludo(Integer idBludo) {
        Integer oldIdBludo = this.idBludo;
        this.idBludo = idBludo;
        changeSupport.firePropertyChange("idBludo", oldIdBludo, idBludo);
    }

    public String getStoimost() {
        return stoimost;
    }

    public void setStoimost(String stoimost) {
        String oldStoimost = this.stoimost;
        this.stoimost = stoimost;
        changeSupport.firePropertyChange("stoimost", oldStoimost, stoimost);
    }

    public String getVremyaPrigotovleniya() {
        return vremyaPrigotovleniya;
    }

    public void setVremyaPrigotovleniya(String vremyaPrigotovleniya) {
        String oldVremyaPrigotovleniya = this.vremyaPrigotovleniya;
        this.vremyaPrigotovleniya = vremyaPrigotovleniya;
        changeSupport.firePropertyChange("vremyaPrigotovleniya", oldVremyaPrigotovleniya, vremyaPrigotovleniya);
    }

    public String getNaimenovanieBluda() {
        return naimenovanieBluda;
    }

    public void setNaimenovanieBluda(String naimenovanieBluda) {
        String oldNaimenovanieBluda = this.naimenovanieBluda;
        this.naimenovanieBluda = naimenovanieBluda;
        changeSupport.firePropertyChange("naimenovanieBluda", oldNaimenovanieBluda, naimenovanieBluda);
    }

    public Ingridient getIdIngridient() {
        return idIngridient;
    }

    public void setIdIngridient(Ingridient idIngridient) {
        Ingridient oldIdIngridient = this.idIngridient;
        this.idIngridient = idIngridient;
        changeSupport.firePropertyChange("idIngridient", oldIdIngridient, idIngridient);
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
        hash += (idBludo != null ? idBludo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bludo)) {
            return false;
        }
        Bludo other = (Bludo) object;
        if ((this.idBludo == null && other.idBludo != null) || (this.idBludo != null && !this.idBludo.equals(other.idBludo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restogroupdb.Bludo[ idBludo=" + idBludo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
