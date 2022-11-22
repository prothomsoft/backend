
package pl.foto99.backend.model.OpportunityJobResponse;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class OpportunityJobResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("accessRoles")
    @Expose
    private List<String> accessRoles = null;
    @SerializedName("tenantId")
    @Expose
    private String tenantId;
    @SerializedName("sourceId")
    @Expose
    private String sourceId;
    @SerializedName("customFields")
    @JsonIgnore
    private List<CustomField> customFields = null;
    @SerializedName("descriptions")
    @Expose
    private List<Description> descriptions = null;
    @SerializedName("level")
    @Expose
    private Level level;
    @SerializedName("capabilities")
    @JsonIgnore
    private List<Capability> capabilities = null;
    @SerializedName("isManagementPosition")
    @Expose
    private Boolean isManagementPosition;
    @SerializedName("jobFamilies")
    @JsonIgnore
    private List<String> jobFamilies = null;
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("grade")
    @Expose
    private String grade;
    @SerializedName("referenceNumber")
    @Expose
    private String referenceNumber;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("urls")
    @JsonIgnore
    private List<Url> urls = null;
    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("endDateTime")
    @Expose
    private String endDateTime;
    @SerializedName("locations")
    @JsonIgnore
    private List<Location> locations = null;
    @SerializedName("remote")
    @Expose
    private String remote;
    @SerializedName("division")
    @JsonIgnore
    private String division;
    @SerializedName("contractType")
    @Expose
    private String contractType;
    @SerializedName("salaryRange")
    @Expose
    private SalaryRange salaryRange;
    @SerializedName("salaryRangeString")
    @Expose
    private String salaryRangeString;
    @SerializedName("linkedRoles")
    @JsonIgnore
    private List<String> linkedRoles = null;
    @SerializedName("linkedRolesExternalId")
    @Expose
    private List<String> linkedRolesExternalId = null;
    @SerializedName("hiringManagerIds")
    @Expose
    private List<String> hiringManagerIds = null;
    @SerializedName("recruitingTeamIds")
    @Expose
    private List<String> recruitingTeamIds = null;
    @SerializedName("desiredProfile")
    @Expose
    private DesiredProfile desiredProfile;
    @SerializedName("jobStatus")
    @Expose
    private String jobStatus;
    @SerializedName("schedule")
    @Expose
    private String schedule;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("createdDateTimestamp")
    @JsonIgnore
    private String createdDateTimestamp;
    @SerializedName("updatedDateTimestamp")
    @JsonIgnore
    private String updatedDateTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAccessRoles() {
        return accessRoles;
    }

    public void setAccessRoles(List<String> accessRoles) {
        this.accessRoles = accessRoles;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public Boolean getIsManagementPosition() {
        return isManagementPosition;
    }

    public void setIsManagementPosition(Boolean isManagementPosition) {
        this.isManagementPosition = isManagementPosition;
    }

    public List<String> getJobFamilies() {
        return jobFamilies;
    }

    public void setJobFamilies(List<String> jobFamilies) {
        this.jobFamilies = jobFamilies;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public SalaryRange getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(SalaryRange salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getSalaryRangeString() {
        return salaryRangeString;
    }

    public void setSalaryRangeString(String salaryRangeString) {
        this.salaryRangeString = salaryRangeString;
    }

    public List<String> getLinkedRoles() {
        return linkedRoles;
    }

    public void setLinkedRoles(List<String> linkedRoles) {
        this.linkedRoles = linkedRoles;
    }

    public List<String> getLinkedRolesExternalId() {
        return linkedRolesExternalId;
    }

    public void setLinkedRolesExternalId(List<String> linkedRolesExternalId) {
        this.linkedRolesExternalId = linkedRolesExternalId;
    }

    public List<String> getHiringManagerIds() {
        return hiringManagerIds;
    }

    public void setHiringManagerIds(List<String> hiringManagerIds) {
        this.hiringManagerIds = hiringManagerIds;
    }

    public List<String> getRecruitingTeamIds() {
        return recruitingTeamIds;
    }

    public void setRecruitingTeamIds(List<String> recruitingTeamIds) {
        this.recruitingTeamIds = recruitingTeamIds;
    }

    public DesiredProfile getDesiredProfile() {
        return desiredProfile;
    }

    public void setDesiredProfile(DesiredProfile desiredProfile) {
        this.desiredProfile = desiredProfile;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedDateTimestamp() {
        return createdDateTimestamp;
    }

    public void setCreatedDateTimestamp(String createdDateTimestamp) {
        this.createdDateTimestamp = createdDateTimestamp;
    }

    public String getUpdatedDateTimestamp() {
        return updatedDateTimestamp;
    }

    public void setUpdatedDateTimestamp(String updatedDateTimestamp) {
        this.updatedDateTimestamp = updatedDateTimestamp;
    }

}
