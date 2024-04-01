package com.openclassrooms.hexagonal.games.data.repository;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.openclassrooms.hexagonal.games.data.service.PostApi;
import com.openclassrooms.hexagonal.games.domain.model.Post;

@Singleton
public class PostRepository
{

  private final PostApi postApi;

  @Inject
  public PostRepository(PostApi postApi)
  {
    this.postApi = postApi;
  }

  public List<Post> getPosts()
  {
    return postApi.getPosts();
  }

}
