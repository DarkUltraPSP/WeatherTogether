package app.hesias.WeatherTogether.Service;

import app.hesias.WeatherTogether.Model.Utilisateur;

import java.util.List;

public interface UtilisateurService {

List<Utilisateur> getAllUsers();
void createUser(Utilisateur user);
Utilisateur getUserById(int id);
Utilisateur updateUser(int id, Utilisateur user);
void deleteUser(int id);

}
