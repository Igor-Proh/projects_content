package com.prokhnov.projectcontent.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "components")
public class Components {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id")
    private long componentId;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "component_quantity")
    private int componentQuantity;

    @Column(name = "component_description")
    private String componentDescription;

    @Column(name = "component_date_of_create")
    private Date componentDateOfCreate;

    public Components() {
    }

    public Components(String componentName, int componentQuantity, String componentDescription, Date componentDateOfCreate) {
        this.componentName = componentName;
        this.componentQuantity = componentQuantity;
        this.componentDescription = componentDescription;
        this.componentDateOfCreate = componentDateOfCreate;
    }

    public long getComponentId() {
        return componentId;
    }

    public void setComponentId(long componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public int getComponentQuantity() {
        return componentQuantity;
    }

    public void setComponentQuantity(int componentQuantity) {
        this.componentQuantity = componentQuantity;
    }

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    public Date getComponentDateOfCreate() {
        return componentDateOfCreate;
    }

    public void setComponentDateOfCreate(Date componentDateOfCreate) {
        this.componentDateOfCreate = componentDateOfCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Components components = (Components) o;
        return componentId == components.componentId && componentQuantity == components.componentQuantity && Objects.equals(componentName, components.componentName) && Objects.equals(componentDescription, components.componentDescription) && Objects.equals(componentDateOfCreate, components.componentDateOfCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentId, componentName, componentQuantity, componentDescription, componentDateOfCreate);
    }

    @Override
    public String toString() {
        return "Component{" +
                "componentId=" + componentId +
                ", componentName='" + componentName + '\'' +
                ", componentQuantity=" + componentQuantity +
                ", componentDescription='" + componentDescription + '\'' +
                ", componentDateOfCreate=" + componentDateOfCreate +
                '}';
    }
}