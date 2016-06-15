package com.codezjx.dribbbledroid.ui;

/**
 * Created by codezjx on 2016/6/14.<br/>
 * Base view object in "MVP" pattern
 */
public interface BaseView<T> {

    /**
     * Set presenter for this view object
     */
    void setPresenter(T presenter);

}
