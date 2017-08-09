package com.nicholasnassar.website;

public class Project {
    private final String title, description, linkText, link, background;

    public Project(String title, String description, String linkText, String link, String background) {
        this.title = title;

        this.description = description;

        this.linkText = linkText;

        this.link = link;

        this.background = background;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkText() {
        return linkText;
    }

    public String getLink() {
        return link;
    }

    public String getBackground() {
        return background;
    }
}
