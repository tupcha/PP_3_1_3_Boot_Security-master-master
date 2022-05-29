package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Set<Role> getAllRoles() {
        return  new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public Set<Role> getRoleByName(String rollName) {
        return  roleRepository.getRoleByRoleName(rollName);
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
