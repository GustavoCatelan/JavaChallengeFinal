package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class PhysicalPerson extends Person {

    private @Getter @Setter String cnpj;
    private @Getter @Setter String name;
    private @Getter @Setter String legalNature;
    private @Getter @Setter String situation;
}
