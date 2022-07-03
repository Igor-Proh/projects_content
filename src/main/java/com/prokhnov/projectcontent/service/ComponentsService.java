package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.entity.Components;
import com.prokhnov.projectcontent.entity.Project;

import java.util.List;

public interface ComponentsService {
    public List<Components> getAllComponents();

    public void saveComponents(Components components);

    public Components getComponentsById(long id);

    public void deleteComponentsById(long id);
}
