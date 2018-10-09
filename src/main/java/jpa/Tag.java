package jpa;
import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Entry> entries;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, List<Entry> entries) {
        this.name = name;
        this.entries = entries;
    }

}
