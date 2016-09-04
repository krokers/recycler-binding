package eu.rampsoftware.recyclerbinding.demo.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;

import eu.rampsoftware.recyclerbinding.demo.BR;
import eu.rampsoftware.recyclerbinding.demo.R;
import eu.rampsoftware.recyclerbinding.demo.model.ScreenTypesViewModel;
import eu.rampsoftware.recyclerbinding.demo.model.StaggeredGridViewModel;

public class StaggeredGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_staggered_grid);
        binding.setVariable(BR.model, new StaggeredGridViewModel());
    }
}
