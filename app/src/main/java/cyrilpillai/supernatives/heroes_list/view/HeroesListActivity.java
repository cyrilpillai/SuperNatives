package cyrilpillai.supernatives.heroes_list.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.ActivityHeroesListBinding;
import cyrilpillai.supernatives.hero_details.view.HeroDetailsActivity;
import cyrilpillai.supernatives.heroes_list.contract.HeroesListContract;
import cyrilpillai.supernatives.heroes_list.entity.SuperHero;
import dagger.android.AndroidInjection;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesListActivity extends AppCompatActivity implements HeroesListContract.View {

    private ActivityHeroesListBinding binding;
    private Context context;

    @Inject
    HeroesListContract.Presenter presenter;

    @Inject
    HeroesAdapter heroesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_heroes_list);
        context = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,
                linearLayoutManager.getOrientation());
        binding.rvHeroes.setLayoutManager(linearLayoutManager);
        binding.rvHeroes.addItemDecoration(dividerItemDecoration);
        binding.rvHeroes.setAdapter(heroesAdapter);
        binding.fastScroll.setRecyclerView(binding.rvHeroes);

        heroesAdapter.setOnClickListener(position -> presenter.onSuperHeroClicked(position));

        binding.btnTryAgain.setOnClickListener(v -> presenter.getSuperHeroes());

        binding.btnTryAgain.performClick();
    }

    @Override
    public void setSuperHeroes(List<SuperHero> superHeroes) {
        heroesAdapter.setData(superHeroes);
    }

    @Override
    public void loadingView(boolean isLoading) {
        binding.pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void superHeroesView(boolean show) {
        binding.rvHeroes.setVisibility(show ? View.VISIBLE : View.GONE);
        binding.fastScroll.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void errorView(boolean show) {
        binding.llErrorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showDetailsView(long characterId) {
        HeroDetailsActivity.start(context, characterId);
    }
}
