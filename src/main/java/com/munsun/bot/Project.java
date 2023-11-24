package com.munsun.bot;

public class Project {
    private String name;
    private String description;
    private String reference;

    public Project(String name, String description, String reference) {
        this.name = name;
        this.description = description;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String toString() {
        String clrf = "\n";
        return "\t\t\t" + name + clrf
                + description + clrf
                + reference + clrf;
    }
}
