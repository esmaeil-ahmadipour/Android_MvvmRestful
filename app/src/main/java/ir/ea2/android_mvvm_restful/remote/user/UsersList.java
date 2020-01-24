package ir.ea2.android_mvvm_restful.remote.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import ir.ea2.android_mvvm_restful.model.User;

public class UsersList {
     @SerializedName("data")
    @Expose
    private ArrayList<User> userArrayList = new ArrayList<>();

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }
}
