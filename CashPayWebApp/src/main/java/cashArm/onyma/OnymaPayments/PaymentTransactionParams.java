package cashArm.onyma.OnymaPayments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.12.13
 * Time: 9:23
 * To change this template use File | Settings | File Templates.
 */
public class PaymentTransactionParams {
    public static final String DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ss";
    public enum Args {
        TYPE("type="),
        AMOUNT("amount="),
        RECEIPT("receipt="),
        DATE("date="),
        COMMENT("comment="),
        NUMBER("number=");
        private String tag;
        Args(String tag){
           this.tag=tag;
        }

        public String getTag() {
            return tag;
        }
    }
    private String type;
    private Double amount;
    private String receipt;
    private Calendar date;
    private String number;
    private String comment;
    public PaymentTransactionParams(String[] args) throws ParseException{
        if (args.length==1){
           args=parseUrl(args[0]);
        }
        String parseErrors=null;
        Map<Args,String> agsMap = parseParams(args);
        setType(agsMap.get(Args.TYPE));
        setReceipt(agsMap.get(Args.RECEIPT));
        setNumber(agsMap.get(Args.NUMBER));
        setComment(agsMap.get(Args.COMMENT));
        try{
            setDate(agsMap.get(Args.DATE));
        }catch (ParseException e){
           String error="<DATE_PARSING_ERROR><EXPECTED>"+ DATE_FORMAT+"</EXPECTED><RECEIVED>"+agsMap.get(Args.DATE)+"</RECEIVED>/<DATE_PARSING_ERROR>";
            parseErrors=parseErrors==null?error:parseErrors+"\n"+error;
        }
        try{
            setAmount(agsMap.get(Args.AMOUNT));
        }catch (ParseException e){
            String error="<AMOUNT_PARSING_ERROR><RECEIVED>"+agsMap.get(Args.AMOUNT)+"</RECEIVED>/<AMOUNT_PARSING_ERROR>";
            parseErrors=parseErrors==null?error:parseErrors+"\n"+error;
        }
        if (parseErrors!=null){
            throw new PayParamParseException(parseErrors,0);

        }

    }

    private String[] parseUrl(String url){
      url=url.substring(url.indexOf('?'));
      return url.split("&");
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        System.out.println("coment is "+comment);
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setAmount(String amount)  throws ParseException {
        this.amount = amount==null?null:Double.valueOf(amount);
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setDate(String date) throws ParseException{
        this.date = date==null?null:string2Calendar(date);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private static Map<Args,String> parseParams(String[] args){
        Map<Args,String> argsMap=new HashMap<Args, String>();
        argsMap.put(Args.TYPE,null);
        argsMap.put(Args.AMOUNT,null);
        argsMap.put(Args.RECEIPT,null);
        argsMap.put(Args.DATE,null);
        argsMap.put(Args.NUMBER,null);
        argsMap.put(Args.COMMENT,null);
        for(String arg:args){
            for(Args param:argsMap.keySet()){
                if(arg.matches(param.getTag()+".*")){
                    argsMap.put(param,arg.replaceAll(param.getTag(),""));
                }
            }
        }
        return argsMap;
    }


    private Calendar string2Calendar(String data) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        cal.setTime(sdf.parse(data));
        return cal;
    }

}
