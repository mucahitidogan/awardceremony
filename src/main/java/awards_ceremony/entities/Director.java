package awards_ceremony.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String directorName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Film> film;
    @OneToOne(cascade = CascadeType.ALL)
    private Award award;

    public Director(Integer id, String directorName, List<Film> film, Award award) {
        this.id = id;
        this.directorName = directorName;
        this.film = film;
        this.award = award;
    }

    public Director(String directorName, List<Film> film, Award award) {
        this.directorName = directorName;
        this.film = film;
        this.award = award;
    }

    public Director(String directorName) {
        this.directorName = directorName;
    }

    public Director(Integer id) {
        this.id = id;
    }
}
