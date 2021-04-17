package pl.foto99.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.foto99.admin.model.User;
import pl.foto99.admin.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }
}
