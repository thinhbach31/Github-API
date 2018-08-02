package com.example.admin.github_api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class GitAdapter extends RecyclerView.Adapter<GitAdapter.ViewHolder> {
    private ArrayList<Data> mDataArrayList;
    private LayoutInflater mInflater;

    public GitAdapter(ArrayList<Data> dataArrayList, Context context) {
        mDataArrayList = dataArrayList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.json_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Data data = mDataArrayList.get(i);

        viewHolder.mTextID.setText(String.valueOf(data.getID()));
        viewHolder.mTextNodeID.setText(data.getNodeID());
        viewHolder.mTextName.setText(data.getName());
        viewHolder.mTextFullname.setText(data.getFullName());

        viewHolder.mTextOwnerID.setText(String.valueOf(data.getOwner().getID()));
        viewHolder.mTextOwnerNodeID.setText(data.getOwner().getNodeID());
        viewHolder.mTextAvatar.setText(data.getOwner().getAvatarURL());
        viewHolder.mTextURL.setText(data.getOwner().getURL());

    }

    @Override
    public int getItemCount() {
        return mDataArrayList != null ? mDataArrayList.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextID;
        private TextView mTextNodeID;
        private TextView mTextName;
        private TextView mTextFullname;
        private TextView mTextOwnerID;
        private TextView mTextOwnerNodeID;
        private TextView mTextAvatar;
        private TextView mTextURL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fvbid();
        }

        private void fvbid() {
            mTextID = itemView.findViewById(R.id.text_ID);
            mTextNodeID = itemView.findViewById(R.id.text_NodeID);
            mTextName = itemView.findViewById(R.id.text_Name);
            mTextFullname = itemView.findViewById(R.id.text_FullName);
            mTextOwnerID = itemView.findViewById(R.id.text_OwnerID);
            mTextOwnerNodeID = itemView.findViewById(R.id.text_OwnerNodeID);
            mTextAvatar = itemView.findViewById(R.id.text_AvatarURL);
            mTextURL = itemView.findViewById(R.id.text_URL);
        }

    }


}
