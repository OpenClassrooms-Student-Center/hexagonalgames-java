package com.openclassrooms.hexagonal.games.ui.add;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

import com.openclassrooms.hexagonal.games.data.repository.PostRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public final class AddViewModel
    extends ViewModel
{

  private final PostRepository postRepository;

  @Inject
  public AddViewModel(PostRepository postRepository)
  {
    this.postRepository = postRepository;
  }

  public void addPost(/*...*/)
  {
    //TODO
    //postRepository.addPost();
  }

}
