package com.openclassrooms.hexagonal.games.ui.homefeed;

import java.util.List;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.openclassrooms.hexagonal.games.R;
import com.openclassrooms.hexagonal.games.databinding.ItemPostBinding;
import com.openclassrooms.hexagonal.games.domain.model.Post;
import com.openclassrooms.hexagonal.games.ui.homefeed.HomefeedAdapter.PostViewHolder;

public final class HomefeedAdapter
    extends Adapter<PostViewHolder>
{

  public interface OnPostClickListener
  {

    void onClick(Post post);

  }

  public static final class PostViewHolder
      extends ViewHolder
  {

    public final TextView username;

    public final TextView title;

    public final TextView description;

    public final ImageView image;

    public PostViewHolder(@NonNull ItemPostBinding binding)
    {
      super(binding.getRoot());

      this.username = binding.userName;
      this.title = binding.title;
      this.description = binding.description;
      this.image = binding.image;
    }

    public void bind(Post post, OnPostClickListener clickListener)
    {
      username.setText(itemView.getContext().getString(R.string.by, post.author.firstname, post.author.lastname));

      title.setText(post.title);

      description.setText(post.description);
      description.setVisibility(TextUtils.isEmpty(post.description) == false ? View.VISIBLE : View.GONE);

      if (TextUtils.isEmpty(post.photoUrl) == false)
      {
        Glide
            .with(image.getContext())
            .load(post.photoUrl)
            .placeholder(new ColorDrawable(Color.GRAY))
            .into(image);

        image.setVisibility(View.VISIBLE);
      }
      else
      {
        image.setVisibility(View.GONE);
      }

      itemView.setOnClickListener(v -> {
        clickListener.onClick(post);
      });

    }
  }

  @NonNull
  private List<Post> posts;

  @NonNull
  private OnPostClickListener onPostClickListener;

  public HomefeedAdapter(@NonNull List<Post> posts,
      @NonNull OnPostClickListener onPostClickListener)
  {
    this.posts = posts;
    this.onPostClickListener = onPostClickListener;
  }

  @NonNull
  @Override
  public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
  {
    final ItemPostBinding binding = ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    return new PostViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull PostViewHolder holder, int position)
  {
    holder.bind(posts.get(position), onPostClickListener);
  }

  @Override
  public int getItemCount()
  {
    return posts.size();
  }

  public void update(List<Post> posts)
  {
    this.posts = posts;
    notifyDataSetChanged();
  }
}
