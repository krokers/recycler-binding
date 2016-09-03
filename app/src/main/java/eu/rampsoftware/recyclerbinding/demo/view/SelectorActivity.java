package eu.rampsoftware.recyclerbinding.demo.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eu.rampsoftware.recyclerbinding.demo.BR;
import eu.rampsoftware.recyclerbinding.demo.R;
import eu.rampsoftware.recyclerbinding.demo.model.ScreenTypesViewModel;

public class SelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_selector);
        binding.setVariable(BR.model, new ScreenTypesViewModel());
    }
}
