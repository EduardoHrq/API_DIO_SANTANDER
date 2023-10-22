package deploy.service.impl;

import deploy.model.User;
import deploy.repository.UserRepo;
import deploy.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userQuery;

    public UserServiceImpl(UserRepo repositorio) {
        this.userQuery = repositorio;
    }

    @Override
    public User findById(Long id) {
        return this.userQuery.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User usuario) {

        if(this.userQuery.existsById(usuario.getId())) {
            throw new IllegalArgumentException("Usuario já existe");
        }

        return this.userQuery.save(usuario);

    }
}
