package cashArm.bbeans;

import cashArm.Common.OEntityes.main.OContract;
import cashArm.Contract4Search;
import cashArm.bbeans.wrapers.AbstractContractWrapper;
import cashArm.bbeans.wrapers.FLContract;
import cashArm.bbeans.wrapers.ULContract;
import cashArm.onyma.DAO.PaymentDAO;
import cashArm.onyma.Services.ContractService;
import cashArm.onyma.common.DataChunk;
import org.primefaces.event.CloseEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Admin on 14.08.14.
 */

@Named
@SessionScoped
public class ContractManager implements Serializable{

    @Inject
    private DecoratedContractFactory decoratedContractFactory;
    @Inject
    private PaymentDAO paymentDAO;
    @Inject
    private ContractFinder contractFinder;
    @Inject
    private ContractService contractService;
    @Inject
    private PaymentFactory paymentProcessor;
    private PaymentReceipt paymentReceipt;
    private AbstractContractWrapper currentContract;
    @PostConstruct
    public void init(){

    }


//    @Size(min = 9, max = 9,message = "Должно быть девять цифр")
//    @Pattern(regexp = "[0-9]{9}", message = "Должно быть девять цифр")
    private String dogCode;
    public String getDogCode() {
        return dogCode;
    }

    public void setDogCode(String dogCode) {

//        this.dogCode = dogCode;
//        if (dogCode!=null){
//            currentContract = AbstractContractWrapper.getContract(contractService.getFullContract(dogCode));
//
//        }
//        newPayment();
    }

    public AbstractContractWrapper getContract(){
        return currentContract;
    }

    public ULContract getULContract(){
        ULContract contract = (currentContract!=null && currentContract.isFl())?((ULContract)currentContract):null;
        return contract;
    }
    public FLContract getFLContract(){
        FLContract contract = (currentContract!=null && currentContract.isFl())?((FLContract)currentContract):null;
        return contract;
    }


    public void closePayDialogAction(CloseEvent event) {
        newPayment();
    }

    public void newPayment(){
        paymentReceipt=paymentProcessor.newPayment(currentContract);

    }
    public PaymentReceipt getPayment() {

        return paymentReceipt;
    }

    public String getTime(){
        return "Текущее время "+(new Date());
    }

    private Contract4Search target;

    public Contract4Search getTarget() {
        return target;
    }

    public void setTarget(Contract4Search target) {
        if (target!=null && target.getCode()!=null){
            currentContract = decoratedContractFactory.decorateContract(contractService.getFullContract(target.getCode()));
        }
        this.target = target;
    }

    public void eraseFields(){
        setTarget(null);
    }

    String targetString;

    public String getTargetString() {

        return targetString;
    }



    public void setTargetString(String targetString) {
        this.targetString=targetString;
//        Contract4Search contract4Search=contractFinder.getItemsMap().get(targetString);
//        setTarget(contract4Search);
    }

    private List<AbstractContractWrapper> contractList;

    public int findContract(){
        String keyString=getTargetString();
        DataChunk<OContract> dataChunk;
        String dogCode = contractFinder.getDogCode(keyString);
        if (dogCode==null){
            dogCode=keyString;
        }
        if(keyString!=null && keyString.length()>5){
            dataChunk=contractService.getListByPatternPartly(dogCode,10,0);
        }else {
            dataChunk=new DataChunk<OContract>();
        }

        contractList=decorateContracts(dataChunk);

//        message2growl("Received string is  "+keyString);
//        message2growl("Dog code is "+dogCode);
//        message2growl("contracts found"+contractList.size());
        return contractList.size();
    }

    private List<AbstractContractWrapper> decorateContracts(List<OContract> oContractList){
        List<AbstractContractWrapper> decorated = new ArrayList<AbstractContractWrapper>();
        if (oContractList!=null){
            for(OContract oContract:oContractList){
                decorated.add(decoratedContractFactory.decorateContract(oContract));
            }
        }
        return decorated;
    }

    public DataChunk<OContract> findContractList(String keyString){
        DataChunk<OContract> contractList = new DataChunk<OContract>();
        contractList = contractService.getListByPatternPartly(keyString,10,0);
        return contractList;
    }

    public void message2growl(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",   message) );

    }

    public void clearTargetString(){
        setTargetString("");
    }

    public AbstractContractWrapper getCurrentContract(){
        return currentContract;
    }

    public boolean getContractListEmpty(){
        return getContractList() == null || getContractList().isEmpty();
    }

    public List<AbstractContractWrapper> getContractList(){
        return contractList;
    }
}
