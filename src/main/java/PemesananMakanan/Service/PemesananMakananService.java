package PemesananMakanan.Service;


import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;

import PemesananMakanan.Common.PemesananMakanan;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PemesananMakananService {

    public List<PemesananMakanan> getAllPemesananMakanan() {
        return PemesananMakanan.listAll(Sort.by("createdDt"));
    }

    public PemesananMakanan getPemesananMakananById(String pemesananId) {
        return PemesananMakanan.findById(UUID.fromString(pemesananId));
    }

    public PemesananMakanan savePemesananMakanan(PemesananMakanan pemesananMakanan) {
        pemesananMakanan.persist();
        return pemesananMakanan;
    }

    public PemesananMakanan updatePemesananMakanan(PemesananMakanan pemesananMakanan) {
        PemesananMakanan existingPemesananMakanan = PemesananMakanan.findById(pemesananMakanan.id);
        if (existingPemesananMakanan != null) {
            existingPemesananMakanan.idUser = pemesananMakanan.idUser;
            existingPemesananMakanan.namaPemesan = pemesananMakanan.namaPemesan;
            existingPemesananMakanan.kodeKategori = pemesananMakanan.kodeKategori;
            // Update other fields as needed
            existingPemesananMakanan.persist();
        }
        return existingPemesananMakanan;
    }

    public void deletePemesananMakanan(String pemesananId) {
        PemesananMakanan.deleteById(UUID.fromString(pemesananId));
    }
}
