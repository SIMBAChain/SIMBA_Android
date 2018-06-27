package me.simbachain.healthspace.simba_android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SimbaClient {
    @GET("audit/{auditId}/")
    Call<List<GetSimba>> getAuditItems(@Path("auditId") int auditId);

    @GET("audit/")
    Call<List<GetSimba>> getAudits();

    @GET("audit/{auditId}/verifications")
    Call<List<Verification>>  getAuditVerifications(@Path("auditId") int auditId);

    @POST("audit")
    Call<PostSimba> postAudit(@Body PostSimba postSimba);

    @POST("audit/{auditId}/verify")
    Call<PostVerification> postVerification(@Path("auditId") int auditId, @Body PostVerification postVerification);
}
