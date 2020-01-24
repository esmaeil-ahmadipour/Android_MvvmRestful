package ir.ea2.android_mvvm_restful.remote.user;

import android.util.Log;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import ir.ea2.android_mvvm_restful.model.User;
import ir.ea2.android_mvvm_restful.remote.APIService;
import ir.ea2.android_mvvm_restful.remote.RetroClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {
    private MutableLiveData<ArrayList<User>>  mutableLiveData = new MutableLiveData<>();
    ArrayList<User> userArrayList = new ArrayList<>();
    public UsersRepository() {
    }

    public void getUsers() {
        //Api Call
        APIService apiService = RetroClass.getApiService();
        Call<UsersList> usersListCall = apiService.getUsersList();
        usersListCall.enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                for (int i = 0; i < response.body().getUserArrayList().size() ; i++) {
                    userArrayList.add(response.body().getUserArrayList().get(i));
                }
                mutableLiveData.setValue(userArrayList);
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Log.e("###Error",t.toString());
            }
        });


    }

    public MutableLiveData<ArrayList<User>> getMutableLiveData() {
        return mutableLiveData;
    }
}
