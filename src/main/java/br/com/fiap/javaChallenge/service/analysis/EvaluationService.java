package br.com.fiap.javaChallenge.service.analysis;

import br.com.fiap.javaChallenge.domainmodel.analysis.Evaluation;

import java.util.List;

public interface EvaluationService {

    Evaluation save(Evaluation e);

    void delete(Evaluation e);

    void deleteById(long id);

    List<Evaluation> findAllEvaluation();
}
