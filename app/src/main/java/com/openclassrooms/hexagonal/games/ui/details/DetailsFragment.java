package com.openclassrooms.hexagonal.games.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.openclassrooms.hexagonal.games.R;
import com.openclassrooms.hexagonal.games.databinding.FragmentDetailsBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class DetailsFragment
    extends Fragment
{

  private FragmentDetailsBinding binding;

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  )
  {

    binding = FragmentDetailsBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
  {
    super.onViewCreated(view, savedInstanceState);

    binding.buttonSecond.setOnClickListener(v ->
        NavHostFragment.findNavController(DetailsFragment.this)
            .navigate(R.id.action_SecondFragment_to_FirstFragment)
    );
  }

  @Override
  public void onDestroyView()
  {
    super.onDestroyView();
    binding = null;
  }

}