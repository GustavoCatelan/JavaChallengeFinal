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
    @Column(name = "ID_NEGOTIABLE")
    private @Setter Long id;

    @Column(name = "NM_NEGOTIABLE")
    private @Setter String name;

    @Column(name = "DESC_NEGOTIABLE")
    private @Setter String description;

    @Column(name = "PR_NEGOTIABLE")
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
