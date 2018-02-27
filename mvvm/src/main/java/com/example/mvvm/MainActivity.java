package com.example.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setStudent(new User("xiaohong", "wang"));
        binding.setClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ddddd", Toast.LENGTH_SHORT).show();
            }
        });
        binding.setUrl("http://images.csdn.net/20150810/Blog-Image%E5%89%AF%E6%9C%AC.jpg");
    }
}
