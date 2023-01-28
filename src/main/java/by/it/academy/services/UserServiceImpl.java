package by.it.academy.services;

import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User createUser(String firstName, String secondName,
                           int age, String login, String password) {
        return userRepository.createUser(firstName, secondName, age, login, password);
    }

    public List<User> readUsers() {
        return userRepository.readUsers();
    }
}

