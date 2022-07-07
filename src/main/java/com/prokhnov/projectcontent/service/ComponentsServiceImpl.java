package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.dao.ComponentsDAO;
import com.prokhnov.projectcontent.entity.Components;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComponentsServiceImpl implements ComponentsService {
    private ComponentsDAO componentsDAO;

    public ComponentsServiceImpl() {
    }

    @Autowired
    public ComponentsServiceImpl(ComponentsDAO componentsDAO) {
        this.componentsDAO = componentsDAO;
    }

    @Override
    public List<Components> getAllComponents() {
        return componentsDAO.findAll();
    }

    @Override
    public void saveComponents(Components components) {
        componentsDAO.save(components);
    }

    @Override
    public Components getComponentsById(long id) {

        return componentsDAO.getById(id);
    }

    @Override
    public void deleteComponentsById(long id) {
        componentsDAO.deleteById(id);
    }

}
