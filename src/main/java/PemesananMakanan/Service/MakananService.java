package PemesananMakanan.Service;

import io.quarkus.panache.common.Sort;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import PemesananMakanan.Common.Makanan;
import java.util.List;

@ApplicationScoped
public class MakananService {

    public List<Makanan> getAllMakanan() {
        return Makanan.listAll(Sort.by("namaMakanan"));
    }

    public Makanan getMakananById(String makananId) {
        return Makanan.findById(UUID.fromString(makananId));
    }

    public Makanan saveMakanan(Makanan makanan) {
        makanan.persist();
        return makanan;
    }

    public Makanan updateMakanan(Makanan makanan) {
        Makanan existingMakanan = Makanan.findById(makanan.id);
        if (existingMakanan != null) {
            existingMakanan.namaMakanan = makanan.namaMakanan;
            existingMakanan.deskripsi = makanan.deskripsi;
            // Update other fields as needed
            existingMakanan.persist();
        }
        return existingMakanan;
    }

    public void deleteMakanan(String makananId) {
        Makanan.deleteById(UUID.fromString(makananId));
    }
}
