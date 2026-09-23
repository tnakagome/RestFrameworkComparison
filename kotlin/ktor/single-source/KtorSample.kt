import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.engine.*

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*

import kotlinx.serialization.Serializable

@Serializable
class Greeting {
    val name: String = ""
}

fun main(args: Array<String>) {
    embeddedServer(Netty, 18080) {
        install(ContentNegotiation) {
            json()
        }

        install(StatusPages) {
            exception<Throwable> { call, cause ->
                val stackTrace = cause.stackTraceToString()
                call.respondText(
                    text = """
                        |Error: ${cause.message}
                        |Type: ${cause::class.simpleName}
                        |
                        |Stack trace:
                        |$stackTrace
                    """.trimMargin(),
                    status = HttpStatusCode.InternalServerError,
                    contentType = ContentType.Text.Plain
                )
            }
        }

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
    }.start(wait = true)
}
