package me.simbachain.healthspace.simba_android;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSimba {

    @SerializedName("hashId")
    @Expose
    private Integer hashId;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("auditor")
    @Expose
    private String auditor;
    @SerializedName("asset")
    @Expose
    private Asset asset;
    @SerializedName("verified")
    @Expose
    private String verified;
    @SerializedName("verifications")
    @Expose
    private List<Verification> verifications = null;

    public Integer getHashId() {
        return hashId;
    }

    public String getHashIdInString() {
        return hashId.toString();
    }

    public void setHashId(Integer hashId) {
        this.hashId = hashId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public List<Verification> getVerifications() {
        return verifications;
    }

    public void setVerifications(List<Verification> verifications) {
        this.verifications = verifications;
    }
}