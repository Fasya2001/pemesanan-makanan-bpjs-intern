package PemesananMakanan.Common;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Komen extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "id_user")
    public UUID idUser;

    @Column(name = "id_user_pemesan")
    public UUID idUserPemesan;

    @Column(name = "nama_pemesan")
    public String namaPemesan;

    @Column(name = "nama_penerima_pesanan")
    private String namaPenerimaPesanan;

    @Column(name = "keterangan")
    private String keterangan;

    @CreationTimestamp
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @Column(name = "created_by")
    private String createdBy;

    // Constructors, getters, and setters
}
