package com.openclassrooms.hexagonal.games.ui.add;

public abstract class FormEvent {

    private FormEvent() {
    }

    public static class TitleChanged extends FormEvent {

        public final String title;

        public TitleChanged(String title) {
            this.title = title;
        }

    }

    public static class DescriptionChanged extends FormEvent {

        public final String description;

        public DescriptionChanged(String description) {
            this.description = description;
        }

    }
}