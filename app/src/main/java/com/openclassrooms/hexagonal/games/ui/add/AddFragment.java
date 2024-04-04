package com.openclassrooms.hexagonal.games.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.openclassrooms.hexagonal.games.databinding.FragmentAddBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class AddFragment
    extends Fragment
{

  private FragmentAddBinding binding;

  private AddViewModel viewModel;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
  {
    binding = FragmentAddBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
  {
    super.onViewCreated(view, savedInstanceState);

    setupUI();
    setupViewModel();
  }

  @Override
  public void onDestroyView()
  {
    super.onDestroyView();
    binding = null;
  }

  private void setupViewModel()
  {
    viewModel = new ViewModelProvider(this).get(AddViewModel.class);
  }

  private void setupUI()
  {
  }

}