package com.nicholasnassar.website;

public class Job {
    private final String name, link, time, skills, experience;

    public Job(String name, String link, String time, String skills, String experience) {
        this.name = name;

        this.link = link;

        this.time = time;

        this.skills = skills;

        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getTime() {
        return time;
    }

    public String getSkills() {
        return skills;
    }

    public String getExperience() {
        return experience;
    }
}
