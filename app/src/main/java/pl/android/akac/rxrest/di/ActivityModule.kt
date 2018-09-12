package pl.android.akac.rxrest.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.android.akac.rxrest.MainActivity

/**
 * Created by akac on 12/09/2018.
 */

@Module
interface ActivityModule {

    @ContributesAndroidInjector()
    fun bindMainActivity(): MainActivity

}