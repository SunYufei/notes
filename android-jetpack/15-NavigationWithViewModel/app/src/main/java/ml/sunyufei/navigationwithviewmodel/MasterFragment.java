package ml.sunyufei.navigationwithviewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import ml.sunyufei.navigationwithviewmodel.databinding.FragmentMasterBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MasterFragment extends Fragment {

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentMasterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_master, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());
        binding.buttonMaster.setOnClickListener(view -> {
            NavController controller = Navigation.findNavController(view);
            controller.navigate(R.id.action_masterFragment_to_detailFragment);
        });

        binding.seekBar.setProgress(myViewModel.getNumber().getValue());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myViewModel.getNumber().setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        return binding.getRoot();
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_master, container, false);
    }
}