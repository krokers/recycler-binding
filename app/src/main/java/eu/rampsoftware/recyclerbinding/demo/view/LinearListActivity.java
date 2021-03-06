package eu.rampsoftware.recyclerbinding.demo.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import eu.rampsoftware.recyclerbinding.demo.BR;
import eu.rampsoftware.recyclerbinding.demo.R;
import eu.rampsoftware.recyclerbinding.demo.model.LinearListViewModel;

public class LinearListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_linear_list);
        binding.setVariable(BR.model, new LinearListViewModel());
    }
}
