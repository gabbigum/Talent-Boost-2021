package com.vmware.talentboost.jdbc.data;

import java.util.StringJoiner;

public class Job {

    private String id;
    private String title;
    private int minSalary;
    private int maxSalary;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(final int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(final int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Job.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("title='" + title + "'")
            .add("minSalary=" + minSalary)
            .add("maxSalary=" + maxSalary)
            .toString();
    }
}
