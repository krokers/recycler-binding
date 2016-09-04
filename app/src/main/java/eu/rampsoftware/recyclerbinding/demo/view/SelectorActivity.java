package eu.rampsoftware.recyclerbinding.demo.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.greenrobot.event.EventBus;
import eu.rampsoftware.recyclerbinding.demo.BR;
import eu.rampsoftware.recyclerbinding.demo.R;
import eu.rampsoftware.recyclerbinding.demo.event.ModelEvents;
import eu.rampsoftware.recyclerbinding.demo.model.ScreenTypesViewModel;

public class SelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_selector);
        binding.setVariable(BR.model, new ScreenTypesViewModel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    public void onEventMainThread(final ModelEvents.OnTypeSelectedEvent event){
        if(ScreenTypesViewModel.TYPE_LINEAR_LIST.equalsIgnoreCase(event.getType())){
            startActivity(new Intent(this, LinearListActivity.class));
        } else if(ScreenTypesViewModel.TYPE_STAGGERED_GRID.equalsIgnoreCase(event.getType())){
            startActivity(new Intent(this, StaggeredGridActivity.class));
        }
    }
}
