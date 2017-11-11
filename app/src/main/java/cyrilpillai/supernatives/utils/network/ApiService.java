package cyrilpillai.supernatives.utils.network;


import java.util.List;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public interface ApiService {
    @GET()
    Call<List<SuperHero>> getSuperHeroes(@Url String url);
}
