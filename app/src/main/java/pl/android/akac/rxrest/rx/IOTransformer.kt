package pl.android.akac.rxrest.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class IOTransformer @Inject constructor() : Transformer {

    override val observeOnScheduler: Scheduler = AndroidSchedulers.mainThread()
    override val subscribeOnScheduler: Scheduler = Schedulers.io()

}