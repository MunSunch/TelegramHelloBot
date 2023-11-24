package com.munsun.bot;

import java.util.ArrayList;
import java.util.List;

public abstract class MyPortfolioProviderAbstract {
    private List<Project> projects;
    private int counter = 0;

    public MyPortfolioProviderAbstract() {
        projects = new ArrayList<>();
    }

    public void appendNewProject(Project newProject) {
        projects.add(newProject);
    }

    public Project getNextProject() {
        if(counter == projects.size())
            counter = 0;
        return projects.get(counter++);
    }

    public Project getPrevProject() {
        if(counter < 0) {
            counter = projects.size() - 1;
            return projects.get(counter--);
        }
        return projects.get(counter--);
    }

    public List<Project> getProjects(){
        return List.copyOf(projects);
    }
}
