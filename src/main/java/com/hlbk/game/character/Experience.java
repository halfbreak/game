package com.hlbk.game.character;

public class Experience {
    private long experience;

    public Experience() {
        experience = 0;
    }

    public Experience(long experience) {
        this.experience = experience;
    }

    public void increase(int experience) {
        this.experience += experience;
    }

    public long getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "experience=" + experience +
                '}';
    }
}
