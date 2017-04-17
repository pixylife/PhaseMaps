
package com.technobratz.phasemaps.database.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thushini Ranasinghe
 */
@Entity
@Table(name = "location", catalog = "phaseMaps", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id")
    , @NamedQuery(name = "Location.findByLocationName", query = "SELECT l FROM Location l WHERE l.locationName = :locationName")
    , @NamedQuery(name = "Location.findByLocationLongitude", query = "SELECT l FROM Location l WHERE l.locationLongitude = :locationLongitude")
    , @NamedQuery(name = "Location.findByLocationLatitude", query = "SELECT l FROM Location l WHERE l.locationLatitude = :locationLatitude")
    , @NamedQuery(name = "Location.findByAddress", query = "SELECT l FROM Location l WHERE l.address = :address")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name = "locationName", length = 50)
    private String locationName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "locationLongitude", precision = 22)
    private Double locationLongitude;
    @Column(name = "locationLatitude", precision = 22)
    private Double locationLatitude;
    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid", fetch = FetchType.LAZY)
    private List<Favouriteplace> favouriteplaceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid", fetch = FetchType.LAZY)
    private List<Travellog> travellogList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid", fetch = FetchType.LAZY)
    private List<Reveiw> reveiwList;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public Double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Favouriteplace> getFavouriteplaceList() {
        return favouriteplaceList;
    }

    public void setFavouriteplaceList(List<Favouriteplace> favouriteplaceList) {
        this.favouriteplaceList = favouriteplaceList;
    }

    @XmlTransient
    public List<Travellog> getTravellogList() {
        return travellogList;
    }

    public void setTravellogList(List<Travellog> travellogList) {
        this.travellogList = travellogList;
    }

    @XmlTransient
    public List<Reveiw> getReveiwList() {
        return reveiwList;
    }

    public void setReveiwList(List<Reveiw> reveiwList) {
        this.reveiwList = reveiwList;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.technobratz.phasemaps.database.entity.Location[ id=" + id + " ]";
    }
    
}
