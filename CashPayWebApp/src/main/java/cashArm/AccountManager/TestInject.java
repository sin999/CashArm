package cashArm.AccountManager;

import javax.inject.Named;

/**
 * Created by Admin on 13.08.14.
 */
@Named("testInject")

public class TestInject {

    public String getGreeting(){
        return  "The testInject class is working!";
    }
}
