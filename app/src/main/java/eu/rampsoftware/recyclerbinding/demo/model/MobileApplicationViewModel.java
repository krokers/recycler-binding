package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Ramps on 2016-09-02.
 */
public class MobileApplicationViewModel extends BaseObservable {
    private final String mTitle;

    public MobileApplicationViewModel(String title) {
        mTitle = title;
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }
}
