package cyrilpillai.supernatives.heroes_list.contract;

import java.util.List;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListContract {
    public interface Model {
        void fetchSuperHeroes(DataCallback<List<SuperHero>, Throwable> dataCallback);

        SuperHero getSuperHeroAtPosition(int position);
    }

    public interface View {
        void setSuperHeroes(List<SuperHero> superHeroes);

        void superHeroesView(boolean show);

        void loadingView(boolean isLoading);

        void errorView(boolean show);

        void showDetailsView(SuperHero superHero);
    }

    public interface Presenter {
        void getSuperHeroes();

        void onSuperHeroClicked(int position);
    }
}
