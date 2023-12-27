package com.doantrungkien.excersise51_group1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText urlEditText = findViewById(R.id.urlEditText);
        EditText imageUrlEditText = findViewById(R.id.imageUrlEditText);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String url = urlEditText.getText().toString();
            String imageUrl = imageUrlEditText.getText().toString();

            News newNews = new News(title, url, imageUrl);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("newNews", newNews); // Bây giờ đã có thể truyền đối tượng News qua Intent
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}