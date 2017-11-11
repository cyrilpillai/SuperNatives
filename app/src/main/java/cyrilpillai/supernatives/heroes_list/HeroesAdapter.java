package cyrilpillai.supernatives.heroes_list;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;

import java.util.ArrayList;
import java.util.List;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.RvHeroItemBinding;
import cyrilpillai.supernatives.heroes_list.entity.SuperHero;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> implements
        SectionTitleProvider {

    private List<SuperHero> data;
    private OnClickListener onClickListener;

    public HeroesAdapter() {
        data = new ArrayList<>();
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RvHeroItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rv_hero_item, parent, false);
        return new HeroViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        SuperHero superHero = data.get(position);
        holder.binding.tvHeroName.setText(superHero.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<SuperHero> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public String getSectionTitle(int position) {
        return (data != null && data.get(position) != null) ?
                data.get(position).getName().substring(0, 1) : "";
    }

    public interface OnClickListener {
        void onItemClicked(int position);
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        private RvHeroItemBinding binding;

        HeroViewHolder(RvHeroItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(v -> {
                if (onClickListener != null) {
                    onClickListener.onItemClicked(getAdapterPosition());
                }
            });
        }
    }
}
