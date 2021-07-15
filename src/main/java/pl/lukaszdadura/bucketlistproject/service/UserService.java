package pl.lukaszdadura.bucketlistproject.service;


import pl.lukaszdadura.bucketlistproject.exceptions.RegisterFailedException;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.model.dto.RegisterDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    void deleteUser(Long id);
    void updateUser(User user);
    User findByUsername(String username);
    User registerUser(RegisterDto dto) throws RegisterFailedException;
    User save(User u);
    User saveAdmin(User u);

}
