package com.openclassrooms.hexagonal.games.ui.homefeed;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.openclassrooms.hexagonal.games.R;
import com.openclassrooms.hexagonal.games.databinding.FragmentHomefeedBinding;
import com.openclassrooms.hexagonal.games.domain.model.Post;
import com.openclassrooms.hexagonal.games.ui.homefeed.HomefeedAdapter.OnPostClickListener;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * This fragment represents the Homefeed screen in the application. It displays a list of posts using a RecyclerView,
 * handles post clicks, and navigates to the AddFragment for creating new posts.
 */
@AndroidEntryPoint
public final class HomefeedFragment
    extends Fragment
    implements OnPostClickListener
{

  /**
   * View binding object for the fragment's layout (fragment_homefeed.xml).
   */
  private FragmentHomefeedBinding binding;

  /**
   * Adapter for managing and displaying post data in the RecyclerView.
   */
  private HomefeedAdapter adapter;

  /**
   * ViewModel responsible for handling data and events related to the Homefeed.
   */
  private HomefeedViewModel viewModel;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
  {
    binding = FragmentHomefeedBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
  {
    super.onViewCreated(view, savedInstanceState);

    setupUI();
    setupViewModel();

    observePosts();
  }

  @Override
  public void onClick(Post post)
  {
    //TODO: display the details and the comments associated with the post
  }

  /**
   * Observes changes in the list of posts from the ViewModel and updates the adapter with the new data.
   */
  private void observePosts()
  {
    viewModel.getPosts().observe(getViewLifecycleOwner(), posts -> {
      adapter.update(posts);
    });
  }

  /**
   * Retrieves the HomefeedViewModel instance for this fragment.
   */
  private void setupViewModel()
  {
    viewModel = new ViewModelProvider(this).get(HomefeedViewModel.class);
  }

  /**
   * Initializes UI elements, sets up the adapter for the RecyclerView, and handles the floating action button.
   */
  private void setupUI()
  {
    adapter = new HomefeedAdapter(new ArrayList<>(), this);
    binding.recyclerView.setAdapter(adapter);
    binding.recyclerView.addItemDecoration(new HomefeedItemDecoration(getResources().getDimensionPixelSize(R.dimen.padding_xs)));
    binding.recyclerView.setHasFixedSize(true);

    binding.fab.setOnClickListener(view -> {
      NavHostFragment.findNavController(this).navigate(R.id.action_global_AddFragment);
    });
  }

  @Override
  public void onDestroyView()
  {
    super.onDestroyView();
    binding = null;
  }

}
