package cyrilpillai.supernatives.heroes_list.presenter;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.heroes_list.contract.HeroesListContract;
import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;

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
        view.superHeroesView(false);
        view.errorView(false);
        model.fetchSuperHeroes(new DataCallback<List<SuperHero>, Throwable>() {
            @Override
            public void onSuccess(List<SuperHero> response) {
                view.setSuperHeroes(response);
                view.superHeroesView(true);
                view.errorView(false);
                view.loadingView(false);
            }

            @Override
            public void onError(Throwable error) {
                view.errorView(true);
                view.superHeroesView(false);
                view.loadingView(false);
            }
        });
    }

    @Override
    public void onSuperHeroClicked(int position) {
        SuperHero superHero = model.getSuperHeroAtPosition(position);
        if (superHero != null) {
            view.showDetailsView(superHero);
        }
    }
}
