/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package eventstore.app;

import eventstore.app.services.SchemaService;
import eventstore.list.LinkedList;

import static eventstore.utilities.StringUtils.join;
import static eventstore.utilities.StringUtils.split;
import static eventstore.app.MessageUtils.getMessage;
import static java.lang.System.out;

import io.helidon.common.media.type.MediaType;
import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.config.spi.ConfigSource;
import io.helidon.http.Method;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRoute;
import org.apache.commons.text.WordUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

import io.helidon.common.media.type.MediaTypes;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        out.println(WordUtils.capitalize(result));
        Config config = Config.create();
        WebServer.builder()
                .config(config.get("server"))
                .routing(it -> it
                        .get("/hello", (req, res) -> {
                            var content = req.content();
                            out.println(req.content());

                            var hasEntity = content.hasEntity();
                            out.println(hasEntity);
                            if (hasEntity) {
                                out.println(content.as(String.class));
                            }
                            out.println(req.toString());
                            var nameQueryParam = "unnamed";
                            if (req.query().first("name").isPresent()) {
                                nameQueryParam = req.query().get("name");
                            }
                            res.send("Hello World! How are you ? " + nameQueryParam);
                        })
                        .route(HttpRoute.builder()
                                .path("/hello")
                                .methods(Method.POST, Method.PUT)
                                .handler((req, res) -> {
                                    String requestEntity = req.content().as(String.class);
                                    res.send(requestEntity);
                                }))
                )
                .routing(it -> it.register("/schemas", new SchemaService()))

                .build()
                .start()
        ;
    }
}
