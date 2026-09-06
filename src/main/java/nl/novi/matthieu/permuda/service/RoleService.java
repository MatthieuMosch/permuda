package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.RoleDto;
import nl.novi.matthieu.permuda.mapper.RoleMapper;
import nl.novi.matthieu.permuda.model.Role;
import nl.novi.matthieu.permuda.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {this.roleRepository = roleRepository;}

    public List<RoleDto> getAllRoles() {
        List<Role> roles = this.roleRepository.findAll();
        return roles.stream().map(RoleMapper::toDto).toList();
    }
}
