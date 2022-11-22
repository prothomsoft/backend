
package pl.foto99.backend.model.OpportunityJobResponse;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Certification {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("startDateTimestamp")
    @Expose
    private String startDateTimestamp;
    @SerializedName("endDateTimestamp")
    @Expose
    private String endDateTimestamp;
    @SerializedName("expirable")
    @Expose
    private Boolean expirable;
    @SerializedName("issuingOrganization")
    @Expose
    private String issuingOrganization;
    @SerializedName("fieldOfCertification")
    @Expose
    private String fieldOfCertification;
    @SerializedName("internal")
    @Expose
    private Boolean internal;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDateTimestamp() {
        return startDateTimestamp;
    }

    public void setStartDateTimestamp(String startDateTimestamp) {
        this.startDateTimestamp = startDateTimestamp;
    }

    public String getEndDateTimestamp() {
        return endDateTimestamp;
    }

    public void setEndDateTimestamp(String endDateTimestamp) {
        this.endDateTimestamp = endDateTimestamp;
    }

    public Boolean getExpirable() {
        return expirable;
    }

    public void setExpirable(Boolean expirable) {
        this.expirable = expirable;
    }

    public String getIssuingOrganization() {
        return issuingOrganization;
    }

    public void setIssuingOrganization(String issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }

    public String getFieldOfCertification() {
        return fieldOfCertification;
    }

    public void setFieldOfCertification(String fieldOfCertification) {
        this.fieldOfCertification = fieldOfCertification;
    }

    public Boolean getInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

}
