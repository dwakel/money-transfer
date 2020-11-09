package test.moneytransfer.data;

import org.springframework.stereotype.Repository;
import test.moneytransfer.model.User;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.*;

@Repository
public class UserRepository implements IUserRepository {
    private static List<User> UserTable = new ArrayList<User>();

    @Override
    public User createUser(UUID id, User userModel) {
        UserTable.add(new User(id,
                userModel.getName(),
                userModel.getEmail(),
                userModel.getPassword(),
                new Date()));

        return UserTable.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return UserTable.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    @Override
    public User updateUserById(UUID userId, User userModel) {
        return findUserById(userId)
                .map(p -> {
                    int index = UserTable.indexOf((p));
                    if (index >= 0){
                        return UserTable.set(index, new User(userId,
                                userModel.getName(),
                                userModel.getEmail(),
                                userModel.getPassword(),
                                new Date()));

                    }
                    return userModel;
                }).orElse(userModel);
    }

    @Override
    public int deleteUserById(UUID userId) {
        Optional<User> userMaybe = findUserById(userId);
        if(userMaybe.isEmpty()) {
            return 0;
        }
        UserTable.remove(userMaybe.get());
        return 1;
    }
}
