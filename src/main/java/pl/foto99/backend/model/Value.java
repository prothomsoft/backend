
package pl.foto99.backend.model;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Value {

    @SerializedName("type")
    @JsonIgnore
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @JsonIgnore
    private String title;
    @SerializedName("locations")
    @JsonIgnore
    private List<Location> locations = null;
    @SerializedName("remote")
    @Expose
    private String remote;
    @SerializedName("schedule")
    @Expose
    private String schedule;
    @SerializedName("contractType")
    @Expose
    private String contractType;
    @SerializedName("isManagementPosition")
    @Expose
    private Boolean isManagementPosition;
    @SerializedName("capabilities")
    @JsonIgnore
    private List<Capability> capabilities = null;
    @SerializedName("matchingScore")
    @JsonIgnore
    private Integer matchingScore;
    @SerializedName("isWildCard")
    @JsonIgnore
    private Boolean isWildCard;
    @SerializedName("jobFamilies")
    @JsonIgnore
    private List<String> jobFamilies = null;
    @SerializedName("level")
    @Expose
    private Level level;
    @SerializedName("linkedRoles")
    @JsonIgnore
    private List<String> linkedRoles = null;
    @SerializedName("hasOpenJobs")
    @JsonIgnore
    private Boolean hasOpenJobs;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Boolean getIsManagementPosition() {
        return isManagementPosition;
    }

    public void setIsManagementPosition(Boolean isManagementPosition) {
        this.isManagementPosition = isManagementPosition;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public Integer getMatchingScore() {
        return matchingScore;
    }

    public void setMatchingScore(Integer matchingScore) {
        this.matchingScore = matchingScore;
    }

    public Boolean getIsWildCard() {
        return isWildCard;
    }

    public void setIsWildCard(Boolean isWildCard) {
        this.isWildCard = isWildCard;
    }

    public List<String> getJobFamilies() {
        return jobFamilies;
    }

    public void setJobFamilies(List<String> jobFamilies) {
        this.jobFamilies = jobFamilies;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<String> getLinkedRoles() {
        return linkedRoles;
    }

    public void setLinkedRoles(List<String> linkedRoles) {
        this.linkedRoles = linkedRoles;
    }

    public Boolean getHasOpenJobs() {
        return hasOpenJobs;
    }

    public void setHasOpenJobs(Boolean hasOpenJobs) {
        this.hasOpenJobs = hasOpenJobs;
    }

}
