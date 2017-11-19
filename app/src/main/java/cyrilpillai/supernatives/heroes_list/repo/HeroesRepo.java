package cyrilpillai.supernatives.heroes_list.repo;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * Created by cyrilpillai on 19-11-2017.
 */

public class HeroesRepo {
    private Box<SuperHero> superHeroBox;

    @Inject
    public HeroesRepo(BoxStore boxStore) {
        superHeroBox = boxStore.boxFor(SuperHero.class);
    }

    public long save(SuperHero superHero) {
        return superHeroBox.put(superHero);
    }

    public void saveAll(List<SuperHero> superHeroes) {
        superHeroBox.put(superHeroes);
    }

    public List<SuperHero> getAll() {
        return superHeroBox.getAll();
    }
}
