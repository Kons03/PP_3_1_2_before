package com.kata.security.service;

import com.kata.security.DAO.RoleDAO;
import com.kata.security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAO;

//    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public List<Role> findAllRole() {
        return roleDAO.findAll();
    }

    @Override
    @Transactional
    public Set<Role> findByIdRoles(List<Long> roles) {
      return new HashSet<>(roleDAO.findAllById(roles));
    }

    @Override
    @PostConstruct
    @Transactional
    public void addDefaultRole() {
        roleDAO.save(new Role(1L,"ROLE_USER"));
        roleDAO.save(new Role(2L,"ROLE_ADMIN"));
    }
}