package com.openclassrooms.hexagonal.games.ui.homefeed;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.openclassrooms.hexagonal.games.R;
import com.openclassrooms.hexagonal.games.databinding.FragmentHomefeedBinding;
import com.openclassrooms.hexagonal.games.domain.model.Post;
import com.openclassrooms.hexagonal.games.ui.homefeed.HomefeedAdapter.OnPostClickListener;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class HomefeedFragment
    extends Fragment
    implements OnPostClickListener
{

  private FragmentHomefeedBinding binding;

  private HomefeedAdapter adapter;

  private HomefeedViewModel viewModel;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
  {
    binding = FragmentHomefeedBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

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

  private void observePosts()
  {
    viewModel.getPosts().observe(getViewLifecycleOwner(), posts -> {
      adapter.update(posts);
    });
  }

  private void setupViewModel()
  {
    viewModel = new ViewModelProvider(this).get(HomefeedViewModel.class);
  }

  private void setupUI()
  {
    adapter = new HomefeedAdapter(new ArrayList<>(), this);
    binding.recyclerView.setAdapter(adapter);
    binding.recyclerView.addItemDecoration(new HomefeedItemDecoration(getResources().getDimensionPixelSize(R.dimen.padding_xs)));
    binding.recyclerView.setHasFixedSize(true);
  }

  @Override
  public void onDestroyView()
  {
    super.onDestroyView();
    binding = null;
  }

}
