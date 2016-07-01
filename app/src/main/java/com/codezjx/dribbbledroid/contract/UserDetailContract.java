package com.codezjx.dribbbledroid.contract;

import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.model.User;
import com.codezjx.dribbbledroid.presenter.BasePresenter;
import com.codezjx.dribbbledroid.ui.BaseView;

import java.util.List;

/**
 * Created by codezjx on 2016/7/1.<br/>
 */
public interface UserDetailContract {

    interface View extends BaseView<Presenter> {

        void showUserDetail(User user);

        void showUserShots(List<Shot> shots);

        void showError(String errorMsg);
    }

    interface Presenter extends BasePresenter {

        void loadUserShots(String userId);

    }
}
