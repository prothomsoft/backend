
package pl.foto99.backend.model.OpportunityJobRequest;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class OpportunityJobRequestLevel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("value")
    @Expose
    private Integer value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
