// package PemesananMakanan.Service;


// import io.quarkus.panache.common.Sort;

// import javax.enterprise.context.ApplicationScoped;
// import PemesananMakanan.Common.Devtest;
// import java.util.List;

// @ApplicationScoped
// public class DevtestService {

//     public List<Devtest> getAllUsers() {
//         return Devtest.listAll(Sort.by("nama"));
//     }

//     public Devtest getUserById(String userId) {
//         return Devtest.findById(userId);
//     }

//     public Devtest saveUser(Devtest user) {
//         user.persist();
//         return user;
//     }

//     public Devtest updateUser(Devtest user) {
//         Devtest existingUser = Devtest.findById(user.id);
//         if (existingUser != null) {
//             existingUser.nama = user.nama;
//             existingUser.password = user.password;
//             // Update other fields as needed
//             existingUser.persist();
//         }
//         return existingUser;
//     }

//     public void deleteUser(String userId) {
//         Devtest.deleteById(userId);
//     }
// }
