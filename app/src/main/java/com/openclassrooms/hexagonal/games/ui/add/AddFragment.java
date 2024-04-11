package com.openclassrooms.hexagonal.games.ui.add;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.openclassrooms.hexagonal.games.databinding.FragmentAddBinding;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * This fragment represents the Add screen in the application. It allows users to create new posts.
 * It utilizes ViewModel for managing data and interactions.
 *
 * @see AddViewModel
 */

@AndroidEntryPoint
public final class AddFragment
    extends Fragment
{

  /**
   * View binding object for the fragment's layout (fragment_add.xml).
   */
  private FragmentAddBinding binding;

  /**
   * ViewModel instance responsible for handling data and interactions related to adding posts.
   */
  private AddViewModel viewModel;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
  {
    binding = FragmentAddBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
  {
    super.onViewCreated(view, savedInstanceState);

    setupUI();
    setupViewModel();
    observeErrors();
  }

  private void observeErrors() {
    viewModel.error.observe(getViewLifecycleOwner(), formError -> {
      if (formError == null) {
        cleanUpErrors();
      } else if (formError instanceof FormError.TitleError) {
        displayTitleError(formError.messageRes);
      }
    });
  }

  private void displayTitleError(@StringRes int messageRes) {
    cleanUpErrors();
    binding.fab.setEnabled(false);
    binding.titleContainer.setError(getString(messageRes));
  }

  private void cleanUpErrors() {
    binding.fab.setEnabled(true);
    binding.titleContainer.setError(null);
  }

  @Override
  public void onDestroyView()
  {
    super.onDestroyView();
    binding = null;
  }

  /**
   * Initializes the ViewModel instance using ViewModelProvider.
   */
  private void setupViewModel()
  {
    viewModel = new ViewModelProvider(this).get(AddViewModel.class);
  }

  /**
   * Sets up the UI elements of the fragment (button clicks, text input handling etc.).
   * Specific implementation details for UI setup omitted here for brevity.
   */
  private void setupUI()
  {
    binding.fieldTitle.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        viewModel.onAction(new FormEvent.TitleChanged(s.toString()));
      }
    });

    binding.fieldDescription.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        viewModel.onAction(new FormEvent.DescriptionChanged(s.toString()));
      }
    });

    binding.fab.setOnClickListener(v -> {
      viewModel.addPost();
      NavHostFragment.findNavController(this).popBackStack();
    });
  }

}