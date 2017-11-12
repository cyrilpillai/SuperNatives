package cyrilpillai.supernatives.hero_details.contract;

import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class HeroDetailsContract {
    public interface Model {
        void fetchSuperHeroDetails(long characterId, DataCallback<SuperHeroDetails, Throwable> dataCallback);
    }

    public interface View {
        void setSuperHeroDetailsView(SuperHeroDetails superHeroDetails);

        void loadingView(boolean isLoading);

        void superHeroDetailsView(boolean show);

        void errorView(boolean show);
    }

    public interface Presenter {
        void getSuperHeroDetails(long characterId);
    }
}
