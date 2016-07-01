package com.codezjx.dribbbledroid.network;

import com.codezjx.dribbbledroid.model.Comment;
import com.codezjx.dribbbledroid.model.Shot;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by codezjx on 2016/6/13.<br/>
 * Definition for all dribbble api.
 */
public interface DribbbleApi {

    String BASE_URL = "https://api.dribbble.com/v1/";
    int PER_PAGE_SIZE = 20;

    @GET("shots")
    Observable<List<Shot>> getShotList(@Query("list") String list,
                                       @Query("timeframe") String timeframe,
                                       @Query("sort") String sort,
                                       @Query("page") int page,
                                       @Query("per_page") int pageSize);
    @GET("shots/{id}")
    Observable<Shot> getShot(@Path("id") String id);

    @GET("shots/{shotId}/comments")
    Observable<List<Comment>> getCommentList(@Path("shotId") String shotId,
                                       @Query("page") int page,
                                       @Query("per_page") int pageSize);

    @GET("users/{userId}/shots")
    Observable<List<Shot>> getUserShots(@Path("userId") String userId,
                                   @Query("page") int page,
                                   @Query("per_page") int pageSize);
}
