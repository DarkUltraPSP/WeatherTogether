package app.hesias.WeatherTogether.Model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Utilisateur")
@Getter
@Setter
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "utilisateur_id", nullable = false)
    private int id;
    private String username;
    private int phone;
}
