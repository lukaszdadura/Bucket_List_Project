package pl.lukaszdadura.bucketlistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.lukaszdadura.bucketlistproject.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    User findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
