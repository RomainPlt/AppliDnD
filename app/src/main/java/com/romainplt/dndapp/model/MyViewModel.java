package com.romainplt.dndapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<Race>> race;
    public LiveData<List<Race>> getRace() {
        if (race == null) {
            race = new MutableLiveData<List<Race>>();
            loadRace();
        }
        return race;
    }

    private void loadRace() {

        // Do an asynchronous operation to fetch users.
    }

}
