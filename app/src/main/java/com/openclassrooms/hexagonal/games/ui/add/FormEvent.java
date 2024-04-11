package com.openclassrooms.hexagonal.games.ui.add;

/**
 * A base abstract class representing events that can occur on a form.
 * This class is marked as abstract to prevent direct instantiation.
 * Subclasses should extend this class to define specific form events.
 */
public abstract class FormEvent {

    private FormEvent() {
    }

    /**
     * An event indicating a change to the form title.
     */
    public static class TitleChanged extends FormEvent {

        /**
         * The new title of the form.
         */
        public final String title;

        public TitleChanged(String title) {
            this.title = title;
        }

    }

    /**
     * An event indicating a change to the form description.
     */
    public static class DescriptionChanged extends FormEvent {

        public final String description;

        /**
         * The new description of the form.
         */
        public DescriptionChanged(String description) {
            this.description = description;
        }

    }

}
