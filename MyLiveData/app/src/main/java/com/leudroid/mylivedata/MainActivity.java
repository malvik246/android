package com.leudroid.mylivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.leudroid.mylivedata.API.APICall;
import com.leudroid.mylivedata.POJO.PostBean;
import com.leudroid.mylivedata.POJO.UserBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserBean> userBeenList;

    ListView listUser;

    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listUser = (ListView) findViewById(R.id.list_user);

        userBeenList = new ArrayList<>();

        userAdapter = new UserAdapter();
        listUser.setAdapter(userAdapter);

        //new GetFromPost().execute();
        new GetFromUser().execute();
    }

    private class GetFromPost extends AsyncTask<Void, Void, ArrayList<PostBean>> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Loading Data");
            dialog.show();
        }

        @Override
        protected ArrayList<PostBean> doInBackground(Void... voids) {

            ArrayList<PostBean> postBeanArrayList = new ArrayList<>();
            APICall apiCall = new APICall();

            postBeanArrayList = apiCall.GetPostData();

            return postBeanArrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<PostBean> postBeen) {
            super.onPostExecute(postBeen);
            Toast.makeText(MainActivity.this, postBeen.get(0).getTitle(), Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }
    }

    private class GetFromUser extends AsyncTask<Void, Void,ArrayList<UserBean>>{

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Loading Data");
            dialog.show();
        }

        @Override
        protected ArrayList<UserBean> doInBackground(Void... voids) {
            ArrayList<UserBean> userBeanArrayList = new ArrayList<>();
            APICall apiCall = new APICall();

            userBeanArrayList = apiCall.GetUserData();

            return userBeanArrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<UserBean> userBeen) {
            super.onPostExecute(userBeen);

            userBeenList.clear();
            userBeenList.addAll(userBeen);
            userAdapter.notifyDataSetChanged();

            dialog.dismiss();
            //Toast.makeText(MainActivity.this, userBeen.get(0).getAddress().getGeo().getLat(), Toast.LENGTH_SHORT).show();

        }
    }

    private class UserAdapter extends BaseAdapter {

        ViewHolder holder;

        @Override
        public int getCount() {
            return userBeenList.size();
        }

        @Override
        public Object getItem(int i) {
            return userBeenList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){

                view = getLayoutInflater().inflate(R.layout.list_user, viewGroup, false);

                holder = new ViewHolder();

                holder.textName = (TextView) view.findViewById(R.id.textName);
                holder.textAddress = (TextView) view.findViewById(R.id.textAddress);
                holder.textCompanyName = (TextView) view.findViewById(R.id.textCompany);

                view.setTag(holder);

            }else {

                holder = (ViewHolder) view.getTag();

            }

            holder.textName.setText(userBeenList.get(i).getName());
            holder.textAddress.setText(userBeenList.get(i).getAddress().getGeo().getLat());
            holder.textCompanyName.setText(userBeenList.get(i).getCompany().getName());

            return view;
        }
    }


    private  class ViewHolder {
        TextView textName;
        TextView textAddress;
        TextView textCompanyName;
    }

}