package com.openclassrooms.hexagonal.games.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.openclassrooms.hexagonal.games.databinding.FragmentSettingsBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class SettingsFragment
    extends Fragment
{

  private FragmentSettingsBinding binding;

  private SettingsViewModel viewModel;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
  {
    binding = FragmentSettingsBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
  {
    super.onViewCreated(view, savedInstanceState);

    setupUI();
    setupViewModel();
  }

  private void setupViewModel()
  {
    viewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
  }

  private void setupUI()
  {
    binding.notificationEnable.setOnClickListener(v -> {
      viewModel.enableNotifications();
    });

    binding.notificationDisable.setOnClickListener(v -> {
      viewModel.disableNotifications();
    });
  }

  @Override
  public void onDestroyView()
  {
    super.onDestroyView();
    binding = null;
  }

}