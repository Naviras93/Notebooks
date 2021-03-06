package jpa;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name="GetAllNotebooks", query="SELECT n FROM Notebook n ORDER BY n.name")
})
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook")
    private List<Chapter> chapters;
    public Notebook(){}

    public Notebook(String name) {
        this.name = name;
    }

    public Notebook(String name, List<Chapter> chapters) {
        this.name = name;
        this.chapters = chapters;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void setChapter(Chapter chapter) { this.chapters.add(chapter); }
}
