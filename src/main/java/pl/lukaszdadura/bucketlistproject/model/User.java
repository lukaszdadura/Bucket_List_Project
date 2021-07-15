package pl.lukaszdadura.bucketlistproject.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User extends BaseEntity{

    private String name;
    @Column(name = "username")
    @Length(min = 5, message = "Your user name must have at least 5 characters")
    @NotEmpty(message = "Please provide a user name")
    private String username;
    @Column(name = "email")
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Please provide your email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotEmpty(message = "Please provide your password")
    private String password;
    private boolean admin;
    private int enabled;
    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<UserAchievement> userAchievementList;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    private Set<Role> roles;

    public User(String name, String username, String password, int enabled, Set<Role> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
}
