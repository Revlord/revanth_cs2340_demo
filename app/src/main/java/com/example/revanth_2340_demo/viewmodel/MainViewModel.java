package com.example.revanth_2340_demo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.revanth_2340_demo.model.CounterModel;

public class MainViewModel extends ViewModel {
    //using mutablelivedata to hold the data that can be observed by the view(s)
    //greetingmessage shall hold the greeting text and counter will hold its value

    private MutableLiveData<String> greetingMessage;
    private MutableLiveData<Integer> counter;
    //instance of the CounterModel to handle the counter logic
    private CounterModel counterModel;

    public MainViewModel() {
        greetingMessage = new MutableLiveData<>();
        counter = new MutableLiveData<>();
        counterModel = new CounterModel();
        greetingMessage.setValue("Hello World! -From viewModel");
        counter.setValue(counterModel.getCounter());
    }

    public LiveData<String> getGreetingMessage() {
        return greetingMessage;
    }
    public LiveData<Integer> getCounter() {
        return counter;
    }

    //behavior methods
    public void updateMessage() {
        greetingMessage.setValue("Hello from the MainViewModel!");
    }

    public void incrementCounter() {
        counterModel.incrementCounter();
        counter.setValue(counterModel.getCounter());
    }


}
