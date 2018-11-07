package jsf;


import ejb.ChapterService;
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
    private String createChapterName;
    private String editNotebookName;
    private List<Notebook> notebooks;
    private List<Chapter> chapters;
    private Notebook selectedNotebook;

    @EJB
    NotebookService notebookService;
    @EJB
    ChapterService chapterService;

    public void createNotebook(){
        Notebook nb = new Notebook();
        nb.setName(createNotebookName);
        notebookService.createNotebook(nb);
    }


    public void createChapter(Notebook notebook) {
        Chapter c = new Chapter();
        c.setName("Chapter " + (notebook.getChapters().size()+1));
        c.setNotebook(notebook);
        chapterService.createChapter(c);
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

    public String getCreateChapterName() {
        return createChapterName;
    }

    public void setCreateChapterName(String createChapterName) {
        this.createChapterName = createChapterName;
    }

}
