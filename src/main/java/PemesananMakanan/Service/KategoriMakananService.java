package PemesananMakanan.Service;
// KategoriMakananService.java
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;

import PemesananMakanan.Common.KategoriMakanan;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class KategoriMakananService {

    public List<KategoriMakanan> getAllKategoriMakanan() {
        return KategoriMakanan.listAll(Sort.by("namaKategori"));
    }

    public KategoriMakanan getKategoriMakananById(String kategoriId) {
        return KategoriMakanan.findById(UUID.fromString(kategoriId));
    }

    public KategoriMakanan saveKategoriMakanan(KategoriMakanan kategoriMakanan) {
        kategoriMakanan.persist();
        return kategoriMakanan;
    }

    public KategoriMakanan updateKategoriMakanan(KategoriMakanan kategoriMakanan) {
        KategoriMakanan existingKategoriMakanan = KategoriMakanan.findById(kategoriMakanan.id);
        if (existingKategoriMakanan != null) {
            existingKategoriMakanan.kodeKategori = kategoriMakanan.kodeKategori;
            existingKategoriMakanan.namaKategori = kategoriMakanan.namaKategori;
            // Update other fields as needed
            existingKategoriMakanan.persist();
        }
        return existingKategoriMakanan;
    }

    public void deleteKategoriMakanan(String kategoriId) {
        KategoriMakanan.deleteById(UUID.fromString(kategoriId));
    }
}


