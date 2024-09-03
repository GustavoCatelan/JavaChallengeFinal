package br.com.fiap.javaChallenge.domainmodel.product;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Product extends Negotiable{

    private @Getter @Setter Integer quantity;
}
