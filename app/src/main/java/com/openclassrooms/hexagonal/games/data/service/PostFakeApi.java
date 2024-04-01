package com.openclassrooms.hexagonal.games.data.service;

import java.util.ArrayList;
import java.util.List;

import com.openclassrooms.hexagonal.games.domain.model.Post;

public class PostFakeApi
    implements PostApi
{

  private List<Post> posts = new ArrayList<Post>()
  {
    {
      add(new Post("1", "Laughing History", "He learned the important lesson that a picnic at the beach on a windy day is a bad idea.", ""));
      add(new Post("2", "The Invisible Window", null, "https://picsum.photos/id/40/1080/"));
      add(new Post("3", "Woman of Years", "After fighting off the alligator, Brian still had to face the anaconda.", null));
      add(new Post("4", "The Door's Game", null, "https://picsum.photos/id/85/1080/"));
      add(new Post("5", "The Secret of the Flowers", "Improve your goldfish's physical fitness by getting him a bicycle.", null));
    }
  };

  @Override
  public List<Post> getPosts()
  {
    return posts;
  }

}
