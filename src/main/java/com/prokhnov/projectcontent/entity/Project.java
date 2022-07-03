package com.prokhnov.projectcontent.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;

    @NotNull
    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_date_of_create")
    private Date projectDateOfCreate;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "project_id")
//    private List<Component> projectComponent;

    public Project() {
    }

    public Project(String projectName, String projectDescription, Date projectDateOfCreate) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectDateOfCreate = projectDateOfCreate;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getProjectDateOfCreate() {
        return projectDateOfCreate;
    }

    public void setProjectDateOfCreate(Date projectDateOfCreate) {
        this.projectDateOfCreate = projectDateOfCreate;
    }

}
