package awards_ceremony.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ActorOrActress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String actorActressName;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Film> film;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Award> award;

    public ActorOrActress(Integer id, String actorActressName, List<Film> film, List<Award> award) {
        this.id = id;
        this.actorActressName = actorActressName;
        this.film = film;
        this.award = award;
    }
    public ActorOrActress(String actorActressName, List<Film> film, List<Award> award) {
        this.actorActressName = actorActressName;
        this.film = film;
        this.award = award;
    }
    public ActorOrActress(Integer id) {
        this.id = id;
    }

    public ActorOrActress(String actorActressName) {
        this.actorActressName = actorActressName;
    }


}
