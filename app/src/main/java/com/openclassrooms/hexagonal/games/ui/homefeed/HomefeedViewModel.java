package com.openclassrooms.hexagonal.games.ui.homefeed;

import java.util.List;
import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.hexagonal.games.data.repository.PostRepository;
import com.openclassrooms.hexagonal.games.domain.model.Post;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public final class HomefeedViewModel
    extends ViewModel
{

  private final PostRepository postRepository;

  @Inject
  public HomefeedViewModel(PostRepository postRepository)
  {
    this.postRepository = postRepository;
  }

  public LiveData<List<Post>> getPosts()
  {
    return postRepository.getPosts();
  }

}
