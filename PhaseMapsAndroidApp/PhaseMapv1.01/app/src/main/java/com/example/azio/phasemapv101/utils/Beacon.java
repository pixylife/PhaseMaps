package utils;

/**
 * Created by User on 5/21/2017.
 */

public class Beacon {
    private String idBeacon;
    private String subject;
    private String description;
    private double lat;
    private double lang;

    public Beacon(String idBeacon, String subject, String description, double lat, double lang) {
        this.idBeacon = idBeacon;
        this.subject = subject;
        this.description = description;
        this.lat = lat;
        this.lang = lang;
    }

    public String getIdBeacon() {
        return idBeacon;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public double getLat() {
        return lat;
    }

    public double getLang() {
        return lang;
    }
}
