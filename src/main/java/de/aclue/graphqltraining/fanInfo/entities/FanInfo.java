package de.aclue.graphqltraining.fanInfo.entities;

import de.aclue.graphqltraining.superheroes.entities.Superhero;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FanInfo {

    public FanInfo(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String name;
    @ManyToOne
    @JoinColumn(name = "superhero_id")
    @Setter
    private Superhero favoritSuperhero;

}
