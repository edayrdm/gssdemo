package com.gss.demo.Entities;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "RateData")
public class RateData implements Serializable{

    @Id
    private String id;
    private String source;
    private String date;
    private String currency;
    private float purchasePrice;
    private float marketPrice;

    public RateData() {
    }

    public RateData(String source, float marketPrice, float purchasePrice, String currency, String date) {
        this.source = source;
        this.marketPrice = marketPrice;
        this.purchasePrice = purchasePrice;
        this.currency = currency;
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float marketPrice) {
        this.marketPrice = marketPrice;
    }
}




