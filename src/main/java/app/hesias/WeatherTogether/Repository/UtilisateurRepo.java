package app.hesias.WeatherTogether.Repository;

import app.hesias.WeatherTogether.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
}
