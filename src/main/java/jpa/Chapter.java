package jpa;
import javax.persistence.*;
import java.util.List;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    private Notebook notebook;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chapter")
    private List<Entry> entries;

    public Chapter() {
    }

    public Chapter(String name) {
        this.name = name;
    }

    public Chapter(String name, Notebook notebook) {
        this.name = name;
        this.notebook = notebook;
    }

    public Chapter(String name, Notebook notebook, List<Entry> entries) {
        this.name = name;
        this.notebook = notebook;
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
