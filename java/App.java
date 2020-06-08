package SparkSample;

import static spark.Spark.*;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {
	port(5000);
        post("/hello", (req, res) -> {
        	JSONObject body = new JSONObject(req.body());
        	return "Hello " + body.getString("name");
        });
    }
}
