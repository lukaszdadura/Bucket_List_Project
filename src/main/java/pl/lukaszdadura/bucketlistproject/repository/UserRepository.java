package pl.lukaszdadura.bucketlistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukaszdadura.bucketlistproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

}
