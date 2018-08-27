package com.rashid.example.contract;

import android.support.v7.widget.RecyclerView;
import com.rashid.example.presenter.BasePresenter;
import com.rashid.example.presenter.BaseView;


public interface MainActivityContract {
     interface View extends BaseView<Presenter> {

    }

     interface Presenter extends BasePresenter {
        void showDataList(RecyclerView recyclerView);
    }
    }
