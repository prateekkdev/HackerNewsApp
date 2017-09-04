package com.prateek.hackernewsapp.network;

import com.prateek.hackernewsapp.network.dto.SearchResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by prateek.kesarwani on 18/07/17.
 */

public interface RetrofitService {

    String SERVICE_ENDPOINT = "http://hn.algolia.com/";

    @GET("/api/v1/search")
    Observable<SearchResult> listResults(@Query("query") String keyword,
                                         @Query("page") int page);
}