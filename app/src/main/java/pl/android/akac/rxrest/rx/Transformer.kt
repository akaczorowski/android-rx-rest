package pl.android.akac.rxrest.rx

import io.reactivex.CompletableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer

interface Transformer {

    val observeOnScheduler: Scheduler
    val subscribeOnScheduler: Scheduler

    fun completable(): CompletableTransformer = CompletableTransformer {
        it.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler)
    }

    fun <D> single(): SingleTransformer<D, D> = SingleTransformer {
        it.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler)
    }

    fun <D> observable(): ObservableTransformer<D, D> = ObservableTransformer {
        it.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler)
    }


}