package pl.lukaszdadura.bucketlistproject.model;

import lombok.*;
import org.hibernate.annotations.Type;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime created;
    private LocalDateTime dueDate;
    @Type(type="org.hibernate.type.BlobType")
    @Lob
    private byte[] evidence;
    @ManyToOne
    private User user;
    @ManyToOne
    private Achievement achievement;
}
