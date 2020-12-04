package builder;

public class Result {
    private Integer id;
    private String orderName;
    private String information;

    public Result(Integer id, String orderName, String information) {
        this.id = id;
        this.orderName = orderName;
        this.information = information;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String toString(){
        return getId()+'.'+getOrderName()+"\n"+getInformation();
    }
}
