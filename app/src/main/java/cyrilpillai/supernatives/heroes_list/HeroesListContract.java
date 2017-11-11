package cyrilpillai.supernatives.heroes_list;

import java.util.List;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.utils.callbacks.NetworkCallback;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListContract {
    interface Model {
        void fetchSuperHeroes(NetworkCallback<List<SuperHero>, Throwable> networkCallback);
    }

    interface View {
        void showSuperHeroes(List<SuperHero> superHeroes);

        void loadingView(boolean isLoading);

        void errorView(String error);
    }

    interface Presenter {
        void getSuperHeroes();

        void onSuperHeroClicked(int position);
    }
}
