package com.openclassrooms.hexagonal.games.ui.homefeed;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public final class HomefeedItemDecoration
    extends ItemDecoration
{

  private final int spaceSize;

  public HomefeedItemDecoration(int spaceSize)
  {
    this.spaceSize = spaceSize;
  }

  @Override
  public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
      @NonNull RecyclerView parent, @NonNull State state)
  {
    if (parent.getChildAdapterPosition(view) == 0)
    {
      outRect.top = spaceSize;
    }

    outRect.left = spaceSize;
    outRect.right = spaceSize;
    outRect.bottom = spaceSize;
  }

}
