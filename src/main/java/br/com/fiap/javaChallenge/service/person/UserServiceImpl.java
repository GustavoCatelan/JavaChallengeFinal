package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.UserRepository;
import br.com.fiap.javaChallenge.domainmodel.person.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User save(User u) {return this.repo.save(u);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final User u) {this.repo.delete(u);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<User> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<User> findAllUser() {return this.repo.findAll();}

}
