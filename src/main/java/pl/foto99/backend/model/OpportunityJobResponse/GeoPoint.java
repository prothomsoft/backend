
package pl.foto99.backend.model.OpportunityJobResponse;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class GeoPoint {

    @SerializedName("lat")
    @JsonIgnore
    private String lat;
    @SerializedName("lon")
    @JsonIgnore
    private String lon;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

}
