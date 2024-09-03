package br.com.fiap.javaChallenge.datasource.analysis;

import br.com.fiap.javaChallenge.domainmodel.analysis.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
