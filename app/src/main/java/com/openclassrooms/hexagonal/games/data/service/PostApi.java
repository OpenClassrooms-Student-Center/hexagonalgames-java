package com.openclassrooms.hexagonal.games.data.service;

import java.util.List;

import com.openclassrooms.hexagonal.games.domain.model.Post;

/**
 * This interface defines the contract for interacting with Post data from a data source.
 * It outlines the methods for retrieving and adding Posts, abstracting the underlying
 * implementation details of fetching and persisting data.
 */
public interface PostApi
{

  /**
   * Retrieves a list of Posts ordered by their creation date in descending order.
   *
   * @return A list of Posts sorted by creation date (newest first).
   */
  List<Post> getPostsOrderByCreationDateDesc();

  /**
   * Adds a new Post to the data source.
   *
   * @param post The Post object to be added.
   */
  void addPost(Post post);

}
