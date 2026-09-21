package Spark11Sample;

import static spark.Spark.*;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {
        port(18080);
        post("/hello", (req, res) -> {
            JSONObject body = new JSONObject(req.body());
            return "Hello " + body.getString("name");
        });
    }
}
