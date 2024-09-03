package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    @Getter @Setter private String ddi;
    @Getter @Setter private String ddd;
    @Getter @Setter private String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telephone telephone)) return false;
        return id == telephone.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
