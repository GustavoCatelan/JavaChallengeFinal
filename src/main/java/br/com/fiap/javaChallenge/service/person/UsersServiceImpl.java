package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.UsersRepository;
import br.com.fiap.javaChallenge.domainmodel.person.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users save(Users u) {return this.repo.save(u);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Users u) {this.repo.delete(u);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Users> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Users> findAllUser() {return this.repo.findAll();}

}
