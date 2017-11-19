package cyrilpillai.supernatives.hero_details.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import javax.inject.Inject;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.ActivityHeroDetailsBinding;
import cyrilpillai.supernatives.hero_details.contract.HeroDetailsContract;
import cyrilpillai.supernatives.hero_details.entity.SuperHeroDetails;
import cyrilpillai.supernatives.utils.Constants;
import dagger.android.AndroidInjection;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class HeroDetailsActivity extends AppCompatActivity implements HeroDetailsContract.View {

    private ActivityHeroDetailsBinding binding;
    private Context context;
    private long characterId;

    @Inject
    HeroDetailsContract.Presenter presenter;

    public static void start(Context context, long characterId) {
        Intent intent = new Intent(context, HeroDetailsActivity.class);
        intent.putExtra(Constants.SUPERHERO_ID, characterId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hero_details);
        context = this;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        characterId = getIntent().getLongExtra(Constants.SUPERHERO_ID, -1);

        binding.rvHeroDetails.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false));
        //binding.rvHeroDetails.setAdapter(heroesAdapter);

        binding.btnTryAgain.setOnClickListener(v -> presenter.getSuperHeroDetails(characterId));

        binding.btnTryAgain.performClick();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setSuperHeroDetailsView(SuperHeroDetails superHeroDetails) {
        Log.d("Heroes", "setSuperHeroDetailsView: " + superHeroDetails.toString());
    }

    @Override
    public void loadingView(boolean isLoading) {
        binding.pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void superHeroDetailsView(boolean show) {
        binding.rvHeroDetails.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void errorView(boolean show) {
        binding.llErrorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
