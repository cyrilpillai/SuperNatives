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

/**
 * Created by cyrilpillai on 26-11-2017.
 */

public class HeaderDelegate extends AbsListItemAdapterDelegate<HeaderDelegate.HeaderItem,
        Object, HeaderDelegate.HeaderItemViewHolder> {

    private Context context;

    public HeaderDelegate() {
    }

    @Override
    public boolean isForViewType(@NonNull Object item, @NonNull List<Object> items, int position) {
        return item instanceof HeaderItem;
    }

    @NonNull
    @Override
    public HeaderItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        context = parent.getContext();
        RvHeroDetailHeaderItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.rv_hero_detail_header_item, parent, false);
        return new HeaderItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeaderItem item, @NonNull HeaderItemViewHolder vh,
                                 @Nullable List<Object> payloads) {
        vh.binding.tvTitle.setText(item.getTitle());

        int resolvedColor = ContextCompat.getColor(context, item.getColor());
        vh.binding.tvTitle.setTextColor(resolvedColor);
        vh.binding.viewStrip.setBackgroundColor(resolvedColor);

    }

    static class HeaderItemViewHolder extends RecyclerView.ViewHolder {
        private RvHeroDetailHeaderItemBinding binding;

        public HeaderItemViewHolder(RvHeroDetailHeaderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class HeaderItem {
        private String title;
        @ColorRes
        private int color;

        public HeaderItem(String title) {
            this(title, R.color.accent);
        }

        public HeaderItem(String title, int color) {
            this.title = title;
            this.color = color;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "HeaderItem{" +
                    "title='" + title + '\'' +
                    ", color=" + color +
                    '}';
        }
    }
}
