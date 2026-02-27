package com.community.post;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {
    
    private EditText etPostContent;
    private Button btnPost;
    private RecyclerView rvPosts;
    private PostAdapter postAdapter;
    private List<Post> postList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        
        initViews();
        setupRecyclerView();
        setupListeners();
    }
    
    private void initViews() {
        etPostContent = findViewById(R.id.et_post_content);
        btnPost = findViewById(R.id.btn_post);
        rvPosts = findViewById(R.id.rv_posts);
        
        postList = new ArrayList<>();
        // 添加测试数据
        postList.add(new Post("用户1", "这是第一条帖子内容"));
        postList.add(new Post("用户2", "这是第二条帖子内容"));
    }
    
    private void setupRecyclerView() {
        postAdapter = new PostAdapter(postList);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        rvPosts.setAdapter(postAdapter);
    }
    
    private void setupListeners() {
        btnPost.setOnClickListener(v -> {
            String content = etPostContent.getText().toString().trim();
            if (!content.isEmpty()) {
                createPost(content);
                etPostContent.setText("");
            } else {
                Toast.makeText(this, "请输入帖子内容", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    private void createPost(String content) {
        Post newPost = new Post("当前用户", content);
        postList.add(0, newPost); // 添加到列表开头
        postAdapter.notifyItemInserted(0);
        rvPosts.scrollToPosition(0);
        
        Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
    }
    
    public static class Post {
        private String username;
        private String content;
        private long timestamp;
        
        public Post(String username, String content) {
            this.username = username;
            this.content = content;
            this.timestamp = System.currentTimeMillis();
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
    }
}