package PemesananMakanan.Common;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Makanan extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "kode_kategori")
    private String kodeKategori;

    @Column(name = "nama_kategori")
    private String namaKategori;

    @Column(name = "nama_makanan")
    public String namaMakanan;

    @Column(name = "deskripsi")
    public String deskripsi;

    @Column(name = "harga")
    private Integer harga;

    @Column(name = "is_active")
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @Column(name = "created_by")
    private String createdBy;

    // Constructors

    // Getter and Setter methods for namaMakanan
    public String getNamaMakanan() {
        return this.namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    // Getter and Setter methods for deskripsi
    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // Other getters and setters
}
