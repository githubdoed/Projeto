package br.com.example.miranda.projeto.services.pojos;

import java.io.Serializable;
import java.util.Date;

public class Route implements Serializable {

    private int id;
    private String shortName;
    private String longName;
    private Date lastModifiedDate;
    private Integer agencyId;

    public Route() {
    }

    public Route(int id, String shortName,String longName, Date lastModifiedDate, Integer agencyId) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
        this.lastModifiedDate = lastModifiedDate;
        this.agencyId = agencyId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }
}
