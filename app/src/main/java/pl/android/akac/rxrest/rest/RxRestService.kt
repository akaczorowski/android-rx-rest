package pl.android.akac.rxrest.rest

import io.reactivex.Completable
import retrofit2.http.GET

/**
 * Created by akac on 10/09/2018.
 */

interface RxRestService{

    @GET("greeting/hello")
    fun getHello(): Completable
}