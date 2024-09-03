package br.com.fiap.javaChallenge.service.analysis;

import br.com.fiap.javaChallenge.datasource.analysis.EvaluationRepository;
import br.com.fiap.javaChallenge.domainmodel.analysis.Evaluation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EvaluationServiceImpl implements EvaluationService {

    private EvaluationRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Evaluation save(Evaluation e ){return repo.save(e);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Evaluation e){this.repo.delete(e);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id){this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Evaluation> findById(final long id){return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Evaluation> findAllEvaluation(){return this.repo.findAll();}
}
