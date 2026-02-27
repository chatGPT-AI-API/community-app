package com.community.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    
    private List<CommentActivity.Comment> commentList;
    
    public CommentAdapter(List<CommentActivity.Comment> commentList) {
        this.commentList = commentList;
    }
    
    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        CommentActivity.Comment comment = commentList.get(position);
        holder.bind(comment);
    }
    
    @Override
    public int getItemCount() {
        return commentList.size();
    }
    
    static class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername, tvContent, tvTime, tvLikes;
        ImageButton btnLike;
        
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tv_comment_username);
            tvContent = itemView.findViewById(R.id.tv_comment_content);
            tvTime = itemView.findViewById(R.id.tv_comment_time);
            tvLikes = itemView.findViewById(R.id.tv_comment_likes);
            btnLike = itemView.findViewById(R.id.btn_like);
        }
        
        public void bind(CommentActivity.Comment comment) {
            tvUsername.setText(comment.getUsername());
            tvContent.setText(comment.getContent());
            tvLikes.setText(String.valueOf(comment.getLikes()));
            
            // 格式化时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            String time = sdf.format(new Date(comment.getTimestamp()));
            tvTime.setText(time);
            
            // 点赞功能
            btnLike.setOnClickListener(v -> {
                comment.incrementLikes();
                tvLikes.setText(String.valueOf(comment.getLikes()));
            });
        }
    }
}