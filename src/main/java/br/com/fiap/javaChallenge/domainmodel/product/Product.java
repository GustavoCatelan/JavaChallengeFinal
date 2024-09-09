package br.com.fiap.javaChallenge.domainmodel.product;

import br.com.fiap.javaChallenge.domainmodel.analysis.Evaluation;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Product extends Negotiable{

    @Column(name = "QNT_PRODUCT")
    private @Getter @Setter Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "EVALUATION",
            referencedColumnName = "ID_EVALUATION",
            foreignKey = @ForeignKey(
                    name = "FK_PRODUCT_EVALUATION"
            )
    )
    private Evaluation evaluation;
}
