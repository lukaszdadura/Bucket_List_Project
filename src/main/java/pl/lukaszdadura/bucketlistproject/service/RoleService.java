package pl.lukaszdadura.bucketlistproject.service;

import pl.lukaszdadura.bucketlistproject.model.Role;

public interface RoleService {
    Role findByName(String name);
    Role save(Role role);
}
