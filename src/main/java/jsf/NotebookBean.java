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
    private String editNotebookName;
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

    public String openEditNotebook(Notebook notebook){
        this.selectedNotebook = notebook;
        return "editnotebook.xhtml";
    }

    public List<Notebook> getNotebooks() {
        return notebooks = notebookService.getNotebooks();
    }

    public void setNotebooks(List<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public String updateNotebook(Long id,String newName) {
        notebookService.updateNotebook(id, newName);
        return "notebooks.xhtml";
    }

    public String deleteNotebook(Long id) {
        notebookService.deleteNotebook(id);
        return "notebooks.xhtml";
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

    public Notebook getSelectedNotebook() {
        return selectedNotebook;
    }

    public void setSelectedNotebook(Notebook selectedNotebook) {
        this.selectedNotebook = selectedNotebook;
    }
}
