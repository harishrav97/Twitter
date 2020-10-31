package com.example.twitter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.twitter.Adapter.RecyclerAdapter;
import com.example.twitter.Model.TwitterModel;
import com.example.twitter.ViewModel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextInputEditText edtSearch;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private MainActivityViewModel mMainActivityViewModel;
    private FloatingActionButton fab;
    private EditText searchField;
    private boolean sorting=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSearch=findViewById(R.id.edtSearch);
        mRecyclerView=findViewById(R.id.recycle);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText=edtSearch.getText().toString();
                if(!searchText.isEmpty()){
                    updateRecyclerView(mMainActivityViewModel.filter(searchText));
                }
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView(){
        List<TwitterModel> tweet=mMainActivityViewModel.getTweetList();
        System.out.println("tweet +"+tweet.toString());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new RecyclerAdapter(mMainActivityViewModel.getTweetList(),MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }
    private void updateRecyclerView(List<TwitterModel> tweets){
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new RecyclerAdapter(tweets,this);
        mRecyclerView.setAdapter(mAdapter);
    }
}