package com.lov.dipo.ui.sell;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SellViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SellViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Sale fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}