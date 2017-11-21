package cyrilpillai.supernatives.hero_details.view.adapter;

import android.content.Context;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.List;

/**
 * Created by cyrilpillai on 21-11-2017.
 */

public class HeroDetailsAdapter extends ListDelegationAdapter<List<Object>> {

    public HeroDetailsAdapter(Context context) {
        delegatesManager.addDelegate(new PowerStatDelegate(context));
    }

    public void setData(List<Object> data) {
        setItems(data);
    }
}
