package com.openclassrooms.hexagonal.games.domain.model;

import java.io.Serializable;

public final class User
    implements Serializable
{

  public final String id;

  public final String firstname;

  public final String lastname;

  public User(String id, String firstname, String lastname)
  {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
  }

}
