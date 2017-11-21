package cyrilpillai.supernatives.hero_details.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.hero_details.contract.HeroDetailsContract;
import cyrilpillai.supernatives.hero_details.entity.PowerStats;
import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.hero_details.view.adapter.PowerStatDelegate;
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
                List<Object> detailsView = new ArrayList<>();

                detailsView.addAll(formatPowerStats(response.getPowerStats()));

                view.setSuperHeroDetailsView(detailsView);
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

    private List<PowerStatDelegate.PowerStat> formatPowerStats(PowerStats powerStats) {
        List<PowerStatDelegate.PowerStat> powerStatList = new ArrayList<>();
        powerStatList.add(new PowerStatDelegate.PowerStat("Intelligence",
                Integer.parseInt(powerStats.getIntelligence()), R.color.cyan));
        powerStatList.add(new PowerStatDelegate.PowerStat("Strength",
                Integer.parseInt(powerStats.getStrength()), R.color.red));
        powerStatList.add(new PowerStatDelegate.PowerStat("Speed",
                Integer.parseInt(powerStats.getSpeed()), R.color.teal));
        powerStatList.add(new PowerStatDelegate.PowerStat("Durability",
                Integer.parseInt(powerStats.getDurability()), R.color.brown));
        powerStatList.add(new PowerStatDelegate.PowerStat("Power",
                Integer.parseInt(powerStats.getPower()), R.color.blue_grey));
        powerStatList.add(new PowerStatDelegate.PowerStat("Combat",
                Integer.parseInt(powerStats.getCombat()), R.color.green));
        return powerStatList;
    }
}
