package cyrilpillai.supernatives.application.di;

import android.app.Application;

import javax.inject.Singleton;

import cyrilpillai.supernatives.application.SuperNativesApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(SuperNativesApplication superNativesApplication);

}