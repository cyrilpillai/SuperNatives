package cyrilpillai.supernatives.utils.network;


import java.util.List;

import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public interface ApiService {
    @GET()
    Call<List<SuperHero>> getSuperHeroes(@Url String url);

    @GET("{character_id}")
    Call<SuperHeroDetails> getSuperHeroDetails(@Path("character_id") long id);
}
