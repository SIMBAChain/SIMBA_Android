package me.simbachain.healthspace.simba_android;

public class PostVerification {

    private String accountId;
    private boolean verification;

    public PostVerification(String accountId, boolean verification) {
        this.accountId = accountId;
        this.verification = verification;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPostedVerification() {
        return Boolean.toString(verification);
    }
}
