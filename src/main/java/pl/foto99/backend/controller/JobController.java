package pl.foto99.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.foto99.backend.model.Job;
import pl.foto99.backend.model.OpportunityJobRequest.OpportunityJobRequest;
import pl.foto99.backend.model.OpportunityJobResponse.OpportunityJobResponse;
import pl.foto99.backend.model.OpportunityResponse;
import pl.foto99.backend.model.SearchCriteriaDTO;
import pl.foto99.backend.service.JobService;
import pl.foto99.backend.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/v1/retrofit")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> fetchJobs() {
        return jobService.fetchJobs();
    }

    @GetMapping("/jobs/{id}")
    public Job fetchJob(@PathVariable("id") int id) {
        return jobService.fetchJobById(id);
    }
    @PostMapping("/jobs")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @DeleteMapping("/jobs/{id}")
    public Job deleteJob(@PathVariable("id") int id) {
        return jobService.deleteJobById(id);
    }

    @PostMapping("/token/{corp_id}/{cloud_corp_id}/{user_id}/{x_app}/{x_ptn}")
    public String getToken(@PathVariable("corp_id") String corp_id,
                        @PathVariable("cloud_corp_id") String cloud_corp_id,
                        @PathVariable("user_id") String user_id,
                        @PathVariable("x_app") String x_app,
                        @PathVariable("x_ptn") String x_ptn) {
        return jobService.getToken(corp_id, cloud_corp_id, user_id, x_app, x_ptn);
    }

    @PostMapping("/opportunities")
    public OpportunityResponse getOpportunities(@RequestBody SearchCriteriaDTO searchCriteriaDTO) {
        return jobService.getOpportunities(searchCriteriaDTO);
    }

    @GetMapping("/job/{id}")
    public OpportunityJobResponse getOpportunityJobById(@PathVariable("id") String id) {
        return jobService.getOpportunityJobById(id);
    }

    @PutMapping("/job/{id}")
    public OpportunityJobResponse createJob(@PathVariable("id") String id, @RequestBody OpportunityJobRequest opportunityJobRequest) {
        return jobService.updateOpportunityJobById(id, opportunityJobRequest);
    }
}
