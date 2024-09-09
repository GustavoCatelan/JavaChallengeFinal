package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class PhysicalPerson extends Person {

    @Column(name = "CPF_PPERSON")
    private @Getter @Setter String cpf;

    @Column(name = "RG_PPERSON")
    public @Getter @Setter String rg;
}
