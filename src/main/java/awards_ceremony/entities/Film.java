package awards_ceremony.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String filmName;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ActorOrActress> actorOrActress;
    @ManyToOne(cascade = CascadeType.ALL)
    private Director director;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Award> award;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Category> category;

    public Film(Integer id, String filmName, List<ActorOrActress> actorOrActress, Director director, List<Award> award, List<Category> category) {
        this.id = id;
        this.filmName = filmName;
        this.actorOrActress = actorOrActress;
        this.director = director;
        this.award = award;
        this.category = category;
    }

    public Film(String filmName, List<ActorOrActress> actorOrActress, Director director, List<Award> award, List<Category> category) {
        this.filmName = filmName;
        this.actorOrActress = actorOrActress;
        this.director = director;
        this.award = award;
        this.category = category;
    }

    public Film(String filmName) {
        this.filmName = filmName;
    }

    public Film(Integer id) {
        this.id = id;
    }
}
