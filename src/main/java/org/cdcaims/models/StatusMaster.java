package org.cdcaims.models;

import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author khuramkhalid
 * @version 01/09/2016
 */
@Entity
public class StatusMaster {

    @Id
    private String status;
    private String description;

    protected StatusMaster() {}
    public StatusMaster(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static StatusMaster fromString(String statusMasterStr) {
        return new Gson().fromJson(statusMasterStr, StatusMaster.class);
    }
}