package com.openclassrooms.hexagonal.games.domain.model;

import java.io.Serializable;

/**
 * A post of the newsfeed
 */
public final class Post
    implements Serializable
{

  public final String id;

  public final String title;

  public final String description;

  public final String photoUrl;

  public final long timestamp;

  public final User author;


  public Post(String id, String title, String description, String photoUrl, long timestamp,
      User author)
  {
    this.id = id;
    this.title = title;
    this.description = description;
    this.photoUrl = photoUrl;
    this.timestamp = timestamp;
    this.author = author;
  }

}
