package cyrilpillai.supernatives.hero_details.model;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import cyrilpillai.supernatives.hero_details.contract.HeroDetailsContract;
import cyrilpillai.supernatives.hero_details.entity.Appearance;
import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails_;
import cyrilpillai.supernatives.hero_details.repo.HeroDetailsRepo;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;
import cyrilpillai.supernatives.utils.network.ApiService;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class HeroDetailsModel implements HeroDetailsContract.Model {

    private ApiService apiService;
    private HeroDetailsRepo heroDetailsRepo;

    @Inject
    public HeroDetailsModel(ApiService apiService, HeroDetailsRepo heroDetailsRepo) {
        this.apiService = apiService;
        this.heroDetailsRepo = heroDetailsRepo;
    }


    @Override
    public void fetchSuperHeroDetails(long characterId,
                                      DataCallback<SuperHeroDetails, Throwable> dataCallback) {
        SuperHeroDetails superHeroDetails = heroDetailsRepo.fetchById(characterId);
        if (superHeroDetails != null) {
            Log.d("Heroes", "fetchSuperHeroDetails: from Local Cache");
            dataCallback.onSuccess(superHeroDetails);
        } else {
            Log.d("Heroes", "fetchSuperHeroDetails: from Network");
            Call<SuperHeroDetails> call = apiService
                    .getSuperHeroDetails(characterId);
            call.enqueue(new Callback<SuperHeroDetails>() {
                @Override
                public void onResponse(
                        @NonNull Call<SuperHeroDetails> call,
                        @NonNull Response<SuperHeroDetails> response) {
                    SuperHeroDetails details = response.body();
                    if (response.isSuccessful() &&
                            details != null) {
                        Log.d("Heroes", "onResponse: " + details.toString());
                        long id = heroDetailsRepo.save(details);
                        SuperHeroDetails s = heroDetailsRepo.fetchById(id);
                        Log.d("Heroes", "After saving: " + s.toString());
                        dataCallback.onSuccess(s);
                    } else {
                        dataCallback.onError(new Throwable("Error"));

                    }
                }

                @Override
                public void onFailure(
                        @NonNull Call<SuperHeroDetails> call,
                        @NonNull Throwable t) {
                    dataCallback.onError(t);
                }
            });
        }
    }
}
