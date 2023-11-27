package PemesananMakanan.Common;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Role extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "role_kode")
    private String roleKode;

    @Column(name = "role_name")
    private String roleName;

    @CreationTimestamp
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @Column(name = "created_by")
    private String createdBy;

    // Constructors, getters, and setters
}

