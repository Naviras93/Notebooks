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
    private List<Notebook> notebooks;
    private List<Chapter> chapters;

    @EJB
    NotebookService notebookService;

    public void createNotebook(String name){
        Notebook nb = new Notebook();
        nb.setName(name);
        notebookService.createNotebook(nb);
    }


}
