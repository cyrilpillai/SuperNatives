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
import cyrilpillai.supernatives.databinding.RvPowerStatProgressBinding;

/**
 * Created by cyrilpillai on 21-11-2017.
 */

public class PowerStatDelegate extends AbsListItemAdapterDelegate<PowerStatDelegate.PowerStat,
        Object, PowerStatDelegate.PowerStatViewHolder> {

    private Context context;

    public PowerStatDelegate() {
    }

    @Override
    public boolean isForViewType(@NonNull Object item, @NonNull List<Object> items, int position) {
        return item instanceof PowerStat;
    }

    @NonNull
    @Override
    public PowerStatViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        context = parent.getContext();
        RvPowerStatProgressBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.rv_power_stat_progress, parent, false);
        return new PowerStatViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PowerStat item, @NonNull PowerStatViewHolder vh,
                                 @Nullable List<Object> payloads) {
        vh.binding.tvStatTitle.setText(item.getPowerTitle());
        vh.binding.pbStat.setProgress(item.getPowerPercent());

        int resolvedColor = ContextCompat.getColor(context, item.getColor());
        vh.binding.tvStatTitle.setTextColor(resolvedColor);
        vh.binding.pbStat.getProgressDrawable().setColorFilter(resolvedColor,
                android.graphics.PorterDuff.Mode.SRC_IN);
    }

    static class PowerStatViewHolder extends RecyclerView.ViewHolder {
        private RvPowerStatProgressBinding binding;

        public PowerStatViewHolder(RvPowerStatProgressBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class PowerStat {
        private String powerTitle;
        private int powerPercent;
        @ColorRes
        private int color;

        public PowerStat(String powerTitle, int powerPercent, int color) {
            this.powerTitle = powerTitle;
            this.powerPercent = powerPercent;
            this.color = color;
        }

        public String getPowerTitle() {
            return powerTitle;
        }

        public void setPowerTitle(String powerTitle) {
            this.powerTitle = powerTitle;
        }

        public int getPowerPercent() {
            return powerPercent;
        }

        public void setPowerPercent(int powerPercent) {
            this.powerPercent = powerPercent;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "PowerStat{" +
                    "powerTitle='" + powerTitle + '\'' +
                    ", powerPercent=" + powerPercent +
                    ", color=" + color +
                    '}';
        }
    }
}
