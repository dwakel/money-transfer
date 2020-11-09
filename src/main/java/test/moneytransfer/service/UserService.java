package test.moneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.moneytransfer.data.IUserRepository;
import test.moneytransfer.model.User;

import java.util.UUID;

@Service
public class UserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User AddUser(User user){
        return userRepository.createUser(UUID.randomUUID(), user);
    }

    public User GetUser(UUID userId){
        return userRepository.findUserById(userId).orElse(null);
    }

    public User UpdateUser(UUID userId, User user){
        return userRepository.updateUserById(userId, user);
    }
}
