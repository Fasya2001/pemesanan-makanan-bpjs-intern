package PemesananMakanan.Service;

import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;

import PemesananMakanan.Common.Notif;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class NotifService {

    public List<Notif> getAllNotif() {
        return Notif.listAll(Sort.by("createdDt"));
    }

    public Notif getNotifById(String notifId) {
        return Notif.findById(UUID.fromString(notifId));
    }

    public Notif saveNotif(Notif notif) {
        notif.persist();
        return notif;
    }

    public Notif updateNotif(Notif notif) {
        Notif existingNotif = Notif.findById(notif.id);
        if (existingNotif != null) {
            existingNotif.idUser = notif.idUser;
            existingNotif.idUserPemesan = notif.idUserPemesan;
            existingNotif.namaPemesan = notif.namaPemesan;
            // Update other fields as needed
            existingNotif.persist();
        }
        return existingNotif;
    }

    public void deleteNotif(String notifId) {
        Notif.deleteById(UUID.fromString(notifId));
    }
}
