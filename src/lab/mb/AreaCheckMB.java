package lab.mb;

import javax.inject.Named;

import lab.db.ResultEntity;

@Named(value = "areaCheckMB")
public class AreaCheckMB {

    public ResultEntity getResult(Double x, Double y, Double r)
    {
        Boolean inArea = check(x, y, r);
        String msg;
        if(inArea) msg="Вы попали в область";
        else msg="Вы не попали в область";
        ResultEntity result = new ResultEntity();
        result.setRadius(r);
        result.setYcoord(y);
        result.setXcoord(x);
        result.setInarea(inArea);
        result.setMsg(msg);
        return result;
    }

    public Boolean check(Double x, Double y, Double r)
    {
        double tmp = x/2-r/2;
        boolean log = y >= tmp;
        if((x<0)&&(y>0)&&(x*x+y*y<=r*r)) return true;
        if((x>0)&&(y>0)&&(x<r/2)&&(y<r)) return true;
        if((x>0)&&(y<0))
        {
            if(log) return true;
            else return false;
        }
        return false;
    }
}

