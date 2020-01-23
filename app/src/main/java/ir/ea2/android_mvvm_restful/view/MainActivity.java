package ir.ea2.android_mvvm_restful.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import ir.ea2.android_mvvm_restful.R;
import ir.ea2.android_mvvm_restful.databinding.ActivityMainBinding;
import ir.ea2.android_mvvm_restful.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Connecting All Views To VIEW_MODEL .
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //Create VIEW_MODEL Object.
        UserViewModel userViewModel = new UserViewModel(this);
        //Set Variable.
        activityMainBinding.setUser(userViewModel);
    }
}
