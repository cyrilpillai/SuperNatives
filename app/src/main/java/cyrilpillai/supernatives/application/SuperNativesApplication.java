package cyrilpillai.supernatives.application;


import android.app.Activity;
import android.app.Application;

import com.facebook.stetho.Stetho;
import javax.inject.Inject;

import cyrilpillai.supernatives.BuildConfig;
import cyrilpillai.supernatives.application.di.DaggerAppComponent;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class SuperNativesApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
