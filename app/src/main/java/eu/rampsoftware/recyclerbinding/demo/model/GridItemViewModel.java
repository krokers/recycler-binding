package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Ramps on 2016-09-02.
 */
public class GridItemViewModel extends BaseObservable {
    private final int mImageResId;

    public GridItemViewModel(final int imageResId) {
        mImageResId = imageResId;
    }

    @Bindable
    public int getImageResId() {
        return mImageResId;
    }
}
