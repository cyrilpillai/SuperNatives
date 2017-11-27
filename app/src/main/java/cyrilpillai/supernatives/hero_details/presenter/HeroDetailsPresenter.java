package cyrilpillai.supernatives.hero_details.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.hero_details.contract.HeroDetailsContract;
import cyrilpillai.supernatives.hero_details.entity.Appearance;
import cyrilpillai.supernatives.hero_details.entity.Biography;
import cyrilpillai.supernatives.hero_details.entity.Connections;
import cyrilpillai.supernatives.hero_details.entity.PowerStats;
import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.hero_details.entity.Work;
import cyrilpillai.supernatives.hero_details.view.adapter.HeaderDelegate;
import cyrilpillai.supernatives.hero_details.view.adapter.ImageDelegate;
import cyrilpillai.supernatives.hero_details.view.adapter.InfoDelegate;
import cyrilpillai.supernatives.hero_details.view.adapter.PowerStatDelegate;
import cyrilpillai.supernatives.utils.adapter.delegate.HorizontalDividerDelegate;
import cyrilpillai.supernatives.utils.adapter.delegate.ShadowDelegate;
import cyrilpillai.supernatives.utils.adapter.delegate.SpaceDelegate;
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

                detailsView.add(new ImageDelegate.ImageItem(response.getImage().getUrl()));
                detailsView.add(new ShadowDelegate.ShadowItem());
                detailsView.add(new SpaceDelegate.SpaceItem(20));

                detailsView.add(new HeaderDelegate.HeaderItem("Powerstats"));
                detailsView.addAll(formatPowerStats(response.getPowerStats()));
                detailsView.add(new ShadowDelegate.ShadowItem());
                detailsView.add(new SpaceDelegate.SpaceItem(20));

                detailsView.add(new HeaderDelegate.HeaderItem("Biography"));
                detailsView.addAll(formatBiography(response.getBiography()));
                detailsView.add(new ShadowDelegate.ShadowItem());
                detailsView.add(new SpaceDelegate.SpaceItem(20));

                detailsView.add(new HeaderDelegate.HeaderItem("Appearance"));
                detailsView.addAll(formatAppearance(response.getAppearance()));
                detailsView.add(new ShadowDelegate.ShadowItem());
                detailsView.add(new SpaceDelegate.SpaceItem(20));

                detailsView.add(new HeaderDelegate.HeaderItem("Work"));
                detailsView.addAll(formatWork(response.getWork()));
                detailsView.add(new ShadowDelegate.ShadowItem());
                detailsView.add(new SpaceDelegate.SpaceItem(20));

                detailsView.add(new HeaderDelegate.HeaderItem("Connections"));
                detailsView.addAll(formatConnections(response.getConnections()));
                detailsView.add(new ShadowDelegate.ShadowItem());
                detailsView.add(new SpaceDelegate.SpaceItem(30));

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

    private List<Object> formatBiography(Biography biography) {
        List<Object> biographyList = new ArrayList<>();
        biographyList.add(new InfoDelegate.InfoItem("Full Name", biography.getFullName()));
        biographyList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        biographyList.add(new InfoDelegate.InfoItem("Alter Egos", biography.getAlterEgos()));
        biographyList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        biographyList.add(new InfoDelegate.InfoItem("Aliases", biography.getAliases()
                .toString().replaceAll("\\[|]", "")));
        biographyList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        biographyList.add(new InfoDelegate.InfoItem("Place of birth",
                biography.getPlaceOfBirth()));
        biographyList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        biographyList.add(new InfoDelegate.InfoItem("First Appearance",
                biography.getFirstAppearance()));
        biographyList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        biographyList.add(new InfoDelegate.InfoItem("Publisher", biography.getPublisher()));
        biographyList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        biographyList.add(new InfoDelegate.InfoItem("Alignment", biography.getAlignment()));
        return biographyList;
    }

    private List<Object> formatAppearance(Appearance appearance) {
        List<Object> appearanceList = new ArrayList<>();
        appearanceList.add(new InfoDelegate.InfoItem("Gender", appearance.getGender()));
        appearanceList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        appearanceList.add(new InfoDelegate.InfoItem("Race", appearance.getRace()));
        appearanceList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        appearanceList.add(new InfoDelegate.InfoItem("Height", appearance.getHeight()
                .toString().replaceAll("\\[|]", "")));
        appearanceList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        appearanceList.add(new InfoDelegate.InfoItem("Weight", appearance.getWeight()
                .toString().replaceAll("\\[|]", "")));
        appearanceList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        appearanceList.add(new InfoDelegate.InfoItem("Eye color", appearance.getEyeColor()));
        appearanceList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        appearanceList.add(new InfoDelegate.InfoItem("Hair color", appearance.getHairColor()));
        return appearanceList;
    }

    private List<Object> formatWork(Work work) {
        List<Object> workList = new ArrayList<>();
        workList.add(new InfoDelegate.InfoItem("Occupation", work.getOccupation()));
        workList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        workList.add(new InfoDelegate.InfoItem("Base", work.getBase()));
        return workList;
    }

    private List<Object> formatConnections(Connections connections) {
        List<Object> connectionList = new ArrayList<>();
        connectionList.add(new InfoDelegate.InfoItem("Team Affiliation",
                connections.getGroupAffiliation()));
        connectionList.add(new HorizontalDividerDelegate.HorizontalDividerItem());
        connectionList.add(new InfoDelegate.InfoItem("Relatives", connections.getRelatives()
                .replaceAll(";", ",")));
        return connectionList;
    }

    private List<PowerStatDelegate.PowerStat> formatPowerStats(PowerStats powerStats) {
        List<PowerStatDelegate.PowerStat> powerStatList = new ArrayList<>();
        powerStatList.add(new PowerStatDelegate.PowerStat("Intelligence",
                getInteger(powerStats.getIntelligence()), R.color.cyan));
        powerStatList.add(new PowerStatDelegate.PowerStat("Strength",
                getInteger(powerStats.getStrength()), R.color.red));
        powerStatList.add(new PowerStatDelegate.PowerStat("Speed",
                getInteger(powerStats.getSpeed()), R.color.teal));
        powerStatList.add(new PowerStatDelegate.PowerStat("Durability",
                getInteger(powerStats.getDurability()), R.color.brown));
        powerStatList.add(new PowerStatDelegate.PowerStat("Power",
                getInteger(powerStats.getPower()), R.color.blue_grey));
        powerStatList.add(new PowerStatDelegate.PowerStat("Combat",
                getInteger(powerStats.getCombat()), R.color.green));
        return powerStatList;
    }

    private int getInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
