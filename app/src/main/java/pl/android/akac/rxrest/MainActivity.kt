package pl.android.akac.rxrest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import pl.android.akac.rxrest.rest.RxRestService
import pl.android.akac.rxrest.rx.IOTransformer
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var transformer: IOTransformer

    @Inject
    lateinit var rxRest: RxRestService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        rxRest.getHello()
                .compose(transformer.completable())
                .subscribeBy(
                        onComplete = { result.setText("Success") },
                        onError = { result.setText("Error! " + it.localizedMessage) }
                )

        rxRest.getHello2()
                .compose(transformer.single())
                .subscribeBy(
                        onSuccess = { result.setText("Success!" + it.content) },
                        onError = { result.setText("Error! " + it.localizedMessage) }
                )
    }


}
