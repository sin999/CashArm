package cashArm.Common.OEntityes.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public enum Status {
    ACTIVE(0.0),
    INACTIVE(1.0),  //Only system could set this parameter
    PAUSED_BY_SYSTEM(2.0),//Only system could set this parameter
    PAUSED_BY_OPERATOR(3.0),
    DELETED(4.0);
    private Double id;
    Status(Double id){
        this.id=id;
    }

    public Double getId() {
        return id;
    }

    public static Status getByCode(double code){
        Status findStatus= Status.ACTIVE;
        for(Status status: Status.values()){
            if (status.id==code){
                findStatus=status;
            }
        }
        return findStatus;
    }
}
