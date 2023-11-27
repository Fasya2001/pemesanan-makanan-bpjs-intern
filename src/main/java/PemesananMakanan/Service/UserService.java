package PemesananMakanan.Service;
// UserService.java


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import PemesananMakanan.Common.User;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Transactional
public class UserService {

    public List<User> getAllUsers() {
        return User.listAll();
    }

    public User getUserById(UUID userId) {
        return User.findById(userId);
    }

    public User createUser(User user) {
        user.persist();
        return user;
    }

    public User updateUser(User user) {
        User existingUser = User.findById(user.id);
        if (existingUser != null) {
            existingUser.email = user.email;
            existingUser.password = user.password;
            existingUser.roleKode = user.roleKode;
            existingUser.persist();
        }
        return existingUser;
    }

    public void deleteUser(UUID userId) {
        User.deleteById(userId);
    }

    public User getUserById(String userId) {
        return null;
    }

    public void deleteUser(String userId) {
    }

}

