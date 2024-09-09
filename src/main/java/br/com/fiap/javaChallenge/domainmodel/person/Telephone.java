package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TEL")
    private @Getter @Setter Long id;

    @Column(name = "DDI_TEL")
    private @Getter @Setter  String ddi;

    @Column(name = "DDD_TEL")
    private @Getter @Setter String ddd;

    @Column(name = "NUM_TEL")
    private @Getter @Setter String number;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PERSON",
            referencedColumnName = "ID_PERSON",
            foreignKey = @ForeignKey(
                    name = "FK_TELEPHONE_PERSON"
            )
    )
    private Person person;
}
