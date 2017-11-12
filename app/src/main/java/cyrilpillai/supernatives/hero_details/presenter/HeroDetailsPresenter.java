package cyrilpillai.supernatives.hero_details.presenter;

import javax.inject.Inject;

import cyrilpillai.supernatives.hero_details.contract.HeroDetailsContract;
import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class HeroDetailsPresenter implements HeroDetailsContract.Presenter {

    private HeroDetailsContract.View view;
    private HeroDetailsContract.Model model;

    @Inject
    public HeroDetailsPresenter(HeroDetailsContract.View view, HeroDetailsContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getSuperHeroDetails(long characterId) {
        view.loadingView(true);
        view.superHeroDetailsView(false);
        view.errorView(false);
        model.fetchSuperHeroDetails(characterId, new DataCallback<SuperHeroDetails, Throwable>() {
            @Override
            public void onSuccess(SuperHeroDetails response) {
                view.setSuperHeroDetailsView(response);
                view.superHeroDetailsView(true);
                view.errorView(false);
                view.loadingView(false);
            }

            @Override
            public void onError(Throwable error) {
                view.errorView(true);
                view.superHeroDetailsView(false);
                view.loadingView(false);
            }
        });
    }
}
