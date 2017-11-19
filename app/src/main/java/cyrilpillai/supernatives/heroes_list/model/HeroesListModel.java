package cyrilpillai.supernatives.heroes_list.model;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.heroes_list.contract.HeroesListContract;
import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.heroes_list.repo.HeroesRepo;
import cyrilpillai.supernatives.utils.Constants;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;
import cyrilpillai.supernatives.utils.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListModel implements HeroesListContract.Model {

    private ApiService apiService;
    private HeroesRepo heroesRepo;

    @Inject
    public HeroesListModel(ApiService apiService, HeroesRepo heroesRepo) {
        this.apiService = apiService;
        this.heroesRepo = heroesRepo;
    }


    @Override
    public void fetchSuperHeroes(DataCallback<List<SuperHero>, Throwable> dataCallback) {
        List<SuperHero> superHeroes = heroesRepo.getAll();
        if (superHeroes != null && superHeroes.size() > 0) {
            Log.d("Heroes", "fetchSuperHeroes: from Local Cache");
            dataCallback.onSuccess(superHeroes);
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
                        heroesRepo.saveAll(superHeroes);
                        dataCallback.onSuccess(superHeroes);
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
    public SuperHero getSuperHeroAtPosition(int position) {
        List<SuperHero> superHeroes = heroesRepo.getAll();
        return superHeroes != null ? superHeroes.get(position) : null;
    }
}
