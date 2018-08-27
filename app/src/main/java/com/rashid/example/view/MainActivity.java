package com.rashid.example.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.rashid.example.R;
import com.rashid.example.contract.MainActivityContract;
import com.rashid.example.model.Comments;
import com.rashid.example.presenter.MainActivityPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.test.espresso.core.internal.deps.guava.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private MainActivityContract.Presenter mPresenter;
    public static ArrayList<Comments> itemsData = new ArrayList<>();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    MainActivityPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mMainPresenter = new MainActivityPresenter(this, getApplicationContext());

        if(!itemsData.contains(new Comments("Comments 1", 1)))
        itemsData.add(new Comments("Comments 1", 1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.showDataList(recyclerView);
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
