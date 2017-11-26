package cyrilpillai.supernatives.hero_details.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;
import com.squareup.picasso.Picasso;

import java.util.List;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.RvHeroDetailImageItemBinding;

/**
 * Created by cyrilpillai on 26-11-2017.
 */

public class ImageDelegate extends AbsListItemAdapterDelegate<ImageDelegate.ImageItem,
        Object, ImageDelegate.ImageItemViewHolder> {

    private Context context;
    private Drawable loadingDrawable, errorDrawable;

    public ImageDelegate(Context context) {
        this.context = context;
        loadingDrawable = AppCompatResources.getDrawable(context, R.drawable.ic_launcher_background);
        errorDrawable = AppCompatResources.getDrawable(context, R.drawable.error_image);
    }

    @Override
    public boolean isForViewType(@NonNull Object item, @NonNull List<Object> items, int position) {
        return item instanceof ImageItem;
    }

    @NonNull
    @Override
    public ImageItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        context = parent.getContext();
        RvHeroDetailImageItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.rv_hero_detail_image_item, parent, false);
        return new ImageItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageItem item, @NonNull ImageItemViewHolder vh,
                                 @Nullable List<Object> payloads) {
        Picasso.with(context)
                .load(item.getUrl())
                .placeholder(loadingDrawable)
                .error(errorDrawable)
                .into(vh.binding.ivHeroImage);
    }

    static class ImageItemViewHolder extends RecyclerView.ViewHolder {
        private RvHeroDetailImageItemBinding binding;

        public ImageItemViewHolder(RvHeroDetailImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class ImageItem {
        private String url;

        public ImageItem(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ImageItem{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }
}
