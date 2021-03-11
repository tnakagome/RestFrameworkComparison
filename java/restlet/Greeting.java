package RestletSample;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class Greeting extends ServerResource {
    String userName;

    /*
     * for a GET request
     */
    @Override
    public void doInit() {
        this.userName = (String) getRequestAttributes().get("user");
    }

    @Get
    public String toString() {
        return "Hello " + this.userName + "!";
    }

    @Post
    public String represent(Representation entity) {
        JSONObject json = new JsonRepresentation(getRequest().getEntityAsText()).getJsonObject();
        return "Hello " + json.get("name");
    }
}
