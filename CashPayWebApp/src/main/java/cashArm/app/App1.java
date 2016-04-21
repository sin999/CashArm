package cashArm.app;
import cashArm.onyma.Services.ContractService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Admin on 20.08.14.
 */
@Named
public class App1 {
    @Inject
    private ContractService contractService;


    public static void main(String[] args) {

        Weld weld = new Weld();

        WeldContainer container = weld.initialize();

        App1 app= container.instance().select(App1.class).get();
        app.run();

        weld.shutdown();

        String ttt = new String();
        ttt.equals(ttt);

    }

    public void run()  {
        System.out.println(contractService.test());
    }
}
