
package pl.foto99.backend.model.OpportunityJobRequest;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class OpportunityJobRequest {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("descriptions")
    @Expose
    private List<OpportunityJobRequestDescription> opportunityJobRequestDescriptions = null;
    @SerializedName("level")
    @Expose
    private OpportunityJobRequestLevel opportunityJobRequestLevel;
    @SerializedName("isManagementPosition")
    @Expose
    private Boolean isManagementPosition;
    @SerializedName("remote")
    @Expose
    private String remote;
    @SerializedName("contractType")
    @Expose
    private String contractType;
    @SerializedName("schedule")
    @Expose
    private Object schedule;
    @SerializedName("jobStatus")
    @Expose
    private String jobStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OpportunityJobRequestDescription> getDescriptions() {
        return opportunityJobRequestDescriptions;
    }

    public void setDescriptions(List<OpportunityJobRequestDescription> opportunityJobRequestDescriptions) {
        this.opportunityJobRequestDescriptions = opportunityJobRequestDescriptions;
    }

    public OpportunityJobRequestLevel getLevel() {
        return opportunityJobRequestLevel;
    }

    public void setLevel(OpportunityJobRequestLevel opportunityJobRequestLevel) {
        this.opportunityJobRequestLevel = opportunityJobRequestLevel;
    }

    public Boolean getIsManagementPosition() {
        return isManagementPosition;
    }

    public void setIsManagementPosition(Boolean isManagementPosition) {
        this.isManagementPosition = isManagementPosition;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Object getSchedule() {
        return schedule;
    }

    public void setSchedule(Object schedule) {
        this.schedule = schedule;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

}
