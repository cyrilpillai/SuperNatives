package cyrilpillai.supernatives.hero_details.view.adapter;

import android.content.Context;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.List;

import cyrilpillai.supernatives.utils.adapter.delegate.HorizontalDividerDelegate;
import cyrilpillai.supernatives.utils.adapter.delegate.ShadowDelegate;
import cyrilpillai.supernatives.utils.adapter.delegate.SpaceDelegate;

/**
 * Created by cyrilpillai on 21-11-2017.
 */

public class HeroDetailsAdapter extends ListDelegationAdapter<List<Object>> {

    public HeroDetailsAdapter(Context context) {
        delegatesManager
                .addDelegate(new ShadowDelegate())
                .addDelegate(new HorizontalDividerDelegate())
                .addDelegate(new SpaceDelegate())
                .addDelegate(new ShadowDelegate())
                .addDelegate(new HeaderDelegate())
                .addDelegate(new ImageDelegate(context))
                .addDelegate(new InfoDelegate())
                .addDelegate(new PowerStatDelegate());
    }

    public void setData(List<Object> data) {
        setItems(data);
    }
}
