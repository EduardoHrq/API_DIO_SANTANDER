package deploy.service;

import deploy.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findById(Long id);

    User create(User usuario);

}
