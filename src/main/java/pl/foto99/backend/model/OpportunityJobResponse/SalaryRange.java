
package pl.foto99.backend.model.OpportunityJobResponse;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SalaryRange {

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("per")
    @Expose
    private String per;
    @SerializedName("rangeFrom")
    @Expose
    private Integer rangeFrom;
    @SerializedName("rangeTo")
    @Expose
    private Integer rangeTo;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public Integer getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(Integer rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public Integer getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(Integer rangeTo) {
        this.rangeTo = rangeTo;
    }

}
