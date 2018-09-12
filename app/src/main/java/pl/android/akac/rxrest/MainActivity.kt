package pl.android.akac.rxrest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import pl.android.akac.rxrest.rest.RxRestService
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var rxRest: RxRestService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        rxRest.getHello()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onComplete = { result.setText("Success") },
                        onError = { result.setText("Error") }
                )
    }
}
