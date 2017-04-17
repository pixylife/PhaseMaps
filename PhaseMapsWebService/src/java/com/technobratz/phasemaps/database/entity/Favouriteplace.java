
package com.technobratz.phasemaps.database.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thushini Ranasinghe
 */
@Entity
@Table(name = "favouriteplace", catalog = "phaseMaps", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favouriteplace.findAll", query = "SELECT f FROM Favouriteplace f")
    , @NamedQuery(name = "Favouriteplace.findById", query = "SELECT f FROM Favouriteplace f WHERE f.id = :id")})
public class Favouriteplace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "Location_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Location locationid;
    @JoinColumn(name = "User_userName", referencedColumnName = "userName", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User useruserName;

    public Favouriteplace() {
    }

    public Favouriteplace(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocationid() {
        return locationid;
    }

    public void setLocationid(Location locationid) {
        this.locationid = locationid;
    }

    public User getUseruserName() {
        return useruserName;
    }

    public void setUseruserName(User useruserName) {
        this.useruserName = useruserName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favouriteplace)) {
            return false;
        }
        Favouriteplace other = (Favouriteplace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.technobratz.phasemaps.database.entity.Favouriteplace[ id=" + id + " ]";
    }
    
}
