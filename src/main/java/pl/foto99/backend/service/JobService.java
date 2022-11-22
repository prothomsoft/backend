package pl.foto99.backend.service;

import org.springframework.stereotype.Service;
import pl.foto99.backend.model.Job;
import pl.foto99.backend.model.OpportunityJobRequest.OpportunityJobRequest;
import pl.foto99.backend.model.OpportunityJobResponse.OpportunityJobResponse;
import pl.foto99.backend.model.OpportunityResponse;
import pl.foto99.backend.model.SearchCriteriaDTO;

import java.util.List;

@Service
public interface JobService {

    public List<Job> fetchJobs();
    public Job fetchJobById(int id);
    public Job createJob(Job job);
    public Job deleteJobById(int id);
    public String getToken(String corp_id, String cloud_corp_id, String user_id, String x_app, String x_ptn);

    public OpportunityResponse getOpportunities(SearchCriteriaDTO searchCriteriaDTO);

    public OpportunityJobResponse getOpportunityJobById(String id);

    public OpportunityJobResponse updateOpportunityJobById(String id, OpportunityJobRequest opportunityJobRequest);
}
