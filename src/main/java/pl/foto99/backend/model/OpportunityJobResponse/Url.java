
package pl.foto99.backend.model.OpportunityJobResponse;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Url {

    @SerializedName("applyURL")
    @Expose
    private String applyURL;
    @SerializedName("jobDescriptionURL")
    @Expose
    private String jobDescriptionURL;
    @SerializedName("referralURL")
    @Expose
    private String referralURL;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("isDefault")
    @Expose
    private Boolean isDefault;

    public String getApplyURL() {
        return applyURL;
    }

    public void setApplyURL(String applyURL) {
        this.applyURL = applyURL;
    }

    public String getJobDescriptionURL() {
        return jobDescriptionURL;
    }

    public void setJobDescriptionURL(String jobDescriptionURL) {
        this.jobDescriptionURL = jobDescriptionURL;
    }

    public String getReferralURL() {
        return referralURL;
    }

    public void setReferralURL(String referralURL) {
        this.referralURL = referralURL;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

}
