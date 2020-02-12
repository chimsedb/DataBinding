package com.example.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databindingdemo.databinding.ActivityMainBinding;
import com.example.databindingdemo.model.User;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivityClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        User user = new User("Hưng","hungdeptrai");
        binding.setUser(user);
        binding.setHanclerClick(new MainActivityClickHandler(getApplicationContext(),user));

    }

    public class MainActivityClickHandler{

        private Context context;
        private User user;

        public MainActivityClickHandler(Context context, User user) {
            this.context = context;
            this.user = user;
        }

        public void HandlerChangeButtonClick(View view){
            user.setPassword("123");
            user.setUsername("hưng đẹp trai");
        }
    }
}
