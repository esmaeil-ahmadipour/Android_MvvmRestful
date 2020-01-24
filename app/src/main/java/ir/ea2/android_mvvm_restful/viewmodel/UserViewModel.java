package ir.ea2.android_mvvm_restful.viewmodel;

import android.content.Context;

import java.util.ArrayList;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_mvvm_restful.model.User;
import ir.ea2.android_mvvm_restful.view.adapter.UserAdapter;

public class UserViewModel extends BaseObservable {
    private Context context;
    private String name;
    private String phoneNumber;
    private ArrayList<UserViewModel> arrayListMutableLiveData = new ArrayList<>();

    //When use ViewModel we Have UserObject and UserData
    public UserViewModel(User user) {
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();

    }

    public UserViewModel(Context context) {
        this.context = context;
        //Connect to Api Server.
        for (int i = 0; i < 150; i++) {
            User user = new User("StudentID_" + i, "  093-000-000" + i);
            UserViewModel model = new UserViewModel(user);
            arrayListMutableLiveData.add(model);
        }
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);

    }
@Bindable
    public ArrayList<UserViewModel> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }

    public void setArrayListMutableLiveData(ArrayList<UserViewModel> arrayListMutableLiveData) {
        this.arrayListMutableLiveData = arrayListMutableLiveData;
        notifyPropertyChanged(BR.arrayListMutableLiveData);
    }

    //automatically BindingAdapter Passing RecyclerView To Owen Method .
    //for Passing MutableLiveData to this Method we Going To activity_main.xml >> RecyclerView >> bind TAG.
    @BindingAdapter("bind:recyclerViewUser")
    public static void recyclerUserBinder(final RecyclerView recyclerView,final ArrayList<UserViewModel> arrayListMutableLiveData) {
                UserAdapter userAdapter = new UserAdapter(arrayListMutableLiveData);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext() , RecyclerView.VERTICAL , false));
                recyclerView.setAdapter(userAdapter);
    }
}
