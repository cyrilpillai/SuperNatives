package cyrilpillai.supernatives.hero_details.di;

import android.content.Context;

import cyrilpillai.supernatives.hero_details.contract.HeroDetailsContract;
import cyrilpillai.supernatives.hero_details.model.HeroDetailsModel;
import cyrilpillai.supernatives.hero_details.presenter.HeroDetailsPresenter;
import cyrilpillai.supernatives.hero_details.repo.HeroDetailsRepo;
import cyrilpillai.supernatives.hero_details.view.HeroDetailsActivity;
import cyrilpillai.supernatives.hero_details.view.adapter.HeroDetailsAdapter;
import cyrilpillai.supernatives.utils.network.ApiService;
import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

@Module
public class HeroDetailsModule {

    @Provides
    HeroDetailsContract.Model providesHeroDetailsModel(ApiService apiService,
                                                       HeroDetailsRepo heroDetailsRepo) {
        return new HeroDetailsModel(apiService, heroDetailsRepo);
    }

    @Provides
    HeroDetailsContract.View provideHeroDetailsView(HeroDetailsActivity heroDetailsActivity) {
        return heroDetailsActivity;
    }

    @Provides
    HeroDetailsContract.Presenter providesHeroDetailsPresenter(HeroDetailsContract.View view,
                                                               HeroDetailsContract.Model model) {
        return new HeroDetailsPresenter(view, model);
    }

    @Provides
    HeroDetailsRepo providesHeroDetailsRepo(BoxStore boxStore) {
        return new HeroDetailsRepo(boxStore);
    }

    @Provides
    HeroDetailsAdapter providesHeroDetailsAdapter(Context context) {
        return new HeroDetailsAdapter(context);
    }

}