package ejb;

import jpa.Notebook;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NotebookService {
    void createNotebook(Notebook notebook);
    void updateNotebook(Notebook notebook);
    void deleteNotebook(Notebook notebook);
    List<Notebook> getNotebooks();
}
