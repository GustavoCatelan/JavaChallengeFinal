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
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String coverageArea;
    private @Getter @Setter String location;
    private @Getter @Setter String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distributor distributor)) return false;
        return id == distributor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
