
package pl.foto99.backend.model.OpportunityJobResponse;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DesiredProfile {

    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;
    @SerializedName("educationLevel")
    @Expose
    private String educationLevel;
    @SerializedName("educationField")
    @Expose
    private String educationField;
    @SerializedName("certifications")
    @Expose
    private List<Certification> certifications = null;

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEducationField() {
        return educationField;
    }

    public void setEducationField(String educationField) {
        this.educationField = educationField;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

}
