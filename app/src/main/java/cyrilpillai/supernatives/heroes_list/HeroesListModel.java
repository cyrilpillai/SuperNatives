package cyrilpillai.supernatives.heroes_list;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.utils.Constants;
import cyrilpillai.supernatives.utils.network.ApiService;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListModel implements HeroesListContract.Model {

    private ApiService apiService;

    private List<SuperHero> superHeroesCache;

    @Inject
    public HeroesListModel(ApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public void fetchSuperHeroes(DataCallback<List<SuperHero>, Throwable> dataCallback) {
        if (superHeroesCache != null) {
            dataCallback.onSuccess(superHeroesCache);
            Log.d("Heroes", "fetchSuperHeroes: from In-memory Cache");
        } else {
            Log.d("Heroes", "fetchSuperHeroes: from Network");
            Call<List<SuperHero>> call = apiService.getSuperHeroes(Constants.SUPERHEROES_LIST_URL);
            call.enqueue(new Callback<List<SuperHero>>() {
                @Override
                public void onResponse(
                        @NonNull Call<List<SuperHero>> call,
                        @NonNull Response<List<SuperHero>> response) {
                    List<SuperHero> superHeroes = response.body();
                    if (response.isSuccessful() &&
                            superHeroes != null) {
                        superHeroesCache = superHeroes;
                        dataCallback.onSuccess(superHeroesCache);
                    } else {
                        dataCallback.onError(new Throwable("Error"));

                    }
                }

                @Override
                public void onFailure(
                        @NonNull Call<List<SuperHero>> call,
                        @NonNull Throwable t) {
                    dataCallback.onError(t);
                }
            });
        }
    }

    @Override
    public SuperHero getHeroAtPosition(int position) {
        return superHeroesCache != null ? superHeroesCache.get(position) : null;
    }
}
