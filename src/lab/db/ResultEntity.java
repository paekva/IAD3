package lab.db;

import javax.persistence.*;

@Entity
@Table(name = "result", schema = "s225138", catalog = "studs")
public class ResultEntity {

    private static final long serialVersionUID = 1L;
    private long id;
    private double xcoord;
    private double ycoord;
    private double radius;
    private Boolean inarea;
    private String msg;
    public ResultEntity() {}

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "xcoord")
    public double getXcoord() {
        return xcoord;
    }
    public void setXcoord(double xcoord) {
        this.xcoord = xcoord;
    }

    @Basic
    @Column(name = "ycoord")
    public double getYcoord() {
        return ycoord;
    }
    public void setYcoord(double ycoord) {
        this.ycoord = ycoord;
    }

    @Basic
    @Column(name = "radius")
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Basic
    @Column(name = "inarea")
    public Boolean getInarea() {
        return inarea;
    }
    public void setInarea(Boolean inarea) {
        this.inarea = inarea;
    }

    @Basic
    @Column(name = "msg")
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultEntity that = (ResultEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.xcoord, xcoord) != 0) return false;
        if (Double.compare(that.ycoord, ycoord) != 0) return false;
        if (Double.compare(that.radius, radius) != 0) return false;
        if (inarea != null ? !inarea.equals(that.inarea) : that.inarea != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int)id;
        temp = Double.doubleToLongBits(xcoord);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ycoord);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (inarea != null ? inarea.hashCode() : 0);
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        return result;
    }
}
