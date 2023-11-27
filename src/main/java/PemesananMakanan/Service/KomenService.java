package PemesananMakanan.Service;

import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;

import PemesananMakanan.Common.Komen;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class KomenService {

    public List<Komen> getAllKomen() {
        return Komen.listAll(Sort.by("createdDt"));
    }

    public Komen getKomenById(String komenId) {
        return Komen.findById(UUID.fromString(komenId));
    }

    public Komen saveKomen(Komen komen) {
        komen.persist();
        return komen;
    }

    public Komen updateKomen(Komen komen) {
        Komen existingKomen = Komen.findById(komen.id);
        if (existingKomen != null) {
            existingKomen.idUser = komen.idUser;
            existingKomen.idUserPemesan = komen.idUserPemesan;
            existingKomen.namaPemesan = komen.namaPemesan;
            // Update other fields as needed
            existingKomen.persist();
        }
        return existingKomen;
    }

    public void deleteKomen(String komenId) {
        Komen.deleteById(UUID.fromString(komenId));
    }
}

