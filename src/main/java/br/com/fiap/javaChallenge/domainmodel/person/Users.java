package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private @Getter @Setter Long id;

    @Column(name = "NM_USER")
    private @Getter @Setter String username;

    @Column(name = "PASS_USER")
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PERSON",
            referencedColumnName = "ID_PERSON",
            foreignKey = @ForeignKey(
                    name = "FK_USERS_PERSON"
            )
    )
    private Person person;
}
