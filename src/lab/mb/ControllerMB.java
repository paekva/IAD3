package lab.mb;

import lab.db.ResultEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;

@ManagedBean(name="controllerMB")
@ApplicationScoped
public class ControllerMB implements Serializable{

    private Double currX;
    private Double currY;
    private Double currR=0.0;
    private Boolean curr;
    private List<ResultEntity> results = new ArrayList<ResultEntity>();

    public Double getCurrX()
    {
        return currX;
    }
    public void setCurrX(Double x)
    {
        currX=x;
    }
    public Double getCurrY()
    {
        return currY;
    }
    public void setCurrY(Double y)
    {
        currY=y;
    }
    public Double getCurrR()
    {
        return currR;
    }
    public void setCurrR(Double r)
    {
        currR=r;
    }
    public Boolean getCurr()
    {
        return curr;
    }
    public void setCurr(Boolean r)
    {
        curr=r;
    }

    public List<ResultEntity> getResults()
    {
        return results;
    }
    public ControllerMB() {    }
    public void addItem()
    {
        if((currR!=null)&&(currY!=null)) {
            AreaCheckMB area = new AreaCheckMB();
            ResultEntity item = area.getResult(currX, currY, currR);
            curr = item.getInarea();
            //insertDB(item);
            results.add(item);
        }
    }

    private void insertDB(ResultEntity item)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public String getListAsJson () {
        return new Gson().toJson(getResults());
    }
}
