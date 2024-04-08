package com.openclassrooms.hexagonal.games.ui.settings;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.openclassrooms.hexagonal.games.databinding.FragmentSettingsBinding;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * This fragment represents the Settings screen in the application. It allows users to enable or disable notifications.
 */
@AndroidEntryPoint
public final class SettingsFragment
        extends Fragment {

    /**
     * View binding object for the fragment's layout (fragment_settings.xml).
     */
    private FragmentSettingsBinding binding;

    /**
     * ViewModel responsible for handling data and events related to application settings.
     */
    private SettingsViewModel viewModel;

    /**
     * Launcher for requesting the notification permission from the user.
     */
    private ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
        //we do not check for the result here
    });

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupUI();
        setupViewModel();
    }

    /**
     * Retrieves the SettingsViewModel instance for this fragment.
     */
    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
    }

    /**
     * Initializes UI elements and sets up click listeners for the notification toggle buttons.
     */
    private void setupUI() {
        binding.notificationEnable.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED) {
                    requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS);
                }
            }

            viewModel.enableNotifications();
        });

        binding.notificationDisable.setOnClickListener(v -> {
            viewModel.disableNotifications();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}