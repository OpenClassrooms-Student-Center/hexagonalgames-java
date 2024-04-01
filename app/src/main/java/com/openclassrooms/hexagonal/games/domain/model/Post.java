package com.openclassrooms.hexagonal.games.domain.model;

/**
 * A post of the newsfeed
 */
public final class Post
{

  public final String id;

  public final String title;

  public final String description;

  public final String photoUrl;

  public Post(String id, String title, String description, String photoUrl)
  {
    this.id = id;
    this.title = title;
    this.description = description;
    this.photoUrl = photoUrl;
  }

}
