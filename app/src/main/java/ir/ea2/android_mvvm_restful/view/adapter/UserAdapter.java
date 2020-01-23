package ir.ea2.android_mvvm_restful.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_mvvm_restful.R;
import ir.ea2.android_mvvm_restful.databinding.ItemUserBinding;
import ir.ea2.android_mvvm_restful.viewmodel.UserViewModel;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomHolder> {
    private ArrayList<UserViewModel> arrayList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public UserAdapter(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());

        ItemUserBinding userBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, parent, false);


        return new CustomHolder(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        UserViewModel userViewModel = arrayList.get(position);
        holder.bind(userViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    //set Class ViewHolder for : Binding Items to View
    class CustomHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding itemUserBinding;

        public CustomHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
        }

        private void bind(UserViewModel viewModel) {
            this.itemUserBinding.setItem(viewModel);
            this.itemUserBinding.executePendingBindings();
        }

        public ItemUserBinding getItemUserBinding() {
            return itemUserBinding;
        }
    }
}
