package ejb;

import jpa.Notebook;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NotebookService {
    void createNotebook(Notebook notebook);
    void updateNotebook(Long id, String newName);
    void deleteNotebook(Long id);
    List<Notebook> getNotebooks();
}
