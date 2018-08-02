package com.example.admin.github_api;

public class Owner {
    private int mID;
    private String mNodeID;
    private String mAvatarURL;
    private String mURL;

    public Owner(int ID, String nodeID, String avatarURL, String URL) {
        mID = ID;
        mNodeID = nodeID;
        mAvatarURL = avatarURL;
        mURL = URL;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getNodeID() {
        return mNodeID;
    }

    public void setNodeID(String nodeID) {
        mNodeID = nodeID;
    }

    public String getAvatarURL() {
        return mAvatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        mAvatarURL = avatarURL;
    }

    public String getURL() {
        return mURL;
    }

    public void setURL(String URL) {
        mURL = URL;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "mID=" + mID +
                ", mNodeID='" + mNodeID + '\'' +
                ", mAvatarURL='" + mAvatarURL + '\'' +
                ", mURL='" + mURL + '\'' +
                '}';
    }
}
