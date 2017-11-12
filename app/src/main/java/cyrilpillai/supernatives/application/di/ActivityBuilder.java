package cyrilpillai.supernatives.application.di;


import cyrilpillai.supernatives.hero_details.view.HeroDetailsActivity;
import cyrilpillai.supernatives.hero_details.di.HeroDetailsModule;
import cyrilpillai.supernatives.heroes_list.view.HeroesListActivity;
import cyrilpillai.supernatives.heroes_list.di.HeroesListModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = HeroesListModule.class)
    abstract HeroesListActivity contributeHeroesListActivityInjector();

    @ContributesAndroidInjector(modules = HeroDetailsModule.class)
    abstract HeroDetailsActivity contributesHeroDetailsActivity();
}