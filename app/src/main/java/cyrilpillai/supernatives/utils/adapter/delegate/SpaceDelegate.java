package cyrilpillai.supernatives.utils.adapter.delegate;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.RvSpaceItemBinding;


/**
 * Created by cyrilpillai on 26-11-2017.
 */

public class SpaceDelegate extends AbsListItemAdapterDelegate<SpaceDelegate.SpaceItem, Object,
        SpaceDelegate.SpaceHolder> {

    private Context context;

    public SpaceDelegate() {
    }

    @Override
    protected boolean isForViewType(@NonNull Object item, @NonNull List<Object> items,
                                    int position) {
        return item instanceof SpaceItem;
    }

    @NonNull
    @Override
    protected SpaceHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        context = parent.getContext();
        RvSpaceItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.rv_space_item, parent,
                false);
        return new SpaceHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull SpaceItem item, @NonNull SpaceHolder viewHolder,
                                    @NonNull List<Object> payloads) {
        viewHolder.binding.spaceView.getLayoutParams().height = item.getHeight();
        viewHolder.binding.spaceView.setBackgroundColor(
                ContextCompat.getColor(context, item.getBackgroundColor()));
    }

    class SpaceHolder extends RecyclerView.ViewHolder {
        private RvSpaceItemBinding binding;

        SpaceHolder(RvSpaceItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class SpaceItem {
        private int height;
        @ColorRes
        private int backgroundColor;

        public SpaceItem() {
            this(10);
        }

        public SpaceItem(int height) {
            this(height, android.R.color.transparent);
        }

        public SpaceItem(int height, int backgroundColor) {
            this.height = height;
            this.backgroundColor = backgroundColor;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        @Override
        public String toString() {
            return "SpaceItem{" +
                    "height=" + height +
                    ", backgroundColor=" + backgroundColor +
                    '}';
        }
    }

}