package jsf;


import ejb.NotebookService;
import jpa.Chapter;
import jpa.Notebook;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class NotebookBean {
    private String createNotebookName;
    private List<Notebook> notebooks;
    private List<Chapter> chapters;
    private Notebook selectedNotebook;

    @EJB
    NotebookService notebookService;

    public void createNotebook(){
        Notebook nb = new Notebook();
        nb.setName(createNotebookName);
        notebookService.createNotebook(nb);
    }

    public List<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(List<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public void updateNotebook() {
        selectedNotebook = new Notebook();
    }

    public void deleteNotebook() {
        notebooks.remove(selectedNotebook);
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getCreateNotebookName() {
        return createNotebookName;
    }

    public void setCreateNotebookName(String createNotebookName) {
        this.createNotebookName = createNotebookName;
    }
}
