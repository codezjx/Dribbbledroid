package com.codezjx.dribbbledroid.contract;

import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.presenter.BasePresenter;
import com.codezjx.dribbbledroid.ui.BaseView;

import java.util.List;

/**
 * Created by codezjx on 2016/6/14.<br/>
 * This specifies the contract between the view and the presenter.
 */
public interface ShotsContract {

    interface View extends BaseView<Presenter> {

        void showShots(List<Shot> shots);

        void showError(String errorMsg);

    }

    interface Presenter extends BasePresenter {

        void getShotList(String list, String timeframe, String sort);

    }

}
