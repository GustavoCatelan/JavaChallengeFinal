package br.com.fiap.javaChallenge.domainmodel.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Negotiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Setter Long id;
    private @Setter String name;
    private @Setter String description;
    private @Setter Float price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Negotiable negotiable)) return false;
        return id == negotiable.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
