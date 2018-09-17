package pl.android.akac.rxrest.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TrampolineTransformer @Inject constructor() : Transformer{
    override val observeOnScheduler: Scheduler = Schedulers.trampoline()
    override val subscribeOnScheduler: Scheduler = Schedulers.trampoline()
}