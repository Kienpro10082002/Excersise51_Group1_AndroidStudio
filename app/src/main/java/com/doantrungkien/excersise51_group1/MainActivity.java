package com.doantrungkien.excersise51_group1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<News> newsList = new ArrayList<>();
    private final int ADD_NEWS_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Mock data for demonstration purposes
        newsList = new ArrayList<>();
        newsList.add(new News("Ông Lưu Bình Nhưỡng bị cáo buộc 'trục lợi hàng trăm nghìn USD'",
                "https://vnexpress.net/ong-luu-binh-nhuong-bi-khoi-to-them-toi-4693668.html",
                "https://i1-vnexpress.vnecdn.net/2023/12/26/bi-nh-nhu-o-ng-jpeg-7299-1703582261.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=8rYjYiAmzlRIlC2F6e5TLw"));
        newsList.add(new News("Nhộn nhịp việc làm Tết",
                "https://vnexpress.net/nhon-nhip-viec-lam-tet-4690502.html",
                "https://i1-vnexpress.vnecdn.net/2023/12/26/z4989301339032-ccfd09ae2f283da-1576-3857-1703582733.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=gC2boR_FE46xNnp2VVBllw"));
        // Add more news items as needed

        newsAdapter = new NewsAdapter(newsList, this::openDetailActivity);
        recyclerView.setAdapter(newsAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddNewsActivity.class);
            startActivityForResult(intent, ADD_NEWS_REQUEST_CODE); // ADD_NEWS_REQUEST_CODE là một số nguyên, ví dụ: 1
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NEWS_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("newNews")) {
                News newNews = data.getParcelableExtra("newNews");
                newsList.add(newNews);
                newsAdapter.notifyDataSetChanged();
            }
        }
    }

    private void openDetailActivity(String url) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}
