package test.moneytransfer.data;

import test.moneytransfer.model.User;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {
    User createUser(UUID id, User userModel);

    Optional<User> findUserById(UUID id);

    User updateUserById(UUID userId, User userModel);

    int deleteUserById(UUID userId);
}
