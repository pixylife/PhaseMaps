
package com.technobratz.phasemaps.database.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thushini Ranasinghe
 */
@Entity
@Table(name = "travellog", catalog = "phaseMaps", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travellog.findAll", query = "SELECT t FROM Travellog t")
    , @NamedQuery(name = "Travellog.findById", query = "SELECT t FROM Travellog t WHERE t.id = :id")
    , @NamedQuery(name = "Travellog.findByDateTime", query = "SELECT t FROM Travellog t WHERE t.dateTime = :dateTime")})
public class Travellog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "dateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @JoinColumn(name = "Location_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Location locationid;
    @JoinColumn(name = "User_userName", referencedColumnName = "userName", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User useruserName;

    public Travellog() {
    }

    public Travellog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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
        if (!(object instanceof Travellog)) {
            return false;
        }
        Travellog other = (Travellog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.technobratz.phasemaps.database.entity.Travellog[ id=" + id + " ]";
    }
    
}
