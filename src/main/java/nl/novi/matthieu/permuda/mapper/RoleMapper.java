package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.RoleDto;
import nl.novi.matthieu.permuda.model.Role;

public class RoleMapper {
    public static RoleDto toDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.rolename = role.getRolename();
        return roleDto;
    }
}
