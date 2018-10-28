package ejb;

import jpa.Notebook;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NotebookServiceImpl implements NotebookService {

    @PersistenceContext()
    EntityManager em;
    @Override
    public void createNotebook(Notebook notebook) {
        em.persist(notebook);
    }

    @Override
    public void updateNotebook(Long id, String newName) {
        Notebook notebook = em.find(Notebook.class, id);
        notebook.setName(newName);
        em.merge(notebook);
        em.flush();
    }

    @Override
    public void deleteNotebook(Long id) {
        em.remove(em.find(Notebook.class, id));
    }

    @Override
    public List<Notebook> getNotebooks() {
        return em.createNamedQuery("GetAllNotebooks").getResultList();
    }
}
