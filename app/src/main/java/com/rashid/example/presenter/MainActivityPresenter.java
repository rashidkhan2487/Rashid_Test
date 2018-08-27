package com.rashid.example.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rashid.example.adapter.MyAdapter;
import com.rashid.example.contract.MainActivityContract;

import static android.support.test.espresso.core.internal.deps.guava.base.Preconditions.checkNotNull;
import static com.rashid.example.view.MainActivity.itemsData;



public class MainActivityPresenter implements MainActivityContract.Presenter {
    private final MainActivityContract.View mTasksView;
    private Context mContext;




    public MainActivityPresenter(@NonNull MainActivityContract.View tasksView, Context context) {
        mTasksView = checkNotNull(tasksView, "tasksView cannot be null!");
        mContext = context;
        mTasksView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void showDataList(RecyclerView recyclerView) {


        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
    }
}
