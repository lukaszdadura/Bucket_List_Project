package pl.lukaszdadura.bucketlistproject.service;


import pl.lukaszdadura.bucketlistproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    void deleteUser(Long id);
    void updateUser(User user);

}
