package cyrilpillai.supernatives.hero_details.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.RvHeroDetailHeaderItemBinding;
import cyrilpillai.supernatives.databinding.RvHeroDetailInfoItemBinding;

/**
 * Created by cyrilpillai on 26-11-2017.
 */

public class InfoDelegate extends AbsListItemAdapterDelegate<InfoDelegate.InfoItem,
        Object, InfoDelegate.InfoItemViewHolder> {

    private Context context;

    public InfoDelegate() {
    }

    @Override
    public boolean isForViewType(@NonNull Object item, @NonNull List<Object> items, int position) {
        return item instanceof InfoItem;
    }

    @NonNull
    @Override
    public InfoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        context = parent.getContext();
        RvHeroDetailInfoItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.rv_hero_detail_info_item, parent, false);
        return new InfoItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoItem item, @NonNull InfoItemViewHolder vh,
                                 @Nullable List<Object> payloads) {
        vh.binding.tvTitle.setText(item.getTitle());
        vh.binding.tvDescription.setText(item.getDescription());

    }

    static class InfoItemViewHolder extends RecyclerView.ViewHolder {
        private RvHeroDetailInfoItemBinding binding;

        public InfoItemViewHolder(RvHeroDetailInfoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class InfoItem {
        private String title;
        private String description;

        public InfoItem(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "HeaderItem{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }

        public void setDescription(String description) {
            this.description = description;


        }
    }
}
