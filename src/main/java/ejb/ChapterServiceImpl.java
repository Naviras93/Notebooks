package ejb;

import jpa.Chapter;
import jpa.Notebook;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ChapterServiceImpl implements ChapterService {

    @PersistenceContext()
    EntityManager em;

    @Override
    public void createChapter(Chapter chapter) {
       /* Notebook notebook = em.find(Notebook.class, chapter.getNotebook().getId());
        notebook.setChapter(chapter);*/
        em.persist(chapter);
    }

    @Override
    public void updateChapter(Long id, String newName) {

    }

    @Override
    public void deleteChapter(Long id) {

    }

    @Override
    public List<Chapter> getChapters() {
        return null;
    }
}
