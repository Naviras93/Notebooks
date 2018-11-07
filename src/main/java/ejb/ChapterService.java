package ejb;

import jpa.Chapter;
import jpa.Notebook;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ChapterService {
    void createChapter(Chapter chapter);
    void updateChapter(Long id, String newName);
    void deleteChapter(Long id);
    List<Chapter> getChapters();
}
