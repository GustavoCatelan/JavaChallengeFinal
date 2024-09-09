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
    @Column(name = "ID_ADDRESS")
    private @Getter @Setter Long id;

    @Column(name = "CEP_ADDRESS")
    private @Getter @Setter String cep;

    @Column(name = "STREET_ADDRESS")
    private @Getter @Setter String street;

    @Column(name = "NUM_ADDRESS")
    private @Getter @Setter String number;

    @Column(name = "COMP_ADDRESS")
    private @Getter @Setter String complement;

    @Column(name = "NEIG_ADDRESS")
    private @Getter @Setter String neighborhood;

    @Column(name = "CITY_ADDRESS")
    private @Getter @Setter String city;

    @Column(name = "STATE_ADDRESS")
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PERSON",
            referencedColumnName = "ID_PERSON",
            foreignKey = @ForeignKey(
                    name = "FK_ADDRESS_PERSON"
            )
    )
    private Person person;
}
