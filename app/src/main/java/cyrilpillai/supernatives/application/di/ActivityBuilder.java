package cyrilpillai.supernatives.application.di;


import cyrilpillai.supernatives.heroes_list.HeroesListActivity;
import cyrilpillai.supernatives.heroes_list.HeroesListModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = HeroesListModule.class)
    abstract HeroesListActivity contributeHeroesListActivityInjector();
}