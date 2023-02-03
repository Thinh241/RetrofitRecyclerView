package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private final List<User> mListuser;

    public UserAdapter(List<User> mListuser) {
        this.mListuser = mListuser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListuser.get(position);
        if(user == null){
            return;
        }
        holder.tvUserId.setText(String.valueOf(user.getUserId()));
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvTitle.setText(user.getTitle());
        holder.tvBody.setText(user.getBody());
    }

    @Override
    public int getItemCount() {
        if(mListuser != null){
            return mListuser.size();
        }
        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        TextView tvId, tvTitle, tvUserId, tvBody;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvUserId = itemView.findViewById(R.id.tv_userid);
            tvBody = itemView.findViewById(R.id.tv_body);
        }
    }
}
