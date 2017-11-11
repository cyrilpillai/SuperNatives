package cyrilpillai.supernatives.utils.callbacks;


/**
 * Created by cyrilpillai on 11-11-2017.
 */

public interface DataCallback<R, E> {
    void onSuccess(R response);

    void onError(E error);
}
