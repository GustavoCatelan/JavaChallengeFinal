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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String username;
    private @Getter @Setter String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users user)) return false;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
