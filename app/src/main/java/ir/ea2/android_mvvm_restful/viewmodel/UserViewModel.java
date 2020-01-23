package ir.ea2.android_mvvm_restful.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import ir.ea2.android_mvvm_restful.model.User;

public class UserViewModel extends BaseObservable {
    private Context context;
    private String name;
    private String phoneNumber;

    //When use ViewModel we Have UserObject and UserData
    public UserViewModel(User user) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public UserViewModel(Context context) {
        this.context = context;
    }
@Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
