package pl.android.akac.rxrest.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import pl.android.akac.rxrest.MainApplication
import javax.inject.Singleton

/**
 * Created by akac on 11/09/2018.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityModule::class])
interface MainAppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MainApplication): Builder


        fun build(): MainAppComponent
    }

    fun inject(application: MainApplication)
}