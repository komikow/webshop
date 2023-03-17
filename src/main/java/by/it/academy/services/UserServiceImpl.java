package by.it.academy.services;

import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
   private UserRepository userRepository;

    public void createUser(String firstName, String secondName,
                           int age, String login, String password) {
        UserRepository userRepository1 = new UserRepositoryImpl();
        userRepository1.createUser(firstName, secondName, age, login, password);
    }

    @Override
    public void deleteUser(String loginToDelete) {
        UserRepository userRepositoryToDelete = new UserRepositoryImpl();
        userRepositoryToDelete.deleteUser(loginToDelete);
    }

    public List<User> readUsers() {
        userRepository = new UserRepositoryImpl();
        return userRepository.readUsers();
    }
}

