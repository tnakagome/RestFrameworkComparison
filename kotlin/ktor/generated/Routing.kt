package KtorSample

import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/hi/{name}") {
            val name = call.parameters["name"]
            call.respondText("Hello, ${name}!")
        }
        post("/hello") {
            val greeting = call.receive<Greeting>()
            call.respondText("Hello, ${greeting.name}")
        }
    }
}