package ejb;

import jpa.Notebook;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NotebookServiceImpl implements NotebookService {

    //For some reason PersistenceContext prevents the website from launching when starting the server (war exploded
    //doesn't deploy)

   /* @PersistenceContext
    EntityManager em;*/
    @Override
    public void createNotebook(Notebook notebook) {
//        em.persist(notebook);
    }

    @Override
    public void updateNotebook(Notebook notebook) {

    }

    @Override
    public void deleteNotebook(Notebook notebook) {

    }

    @Override
    public List<Notebook> getNotebooks() {
        return null;
    }
}