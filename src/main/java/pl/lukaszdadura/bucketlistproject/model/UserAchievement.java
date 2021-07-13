package pl.lukaszdadura.bucketlistproject.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_achievement")
public class UserAchievement {

    @Id
    private Long id;
    @NotNull
    private LocalDateTime created;
    private LocalDateTime dueDate;
    private Byte[] evidence;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;
}
