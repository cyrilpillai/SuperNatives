package cyrilpillai.supernatives.heroes_list;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.utils.Constants;
import cyrilpillai.supernatives.utils.network.ApiService;
import cyrilpillai.supernatives.utils.callbacks.DataCallback;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListModel implements HeroesListContract.Model {

    private ApiService apiService;
    private Box<SuperHero> superHeroBox;

    @Inject
    public HeroesListModel(ApiService apiService, BoxStore boxStore) {
        this.apiService = apiService;
        superHeroBox = boxStore.boxFor(SuperHero.class);
    }


    @Override
    public void fetchSuperHeroes(DataCallback<List<SuperHero>, Throwable> dataCallback) {
        List<SuperHero> superHeroes = superHeroBox.getAll();
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
                        superHeroBox.put(superHeroes);
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
    public SuperHero getHeroAtPosition(int position) {
        List<SuperHero> superHeroes = superHeroBox.getAll();
        return superHeroes != null ? superHeroes.get(position) : null;
    }
}
