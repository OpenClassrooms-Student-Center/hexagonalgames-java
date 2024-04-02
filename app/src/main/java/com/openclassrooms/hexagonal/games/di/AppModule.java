package com.openclassrooms.hexagonal.games.di;

import javax.inject.Singleton;

import com.openclassrooms.hexagonal.games.data.service.PostApi;
import com.openclassrooms.hexagonal.games.data.service.PostFakeApi;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public final class AppModule
{

  @Provides
  @Singleton
  public PostApi providePostApi()
  {
    return new PostFakeApi();
  }

}
