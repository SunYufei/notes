package ml.sunyufei.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> liveData;

    public MutableLiveData<Integer> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            liveData.setValue(0);
        }
        return liveData;
    }

    public void addNumber(int n) {
        liveData.setValue(liveData.getValue() + n);
    }
}
