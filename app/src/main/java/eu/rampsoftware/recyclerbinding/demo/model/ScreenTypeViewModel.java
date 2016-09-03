package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Ramps on 2016-09-02.
 */
public class ScreenTypeViewModel extends BaseObservable {
    private final String mType;

    public ScreenTypeViewModel(String type) {
        mType = type;
    }

    @Bindable
    public String getType() {
        return mType;
    }
}
