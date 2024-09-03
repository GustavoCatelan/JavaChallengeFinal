package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String cep;
    private @Getter @Setter String street;
    private @Getter @Setter String number;
    private @Getter @Setter String complement;
    private @Getter @Setter String neighborhood;
    private @Getter @Setter String city;
    private @Getter @Setter String state;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return id == address.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
