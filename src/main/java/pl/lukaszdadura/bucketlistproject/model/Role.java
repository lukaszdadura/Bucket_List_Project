package pl.lukaszdadura.bucketlistproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Role extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy="roles")
    Set<User> users;
}
