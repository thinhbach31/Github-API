package com.example.admin.github_api;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JSONReader extends AsyncTask<String, Void, ArrayList<Data>> {

    private static final String KEY_ID = "id";
    private static final String KEY_NODE_ID = "node_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_OWNER_ID = "id";
    private static final String KEY_OWNER_AVATAR_URL = "avatar_url";
    private static final String KEY_URL = "url";
    private static final String REQUEST_METHOD = "GET";
    private static final String TAG = "TAG";

    private onLoadDataFinishedListener mListener;

    public JSONReader(onLoadDataFinishedListener listener) {
        mListener = listener;
    }

    @Override
    protected ArrayList<Data> doInBackground(String... strings) {

        String url_api = strings[0];
        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL url = new URL(url_api);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(REQUEST_METHOD);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
            connection.disconnect();
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Data> datas = getDataResult(stringBuilder.toString());
        
        return datas;

    }

    @Override
    protected void onPostExecute(ArrayList<Data> data) {
        super.onPostExecute(data);
        mListener.onLoadData(data);
    }

    private ArrayList<Data> getDataResult(String result) {
        ArrayList<Data> dataArrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(result);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.optInt(KEY_ID);
                String node_id = jsonObject.optString(KEY_NODE_ID);
                String name = jsonObject.optString(KEY_NAME);
                String full_name = jsonObject.optString(KEY_FULL_NAME);

                JSONObject owner = jsonObject.optJSONObject("owner");
                int own_id = owner.optInt(KEY_OWNER_ID);
                String own_node_id = owner.optString(KEY_NODE_ID);
                Log.d(TAG, "getDataResult: ngu" + own_node_id);
                String avatar = owner.optString(KEY_OWNER_AVATAR_URL);
                String url = owner.optString(KEY_URL);

                Owner owner1=new Owner(own_id, own_node_id, avatar, url);
                Log.d(TAG, "getDataResult: "+url);

                dataArrayList.add(new Data(id, node_id, name, full_name,owner1));
                Log.d(TAG, "getDataResult: con cac"+dataArrayList.get(0).getOwner().toString());
            }
        } catch (JSONException e) {
            Log.d(TAG, ": hihi" +e.getMessage());
            e.printStackTrace();
        }

        return dataArrayList;
    }

    interface onLoadDataFinishedListener {
        void onLoadData(ArrayList<Data> data);
    }
}
