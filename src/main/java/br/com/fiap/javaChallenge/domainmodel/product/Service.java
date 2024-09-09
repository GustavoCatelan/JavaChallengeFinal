package br.com.fiap.javaChallenge.domainmodel.product;

import br.com.fiap.javaChallenge.domainmodel.analysis.Evaluation;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Entity
public class Service extends Negotiable{

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "EVALUATION",
            referencedColumnName = "ID_EVALUATION",
            foreignKey = @ForeignKey(
                    name = "FK_SERVICE_EVALUATION"
            )
    )
    private Evaluation evaluation;

}
