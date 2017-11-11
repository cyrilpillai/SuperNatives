package cyrilpillai.supernatives.heroes_list;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.ActivityHeroesListBinding;
import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import dagger.android.AndroidInjection;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListActivity extends AppCompatActivity implements HeroesListContract.View {

    public static final String TAG = "HeroesListActivity";

    private ActivityHeroesListBinding binding;

    @Inject
    HeroesListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_heroes_list);
        binding.btnDummy.setOnClickListener(v -> presenter.getSuperHeroes());
    }

    @Override
    public void showSuperHeroes(List<SuperHero> superHeroes) {
        Log.d(TAG, "showSuperHeroes: " + superHeroes.toString());
    }

    @Override
    public void loadingView(boolean isLoading) {
        Log.d(TAG, "loadingView: " + (isLoading ? "show" : "hide"));
    }

    @Override
    public void errorView(String error) {
        Log.d(TAG, "errorView: " + error);
    }
}
