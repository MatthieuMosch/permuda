package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {this.roleRepository = roleRepository;}


}
