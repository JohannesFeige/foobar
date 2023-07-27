package de.aclue.graphqltraining.superheroes.entities;

import de.aclue.graphqltraining.superheroes.values.Publisher;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String apiId;
    private String name;
    private String description;
    private String thumbnailUrl;
    @Enumerated(EnumType.STRING)
    private Publisher publisher;

    public void updateDescription(){
        this.description = StringUtils.normalizeSpace(this.description);
        this.description = StringUtils.remove(this.description, "\"");
        this.description = StringUtils.remove(this.description, "'");
        this.description = StringUtils.remove(this.description, ",");
        if (StringUtils.isBlank(this.description)){
            this.description = null;
        }
    }
}
