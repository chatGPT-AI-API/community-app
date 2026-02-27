package com.community.comment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {
    
    private EditText etComment;
    private Button btnComment;
    private RecyclerView rvComments;
    private CommentAdapter commentAdapter;
    private List<Comment> commentList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        
        initViews();
        setupRecyclerView();
        setupListeners();
    }
    
    private void initViews() {
        etComment = findViewById(R.id.et_comment);
        btnComment = findViewById(R.id.btn_comment);
        rvComments = findViewById(R.id.rv_comments);
        
        commentList = new ArrayList<>();
        // 添加测试数据
        commentList.add(new Comment("用户1", "这个帖子很有意思"));
        commentList.add(new Comment("用户2", "赞一个"));
    }
    
    private void setupRecyclerView() {
        commentAdapter = new CommentAdapter(commentList);
        rvComments.setLayoutManager(new LinearLayoutManager(this));
        rvComments.setAdapter(commentAdapter);
    }
    
    private void setupListeners() {
        btnComment.setOnClickListener(v -> {
            String content = etComment.getText().toString().trim();
            if (!content.isEmpty()) {
                addComment(content);
                etComment.setText("");
            } else {
                Toast.makeText(this, "请输入评论内容", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    private void addComment(String content) {
        Comment newComment = new Comment("当前用户", content);
        commentList.add(0, newComment); // 添加到列表开头
        commentAdapter.notifyItemInserted(0);
        rvComments.scrollToPosition(0);
        
        Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show();
    }
    
    public static class Comment {
        private String username;
        private String content;
        private long timestamp;
        private int likes;
        
        public Comment(String username, String content) {
            this.username = username;
            this.content = content;
            this.timestamp = System.currentTimeMillis();
            this.likes = 0;
        }
        
        public String getUsername() {
            return username;
        }
        
        public String getContent() {
            return content;
        }
        
        public long getTimestamp() {
            return timestamp;
        }
        
        public int getLikes() {
            return likes;
        }
        
        public void incrementLikes() {
            likes++;
        }
    }
}