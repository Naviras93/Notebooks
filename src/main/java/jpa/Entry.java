package jpa;
import javax.persistence.*;
import java.util.List;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    private Chapter chapter;

    @ManyToMany
    @JoinTable(
            name="EntryTags",
            joinColumns = @JoinColumn(name="Entry_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="Tag_ID", referencedColumnName = "id")
    )
    private List<Tag> tags;

    public Entry() {
    }

    public Entry(String name, String description, Chapter chapter) {
        this.name = name;
        this.description = description;
        this.chapter = chapter;
    }

    public Entry(String name, String description, Chapter chapter, List<Tag> tags) {
        this.name = name;
        this.description = description;
        this.chapter = chapter;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
