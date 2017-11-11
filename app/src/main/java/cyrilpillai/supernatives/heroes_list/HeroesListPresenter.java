package cyrilpillai.supernatives.heroes_list;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.utils.callbacks.NetworkCallback;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListPresenter implements HeroesListContract.Presenter {

    private HeroesListContract.View view;
    private HeroesListContract.Model model;

    @Inject
    public HeroesListPresenter(HeroesListContract.View view, HeroesListContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getSuperHeroes() {
        view.loadingView(true);
        model.fetchSuperHeroes(new NetworkCallback<List<SuperHero>, Throwable>() {
            @Override
            public void onSuccess(List<SuperHero> response) {
                view.showSuperHeroes(response);
                view.loadingView(false);
            }

            @Override
            public void onError(Throwable error) {
                view.errorView(error.getLocalizedMessage());
                view.loadingView(false);
            }
        });
    }

    @Override
    public void onSuperHeroClicked(int position) {

    }
}
