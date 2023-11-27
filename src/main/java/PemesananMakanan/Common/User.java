package PemesananMakanan.Common;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "password")
    public String password;

    @Column(name = "email")
    public String email;

    @Column(name = "no_hp")
    private String noHp;

    @Column(name = "role_kode")
    public String roleKode;

    @CreationTimestamp
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @Column(name = "created_by")
    private String createdBy;

    public Object getName() {
        return null;
    }

    public Object getEmail() {
        return null;
    }

    public void setName(Object name) {
    }

    public void setEmail(Object email2) {
    }

    public void setRoleKode(String string) {
    }

    // Constructors, getters, and setters
}
