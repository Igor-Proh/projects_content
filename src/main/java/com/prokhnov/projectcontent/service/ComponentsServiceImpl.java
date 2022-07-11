package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.repository.ComponentsRepository;
import com.prokhnov.projectcontent.model.Components;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentsServiceImpl implements ComponentsService {
    private ComponentsRepository componentsRepository;

    public ComponentsServiceImpl() {
    }

    @Autowired
    public ComponentsServiceImpl(ComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    @Override
    public List<Components> getAllComponents() {
        return componentsRepository.findAll();
    }

    @Override
    public void saveComponents(Components components) {
        componentsRepository.save(components);
    }

    @Override
    public Components getComponentsById(long id) {
        return componentsRepository.getById(id);
    }

    @Override
    public void deleteComponentsById(long id) {
        componentsRepository.deleteById(id);
    }

}
