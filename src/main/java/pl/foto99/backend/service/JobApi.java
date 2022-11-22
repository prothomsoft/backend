package pl.foto99.backend.service;


import pl.foto99.backend.model.Job;
import pl.foto99.backend.model.OpportunityJobRequest.OpportunityJobRequest;
import pl.foto99.backend.model.OpportunityJobResponse.OpportunityJobResponse;
import pl.foto99.backend.model.OpportunityResponse;
import pl.foto99.backend.model.SearchCriteriaDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JobApi {
    @GET("/posts")
    Call<List<Job>> fetchJobs();
    @GET("/posts/{id}")
    Call<Job> fetchJobById(@Path("id") int id);
    @POST("/posts")
    Call<Job> createJob(@Body Job job);
    @DELETE("/posts/{id}")
    Call<Job> deleteJobById(@Path("id") int id);
    @POST("/pxp-talent-marketplace-ecs/authentication/v2/generate/internal/token")
    Call<String> getToken(@Query("corp_id") String corp_id,
                       @Query("cloud-corp-id") String cloud_corp_id,
                       @Query("user-id") String user_id,
                       @Query("x-app") String x_app,
                       @Query("x-ptn") String x_ptn);

    @POST("/pxp-talent-marketplace-ecs/v2/opportunities")
    Call<OpportunityResponse> getOpportunities(@Body SearchCriteriaDTO searchCriteriaDTO);

    @GET("/pxp-talent-marketplace-ecs/opportunities/job/{id}")
    Call<OpportunityJobResponse>  getOpportunityJobById(@Path("id") String id);

    @PUT("/pxp-talent-marketplace-ecs/opportunities/job/{id}")
    Call<OpportunityJobResponse>  updateOpportunityJobById(@Path("id") String id, @Body OpportunityJobRequest opportunityJobRequest);

    @GET("/pxp-talent-marketplace-ecs/opportunities/role/{id}")
    Call<OpportunityJobResponse>  getOpportunityRoleById(@Path("id") String id);

    @PUT("/pxp-talent-marketplace-ecs/opportunities/role/{id}")
    Call<OpportunityJobResponse>  updateOpportunityRoleById(@Path("id") String id, @Body OpportunityJobRequest opportunityJobRequest);
}
