package cashArm.onyma.DAO.Adapters;

import ru.onyma.www.services.OnymaApi.types.O_mdb_api_client_services_return_row;
import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OConnection;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class ApiRow2ConnectionAdapter extends OConnection implements Serializable {
//    <complexType name="o_mdb_api_client_services_return_row">
     private O_mdb_api_client_services_return_row returnRow;
    public ApiRow2ConnectionAdapter(OAuthName authName,O_mdb_api_client_services_return_row returnRow){
        super(authName);
        this.returnRow=returnRow;
    }
    public ApiRow2ConnectionAdapter(O_mdb_api_client_services_return_row returnRow){
        super(null);
        this.returnRow=returnRow;
    }

//    @Override     public OResources getResource(){
//        return OResources.getByCode(g);
//    }


    @Override
    public String getConn_name() {
        return returnRow.getConn_name();
    }

    @Override
    public Date getDadd() {
        return returnRow.getDadd()==null?null:returnRow.getDadd().getTime();
    }

    @Override
    public Double getDmid() {
        return returnRow.getDmid();
    }

    @Override
    public Double getDogid() {
        return returnRow.getDogid();
    }

    @Override
    public Date getEnddate() {
        return returnRow.getEnddate()==null?null:returnRow.getEnddate().getTime();
    }

    @Override
    public Date getEnddatetime() {
        return returnRow.getEnddatetime()==null?null:returnRow.getEnddatetime().getTime();
    }

    @Override
    public Double getGid() {
        return returnRow.getGid();
    }

    @Override
    public Double getId() {
        return returnRow.getId();
    }

    @Override
    public String getLastop() {
        return returnRow.getLastop();
    }

    @Override
    public String getName() {
        return returnRow.getName();
    }

    @Override
    public String getNotes() {
        return returnRow.getNotes();
    }


    @Override
    public Double getService() {
        System.out.println("Wrapper get service, service id is " + returnRow.getService() );
        return returnRow.getService();
    }

    @Override
    public String getShared() {
        return returnRow.getShared();
    }

    @Override
    public Date getStartdate() {
        return returnRow.getStartdate()==null?null:returnRow.getStartdate().getTime();
    }

    @Override
    public Date getStartdatetime() {
        return returnRow.getStartdatetime()==null?null:returnRow.getStartdatetime().getTime();
    }

    @Override
    public Double getStatus() {
        return returnRow.getStatus();
    }

    @Override
    public Double getStatus_qualif() {
        return returnRow.getStatus_qualif();
    }

    @Override
    public Double getTmid() {
        return returnRow.getTmid();
    }

}
