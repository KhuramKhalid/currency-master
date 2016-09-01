package org.cdcaims.models;

/**
 * @author khuramkhalid
 * @version 01/09/2016
 */
public class CurrencyMaster {

    private String currencyCode;
    private String currencyDescription;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}