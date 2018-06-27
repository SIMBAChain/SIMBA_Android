package me.simbachain.healthspace.simba_android;

public class PostSimba {

    private String accountId;
    private Asset asset;

    public PostSimba(String accountId, Asset asset) {
        this.accountId = accountId;
        this.asset = asset;
    }
}
