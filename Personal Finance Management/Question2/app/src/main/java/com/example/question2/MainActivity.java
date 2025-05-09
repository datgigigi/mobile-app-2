package com.example.question2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.question2.ResultActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etSalary, etNeeds, etWants, etSavings;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageView mainImage = findViewById(R.id.main_image);
        mainImage.setImageResource(R.drawable.finance);


        etName = findViewById(R.id.etName);
        etSalary = findViewById(R.id.etSalary);
        etNeeds = findViewById(R.id.etNeeds);
        etWants = findViewById(R.id.etWants);
        etSavings = findViewById(R.id.etSavings);
        btnCalculate = findViewById(R.id.btnCalculate);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = etName.getText().toString().trim();
                String salaryStr = etSalary.getText().toString().trim();
                String needsStr = etNeeds.getText().toString().trim();
                String wantsStr = etWants.getText().toString().trim();
                String savingsStr = etSavings.getText().toString().trim();

                if(nameStr.isEmpty() || salaryStr.isEmpty() ||
                        needsStr.isEmpty() || wantsStr.isEmpty() || savingsStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter complete information!", Toast.LENGTH_SHORT).show();
                    return;
                }


                double salary = Double.parseDouble(salaryStr);
                double needsPercent = Double.parseDouble(needsStr);
                double wantsPercent = Double.parseDouble(wantsStr);
                double savingsPercent = Double.parseDouble(savingsStr);


                double totalPercent = needsPercent + wantsPercent + savingsPercent;
                if(totalPercent != 100) {
                    Toast.makeText(MainActivity.this, "Total Needs + Wants + Savings must be 100%", Toast.LENGTH_LONG).show();
                    return;
                }


                double needsAmount = (needsPercent / 100) * salary;
                double wantsAmount = (wantsPercent / 100) * salary;
                double savingsAmount = (savingsPercent / 100) * salary;


                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("name", nameStr);
                intent.putExtra("salary", salary);
                intent.putExtra("needs", needsAmount);
                intent.putExtra("wants", wantsAmount);
                intent.putExtra("savings", savingsAmount);
                startActivity(intent);
            }
        });
    }
}
