package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class LegalPerson extends Person{

    private @Getter @Setter String cpf;
    public @Getter @Setter String rg;

}
