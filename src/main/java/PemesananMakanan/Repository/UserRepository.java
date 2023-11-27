package PemesananMakanan.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import PemesananMakanan.Common.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public User findById(UUID id) {
        return find("id", id).firstResult();
    }
    public User findByNameUser(String nama) {
        return find("nama", nama).firstResult();
    }
        public User findByPasswordUser(String password) {
        return find("password", password).firstResult();
    }
        public User findByemailUser(String email) {
        return find("email", email).firstResult();
    }
        public User findBynoHpUser(String noHp) {
        return find("no_hp", noHp).firstResult();
    }
        public User findByroleCodeUser(String roleKode) {
        return find("role_kode", roleKode).firstResult();
    }
    
}