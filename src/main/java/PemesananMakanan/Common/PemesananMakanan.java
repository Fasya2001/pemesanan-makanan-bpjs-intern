package PemesananMakanan.Common;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PemesananMakanan extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "id_user")
    public UUID idUser;

    @Column(name = "nama_pemesan")
    public String namaPemesan;

    @Column(name = "kode_kategori")
    public String kodeKategori;

    @Column(name = "nama_makanan")
    private String namaMakanan;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "divisi")
    private String divisi;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "harga_aktual")
    private Integer hargaAktual;

    @CreationTimestamp
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @Column(name = "created_by")
    private String createdBy;

    // Constructors, getters, and setters
}
