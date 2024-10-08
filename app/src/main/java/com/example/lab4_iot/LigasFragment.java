package com.example.lab4_iot;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4_iot.databinding.FragmentLigasBinding;

public class LigasFragment extends Fragment {

    FragmentLigasBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentLigasBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}