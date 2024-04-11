package com.openclassrooms.hexagonal.games.ui.add;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.hexagonal.games.data.repository.PostRepository;
import com.openclassrooms.hexagonal.games.domain.model.Post;
import com.openclassrooms.hexagonal.games.domain.model.User;

import java.util.UUID;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * This ViewModel manages data and interactions related to adding new posts in the AddFragment.
 * It utilizes dependency injection to retrieve a PostRepository instance for interacting with post data.
 *
 * @see AddFragment
 * @see PostRepository
 */
@HiltViewModel
public final class AddViewModel
        extends ViewModel {
    /**
     * Repository instance used for accessing and manipulating Post data.
     */
    private final PostRepository postRepository;

    private final MutableLiveData<Post> post = new MutableLiveData<>(new Post(
            UUID.randomUUID().toString(),
            "",
            "",
            null,
            System.currentTimeMillis(),
            null
    ));

    public final LiveData<FormError> error = Transformations.map(post, post -> {
                final FormError formError;

                if (post.title.isEmpty()) {
                    formError = new FormError.TitleError();
                } else {
                    formError = null;
                }

                return formError;
            }
    );

    /**
     * Constructor for AddViewModel. Injected with a PostRepository instance.
     *
     * @param postRepository Repository for interacting with Post data.
     */
    @Inject
    public AddViewModel(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Initiates the process of adding a new Post. This method currently has a TODO marker,
     * indicating that the specific implementation for adding a post needs to be completed.
     * The implementation likely involves collecting user input, creating a Post object, and
     * using the PostRepository to persist the new Post.
     */
    public void addPost(/*...*/) {
        //TODO : retrieve the current user
        final Post currentPost = post.getValue();
        final Post postToAdd = new Post(
                currentPost.id,
                currentPost.title,
                currentPost.description,
                currentPost.photoUrl,
                currentPost.timestamp,
                new User("1", "Gerry", "Ariella")
        );

        postRepository.addPost(postToAdd);
    }

    public void onAction(FormEvent formEvent) {
        final Post currentPost = post.getValue();
        final Post newPost;

        if (formEvent instanceof FormEvent.DescriptionChanged) {
            newPost = new Post(
                    currentPost.id,
                    currentPost.title,
                    ((FormEvent.DescriptionChanged) formEvent).description,
                    currentPost.photoUrl,
                    currentPost.timestamp,
                    currentPost.author
            );
        } else if (formEvent instanceof FormEvent.TitleChanged) {
            newPost = new Post(
                    currentPost.id,
                    ((FormEvent.TitleChanged) formEvent).title,
                    currentPost.description,
                    currentPost.photoUrl,
                    currentPost.timestamp,
                    currentPost.author
            );
        } else {
            newPost = currentPost;
        }

        post.setValue(newPost);
    }

}
