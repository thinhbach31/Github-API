package com.example.admin.github_api;

import java.util.Date;

public class Data {

    private int mID;
    private String mNodeID;
    private String mName;
    private String mFullName;
    private Owner mOwner;

    public Data(int ID, String nodeID, String name, String fullName, Owner owner) {
        mID = ID;
        mNodeID = nodeID;
        mName = name;
        mFullName = fullName;
        mOwner = owner;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public void setOwner(Owner owner) {
        mOwner = owner;
    }

    public Data() {
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }
}
