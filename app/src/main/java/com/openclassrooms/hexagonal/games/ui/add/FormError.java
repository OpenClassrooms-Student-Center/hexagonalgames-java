package com.openclassrooms.hexagonal.games.ui.add;

import androidx.annotation.StringRes;

import com.openclassrooms.hexagonal.games.R;

/**
 * A sealed class representing different errors that can occur on a form.
 * <p>
 * Each error holds a resource ID for the corresponding error message string.
 */
public class FormError {

    /**
     * The resource ID of the error message string associated with this error.
     */
    @StringRes
    public final int messageRes;

    private FormError(int messageRes) {
        this.messageRes = messageRes;
    }

    /**
     * A static inner class representing an error related to the form title.
     */
    public static final class TitleError extends FormError {

        public TitleError() {
            super(R.string.error_title);
        }

    }
}
