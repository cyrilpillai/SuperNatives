package cyrilpillai.supernatives.hero_details.repo;

import javax.inject.Inject;

import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails_;
import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * Created by cyrilpillai on 19-11-2017.
 */

public class HeroDetailsRepo {
    private Box<SuperHeroDetails> superHeroDetailsBox;

    @Inject
    public HeroDetailsRepo(BoxStore boxStore) {
        superHeroDetailsBox = boxStore.boxFor(SuperHeroDetails.class);
    }

    public long save(SuperHeroDetails superHeroDetails) {
        superHeroDetails.getPowerStatsToOne().setTarget(superHeroDetails.getPowerStats());
        superHeroDetails.getBiographyToOne().setTarget(superHeroDetails.getBiography());
        superHeroDetails.getAppearanceToOne().setTarget(superHeroDetails.getAppearance());
        superHeroDetails.getWorkToOne().setTarget(superHeroDetails.getWork());
        superHeroDetails.getConnectionsToOne().setTarget(superHeroDetails.getConnections());
        superHeroDetails.getImageToOne().setTarget(superHeroDetails.getImage());
        return superHeroDetailsBox.put(superHeroDetails);
    }

    public SuperHeroDetails fetchById(long id) {
        SuperHeroDetails superHeroDetails = superHeroDetailsBox.query()
                .equal(SuperHeroDetails_.id, id).build().findFirst();
        if (superHeroDetails != null) {
            superHeroDetails.setPowerStats(superHeroDetails.getPowerStatsToOne().getTarget());
            superHeroDetails.setBiography(superHeroDetails.getBiographyToOne().getTarget());
            superHeroDetails.setAppearance(superHeroDetails.getAppearanceToOne().getTarget());
            superHeroDetails.setWork(superHeroDetails.getWorkToOne().getTarget());
            superHeroDetails.setConnections(superHeroDetails.getConnectionsToOne().getTarget());
            superHeroDetails.setImage(superHeroDetails.getImageToOne().getTarget());
        }
        return superHeroDetails;
    }
}
