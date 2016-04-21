package cashArm.app;

import java.text.DecimalFormat;

/**
 * Created by Admin on 16.10.14.
 */
public class AppFormating {

    public static void main(String[] args) {
        Double number=1239081715290781.123;
        DecimalFormat df2 = new DecimalFormat( "#" );
        System.out.println(df2.format(number));
    }
}

