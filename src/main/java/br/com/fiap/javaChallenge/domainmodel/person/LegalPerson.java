package br.com.fiap.javaChallenge.domainmodel.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class LegalPerson extends Person{

    @Column(name = "CNPJ_LPERSON")
    private @Getter @Setter String cnpj;

    @Column(name = "NAT_LPERSON")
    private @Getter @Setter String legalNature;

    @Column(name = "SIT_LPERSON")
    private @Getter @Setter String situation;

}
