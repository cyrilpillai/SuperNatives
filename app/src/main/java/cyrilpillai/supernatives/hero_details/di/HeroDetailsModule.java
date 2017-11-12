package cyrilpillai.supernatives.hero_details.di;

import cyrilpillai.supernatives.hero_details.view.HeroDetailsActivity;
import cyrilpillai.supernatives.hero_details.contract.HeroDetailsContract;
import cyrilpillai.supernatives.hero_details.model.HeroDetailsModel;
import cyrilpillai.supernatives.hero_details.presenter.HeroDetailsPresenter;
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
    HeroDetailsContract.Model providesHeroDetailsModel(ApiService apiService, BoxStore boxStore) {
        return new HeroDetailsModel(apiService, boxStore);
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
}