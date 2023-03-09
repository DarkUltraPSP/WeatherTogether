package app.hesias.WeatherTogether.Service;

import app.hesias.WeatherTogether.Model.Utilisateur;
import app.hesias.WeatherTogether.Repository.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepo userRepo;

    @Override
    public List<Utilisateur> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void createUser(Utilisateur user) {
        userRepo.save(user);
    }

    @Override
    public Utilisateur getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public Utilisateur updateUser(int id, Utilisateur user) {
        return userRepo.findById(id).map(u -> {
            u.setUsername(user.getUsername());
            u.setPhone(user.getPhone());
            return userRepo.save(u);
        }).orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
