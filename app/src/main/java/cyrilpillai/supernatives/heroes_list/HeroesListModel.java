package cyrilpillai.supernatives.heroes_list;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import cyrilpillai.supernatives.utils.Constants;
import cyrilpillai.supernatives.utils.network.ApiService;
import cyrilpillai.supernatives.utils.callbacks.NetworkCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListModel implements HeroesListContract.Model {

    private ApiService apiService;

    @Inject
    public HeroesListModel(ApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public void fetchSuperHeroes(NetworkCallback<List<SuperHero>, Throwable> networkCallback) {
        Call<List<SuperHero>> call = apiService.getSuperHeroes(Constants.SUPERHEROES_LIST_URL);
        call.enqueue(new Callback<List<SuperHero>>() {
            @Override
            public void onResponse(
                    @NonNull Call<List<SuperHero>> call,
                    @NonNull Response<List<SuperHero>> response) {
                Log.d(HeroesListActivity.TAG, "ResponseCode: " + response.code());
                try {
                    Log.d(HeroesListActivity.TAG, "ResponseBody: " + response.errorBody().string());
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }
                List<SuperHero> superHeroes = response.body();
                if (response.isSuccessful() &&
                        superHeroes != null) {
                    networkCallback.onSuccess(superHeroes);
                } else {
                    networkCallback.onError(new Throwable("Error"));

                }
            }

            @Override
            public void onFailure(
                    @NonNull Call<List<SuperHero>> call,
                    @NonNull Throwable t) {
                networkCallback.onError(t);
            }
        });
    }
}
