package per.football.players.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "player", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Name is mandatory")
    @Column(unique=true)
    private String name;
    private String nationality;
    private int age;
    @Enumerated(EnumType.STRING)
    private Position position;
    @Embedded
    private Stats stats;
}
