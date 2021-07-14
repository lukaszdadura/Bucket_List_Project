package pl.lukaszdadura.bucketlistproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ToString.Exclude
    @OneToMany(mappedBy = "achievement", cascade = CascadeType.REMOVE)
    private Set<UserAchievement> userAchievementList;
    @ToString.Exclude
    @OneToMany
    private List<Category> categoryList = new ArrayList<>();

}
