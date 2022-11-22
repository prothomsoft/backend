package pl.foto99.backend.service.impl;

import org.springframework.stereotype.Component;
import pl.foto99.backend.model.Job;
import pl.foto99.backend.model.OpportunityJobRequest.OpportunityJobRequest;
import pl.foto99.backend.model.OpportunityJobRequest.OpportunityJobRequestDescription;
import pl.foto99.backend.model.OpportunityJobRequest.OpportunityJobRequestLevel;
import pl.foto99.backend.model.OpportunityJobResponse.Description;
import pl.foto99.backend.model.OpportunityJobResponse.OpportunityJobResponse;
import pl.foto99.backend.model.OpportunityResponse;
import pl.foto99.backend.model.SearchCriteriaDTO;
import pl.foto99.backend.model.Value;
import pl.foto99.backend.service.JobApi;
import pl.foto99.backend.service.JobService;
import pl.foto99.backend.util.RetrofitUtl;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobServiceImpl implements JobService {

    private Retrofit retrofit;
    private JobApi jobApi;

    public JobServiceImpl() {
        retrofit = RetrofitUtl.getRetrofitInstance();
        jobApi = retrofit.create(JobApi.class);
    }

    @Override
    public List<Job> fetchJobs() {
        List<Job> jobResponse = new ArrayList<>();
        Call<List<Job>> fetchJobCall = jobApi.fetchJobs();
        try {
            Response<List<Job>> response = fetchJobCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                jobResponse = response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobResponse;
    }

    @Override
    public Job fetchJobById(int id) {
        Job job = null;
        Call<Job> jobCall = jobApi.fetchJobById(id);

        try {
            Response<Job> response = jobCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                job = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return job;
    }

    @Override
    public Job createJob(Job job) {
        Call<Job> jobCall = jobApi.createJob(job);

        try {
            Response<Job> response = jobCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                System.out.println(response.body());
                job = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return job;
    }

    @Override
    public Job deleteJobById(int id) {
        Job job = null;
        Call<Job> jobCall = jobApi.deleteJobById(id);

        try {
            Response<Job> response = jobCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                System.out.println(response.body());
                job = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return job;
    }

    @Override
    public String getToken(String corp_id, String cloud_corp_id, String user_id, String x_app, String x_ptn) {
        String token = null;
        Call<String> tokenCall = jobApi.getToken(corp_id, cloud_corp_id, user_id, x_app, x_ptn);

        try {
            Response<String> response = tokenCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                token = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return token;
    }

    @Override
    public OpportunityResponse getOpportunities(SearchCriteriaDTO searchCriteriaDTO) {
        OpportunityResponse opportunityResponse = null;
        Call<OpportunityResponse> jobCall = jobApi.getOpportunities(searchCriteriaDTO);

        try {
            Response<OpportunityResponse> response = jobCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                opportunityResponse = response.body();

                List<Value> opportunities = opportunityResponse.getValues();

                List<String> list = new ArrayList<>();

                list.add("job_id");

                for(String l : list) {
                    getOpportunityJobById(l);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return opportunityResponse;
    }

    @Override
    public OpportunityJobResponse getOpportunityJobById(String id) {
        OpportunityJobResponse opportunityJobResponse = null;
        Call<OpportunityJobResponse> opportunityRoleById = jobApi.getOpportunityJobById(id);

        try {
            Response<OpportunityJobResponse> response = opportunityRoleById.execute();
            if(response.isSuccessful() && response.body() != null) {
                opportunityJobResponse = response.body();

                System.out.println("JOB IN PROGRESS: " +  opportunityJobResponse.getId());

                OpportunityJobRequest opportunityJobRequest = new OpportunityJobRequest();

                // map id from response to request
                opportunityJobRequest.setId(opportunityJobResponse.getId());

                opportunityJobResponse.getDescriptions();

                // map job description from response to request
                List<OpportunityJobRequestDescription> opportunityJobRequestDescriptions = new ArrayList<>();
                OpportunityJobRequestDescription opportunityJobRequestDescriptionFromRequest = new OpportunityJobRequestDescription();
                if(opportunityJobResponse.getDescriptions().size() > 0) {
                    opportunityJobRequestDescriptionFromRequest.setDescription(opportunityJobResponse.getDescriptions().get(0).getDescription());
                    opportunityJobRequestDescriptionFromRequest.setTitle(opportunityJobResponse.getDescriptions().get(0).getTitle());
                    opportunityJobRequestDescriptionFromRequest.setLanguage(opportunityJobResponse.getDescriptions().get(0).getLanguage());
                    opportunityJobRequestDescriptionFromRequest.setIsDefault(opportunityJobResponse.getDescriptions().get(0).getIsDefault());
                } else {
                    opportunityJobRequestDescriptionFromRequest.setDescription("");
                    opportunityJobRequestDescriptionFromRequest.setTitle("");
                    opportunityJobRequestDescriptionFromRequest.setLanguage("");
                    opportunityJobRequestDescriptionFromRequest.setIsDefault(true);
                }
                opportunityJobRequestDescriptions.add(opportunityJobRequestDescriptionFromRequest);
                opportunityJobRequest.setDescriptions(opportunityJobRequestDescriptions);

                // map jobStatus from response to request
                opportunityJobRequest.setJobStatus(opportunityJobResponse.getJobStatus());

                // map level from response to request
                List<OpportunityJobRequestLevel> opportunityJobRequestLevel = new ArrayList<>();
                OpportunityJobRequestLevel opportunityJobRequestLevelFromRequest = new OpportunityJobRequestLevel();
                opportunityJobRequestLevelFromRequest.setId(opportunityJobResponse.getLevel().getId());
                opportunityJobRequestLevelFromRequest.setValue(opportunityJobResponse.getLevel().getValue());

                if(opportunityJobResponse.getLevel().getValue() == 1) {
                    opportunityJobRequestLevelFromRequest.setId("ENTRY_LEVEL");
                }
                if(opportunityJobResponse.getLevel().getValue() == 2) {
                    opportunityJobRequestLevelFromRequest.setId("INTERNSHIP");
                }
                if(opportunityJobResponse.getLevel().getValue() == 3) {
                    opportunityJobRequestLevelFromRequest.setId("ASSOCIATE");
                }
                if(opportunityJobResponse.getLevel().getValue() == 4) {
                    opportunityJobRequestLevelFromRequest.setId("MID_SENIOR");
                }
                if(opportunityJobResponse.getLevel().getValue() == 5) {
                    opportunityJobRequestLevelFromRequest.setId("1gc4mmt8f");
                }
                if(opportunityJobResponse.getLevel().getValue() == 6) {
                    opportunityJobRequestLevelFromRequest.setId("1gc9mgqjn");
                }
                if(opportunityJobResponse.getLevel().getValue() == 7) {
                    opportunityJobRequestLevelFromRequest.setId("DIRECTOR");
                }
                if(opportunityJobResponse.getLevel().getValue() == 8) {
                    opportunityJobRequestLevelFromRequest.setId("1gc9mo186");
                }
                if(opportunityJobResponse.getLevel().getValue() == 9) {
                    opportunityJobRequestLevelFromRequest.setId("1gc9ms34t");
                }
                if(opportunityJobResponse.getLevel().getValue() == 10) {
                    opportunityJobRequestLevelFromRequest.setId("EXECUTIVE");
                }
                opportunityJobRequest.setLevel(opportunityJobRequestLevelFromRequest);

                // map isManagementPosition from response to request
                opportunityJobRequest.setIsManagementPosition(opportunityJobResponse.getIsManagementPosition());

                // map remote from response to request
                if(opportunityJobResponse.getRemote() != null && opportunityJobResponse.getRemote().equals("Remote")) {
                    opportunityJobRequest.setRemote("REMOTE");
                }
                if(opportunityJobResponse.getRemote() != null && opportunityJobResponse.getRemote().equals("Hybrid")) {
                    opportunityJobRequest.setRemote("HYBRID");
                }
                if(opportunityJobResponse.getRemote() != null && opportunityJobResponse.getRemote().equals("On-site")) {
                    opportunityJobRequest.setRemote("ON_SITE");
                }


                // map contractType from response to request
                if(opportunityJobResponse.getContractType() != null && opportunityJobResponse.getContractType().equals("Permanent")) {
                    opportunityJobRequest.setContractType("PERMANENT");
                }
                if(opportunityJobResponse.getContractType() != null && opportunityJobResponse.getContractType().equals("Contract")) {
                    opportunityJobRequest.setContractType("CONTRACT");
                }
                if(opportunityJobResponse.getContractType() != null && opportunityJobResponse.getContractType().equals("Temporary")) {
                    opportunityJobRequest.setContractType("TEMPORARY");
                }
                if(opportunityJobResponse.getContractType() != null && opportunityJobResponse.getContractType().equals("Volunteer")) {
                    opportunityJobRequest.setContractType("VOLUNTEER");
                }
                if(opportunityJobResponse.getContractType() != null && opportunityJobResponse.getContractType().equals("Internship")) {
                    opportunityJobRequest.setContractType("INTERNSHIP");
                }
                if(opportunityJobResponse.getContractType() != null && opportunityJobResponse.getContractType().equals("Apprenticeship")) {
                    opportunityJobRequest.setContractType("APPRENTICESHIP");
                }
                if(opportunityJobResponse.getContractType() != null && opportunityJobResponse.getContractType().equals("Other")) {
                    opportunityJobRequest.setContractType("OTHER");
                }

                // map schedule from response to request

                if(opportunityJobResponse.getSchedule() != null && opportunityJobResponse.getSchedule().equals("Full time")) {
                    opportunityJobRequest.setSchedule("FULL_TIME");
                }
                if(opportunityJobResponse.getSchedule() != null && opportunityJobResponse.getSchedule().equals("Part time")) {
                    opportunityJobRequest.setSchedule("PART_TIME");
                }

                Call<OpportunityJobResponse> opportunityJobResponseCall = jobApi.updateOpportunityJobById(id, opportunityJobRequest);

                try {
                    Response<OpportunityJobResponse> responseFromUpdate = opportunityJobResponseCall.execute();
                    if(responseFromUpdate.isSuccessful() && responseFromUpdate.body() != null) {
                        opportunityJobResponse = responseFromUpdate.body();
                        System.out.println("JOB ID UPDATED: " +  opportunityJobResponse.getId());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return opportunityJobResponse;
    }

    @Override
    public OpportunityJobResponse updateOpportunityJobById(String id, OpportunityJobRequest opportunityJobRequest) {
        OpportunityJobResponse opportunityJobResponse = null;

        Call<OpportunityJobResponse> opportunityJobResponseCall = jobApi.updateOpportunityJobById(id, opportunityJobRequest);

        try {
            Response<OpportunityJobResponse> response = opportunityJobResponseCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                opportunityJobResponse = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return opportunityJobResponse;
    }
}
