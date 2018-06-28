package me.simbachain.healthspace.simba_android;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asset {

    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("personName")
    @Expose
    private String personName;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Asset(String location, String timestamp, String personName, List<Item> items) {
        this.location = location;
        this.timestamp = timestamp;
        this.personName = personName;
        this.items = items;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}