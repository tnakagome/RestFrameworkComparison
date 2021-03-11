package RestletSample;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        Component component = new Component();
        Application application = new App();

        component.getServers().add(Protocol.HTTP, 5000);
        component.getDefaultHost().attachDefault(application);
        component.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/hi/{user}", Greeting.class);
        router.attach("/hello", Greeting.class);
        return router;
    }
}
