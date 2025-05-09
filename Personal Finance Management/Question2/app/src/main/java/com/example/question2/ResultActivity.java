package com.example.question2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvName, tvSalary, tvNeeds, tvWants, tvSavings;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        tvName = findViewById(R.id.etName);
        tvSalary = findViewById(R.id.etSalary);
        tvNeeds = findViewById(R.id.etNeeds);
        tvWants = findViewById(R.id.etWants);
        tvSavings = findViewById(R.id.etSavings);
        btnBack = findViewById(R.id.btnBack);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double salary = intent.getDoubleExtra("salary", 0);
        double needsAmount = intent.getDoubleExtra("needs", 0);
        double wantsAmount = intent.getDoubleExtra("wants", 0);
        double savingsAmount = intent.getDoubleExtra("savings", 0);


        tvName.setText("" + name);
        tvSalary.setText("" + salary);
        tvNeeds.setText(" " + needsAmount);
        tvWants.setText(" " + wantsAmount);
        tvSavings.setText("" + savingsAmount);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
