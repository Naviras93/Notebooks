package jpa;

import javax.persistence.*;
import java.util.*;

@Entity
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
}
