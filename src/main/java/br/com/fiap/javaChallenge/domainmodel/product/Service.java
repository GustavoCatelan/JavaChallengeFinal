package br.com.fiap.javaChallenge.domainmodel.product;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Entity
public class Service extends Negotiable{

}
