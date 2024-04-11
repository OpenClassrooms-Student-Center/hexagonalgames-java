package com.openclassrooms.hexagonal.games.ui.add;

import androidx.annotation.StringRes;

import com.openclassrooms.hexagonal.games.R;

public class FormError {

    @StringRes
    public final int messageRes;

    private FormError(int messageRes) {
        this.messageRes = messageRes;
    }

    public static final class TitleError extends FormError {
        public TitleError() {
            super(R.string.error_title);
        }
    }
}
