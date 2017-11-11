package cyrilpillai.supernatives.heroes_list;

import cyrilpillai.supernatives.utils.network.ApiService;
import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

@Module
public class HeroesListModule {

    @Provides
    HeroesListContract.Model providesHeroesListModel(ApiService apiService, BoxStore boxStore) {
        return new HeroesListModel(apiService, boxStore);
    }

    @Provides
    HeroesListContract.View provideHeroesListView(HeroesListActivity heroesListActivity) {
        return heroesListActivity;
    }

    @Provides
    HeroesListContract.Presenter providesHeroesListPresenter(HeroesListContract.View view,
                                                             HeroesListContract.Model model) {
        return new HeroesListPresenter(view, model);
    }

    @Provides
    HeroesAdapter provideHeroesListAdapter() {
        return new HeroesAdapter();
    }
}