package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import de.greenrobot.event.EventBus;
import eu.rampsoftware.recyclerbinding.demo.event.ModelEvents;

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

    public void performAction(Object source){
        EventBus.getDefault().post(new ModelEvents.OnTypeSelectedEvent(mType));
    }
}
