package org.cdcaims.models;

import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author khuramkhalid
 * @version 01/09/2016
 */
@Entity
public class CurrencyMaster {

    @Id
    private String currencyCode;
    private String currencyDescription;

    @OneToOne(targetEntity = StatusMaster.class)
    private StatusMaster status;

    protected CurrencyMaster() {}
    public CurrencyMaster(String currencyCode, String currencyDescription, StatusMaster status) {
        this.currencyCode = currencyCode;
        this.currencyDescription = currencyDescription;
        this.status = status;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyDescription() {
        return currencyDescription;
    }

    public void setCurrencyDescription(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }

    public StatusMaster getStatus() {
        return status;
    }

    public void setStatus(StatusMaster status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static CurrencyMaster fromString(String currencyStr) {
        return new Gson().fromJson(currencyStr, CurrencyMaster.class);
    }
}