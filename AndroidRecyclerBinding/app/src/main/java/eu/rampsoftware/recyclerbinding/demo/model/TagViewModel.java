package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Ramps on 2016-09-02.
 */
public class TagViewModel extends BaseObservable {
    private final String mTag;

    public TagViewModel(String tag) {
        mTag = tag;
    }

    @Bindable
    public String getTag() {
        return mTag;
    }


}
