package com.openclassrooms.hexagonal.games.data.service;

import java.util.List;

import com.openclassrooms.hexagonal.games.domain.model.Post;

public interface PostApi
{

  List<Post> getPostsOrderByCreationDateDesc();

  void addPost(Post post);

}
