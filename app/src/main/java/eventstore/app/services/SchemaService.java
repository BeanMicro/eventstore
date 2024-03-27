package eventstore.app.services;

import io.helidon.common.media.type.MediaTypes;
import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.dbclient.DbClient;
import io.helidon.webserver.http.Handler;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class SchemaService implements HttpService {
    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new SchemasPostHandler());
        rules.post("/projects/{project}/contexts/{context}/aggregates/{aggregate}", (req, res) -> {
            res.send("Handled by /projects sub-path " + req.path().pathParameters().get("project"));

            var context = req.path().pathParameters().get("context");
            var aggregate = req.path().pathParameters().get("aggregate");

            // By default, this will pick up application.yaml from the classpath
            Config config = Config.global();

            Config dbConfig = config.get("db");
            DbClient dbClient = DbClient.create(dbConfig);

//            ObserveFeature observe = ObserveFeature.builder()
//                    .config(config.get("server.features.observe"))
//                    .addObserver(HealthObserver.builder()
//                            .addCheck(DbClientHealthCheck.create(dbClient, dbConfig.get("health-check")))
//                            .build())
//                    .build();

            //                    .createDmlStatement("CREATE DATABASE IF NOT EXISTS ?")
            dbClient.execute()
                    .createDmlStatement(
                            """
                                    CREATE SCHEMA IF NOT EXISTS %s;
                                    """.formatted(context)).execute();

            dbClient.execute()
                    .createDmlStatement(
                            """
                                    CREATE TABLE IF NOT EXISTS %s.events_%s
                                    (id INT PRIMARY KEY, name VARCHAR(255))
                                    """.formatted(context, aggregate)
                    )
//                    .params(context)
                    .execute();
        });
    }

    private static class SchemasPostHandler implements Handler {
        @Override
        public void handle(ServerRequest req, ServerResponse res) throws Exception {
            var content = req.content();
            out.println(req.content());
            var hasEntity = content.hasEntity();
            out.println(hasEntity);
            var cfg = Config.builder()
                    .disableSystemPropertiesSource()
                    .disableEnvironmentVariablesSource()
                    .disableFilterServices()
                    .disableMapperServices()
                    .disableValueResolving()
                    .disableKeyResolving()
                    .sources(
                            ConfigSources.create(
                                    """
                                            abc: def
                                            ghi:
                                              jkl: mno
                                            """,
                                    MediaTypes.APPLICATION_YAML
                            )
                    ).build();
            out.println("------");
            cfg.get("abc").asString().ifPresent(out::println);
            out.println("------++++++++");
            cfg.asMap().get().forEach((k, v) -> out.println(k + " : " + v));

            if (hasEntity) {
//                                out.println("Content: " + content.as(String.class));
                try (var is = content.inputStream()) {
                    byte[] buffer = new byte[256];
                    out.println("Read as bytes");
                    int readBytes = 0;
                    while ((readBytes = is.read(buffer)) != -1) {
                        Byte[] bytes = new Byte[readBytes];
                        Arrays.setAll(bytes, n -> buffer[n]);
                        String output = Arrays.stream(bytes).map(Character::toString).collect(Collectors.joining());
                        out.println(output);
                    }
                }
            }
            out.println(req.toString());
            var nameQueryParam = "unnamed";
            if (req.query().first("name").isPresent()) {
                nameQueryParam = req.query().get("name");
            }
            res.send("Hello SchemasPostHandler! How are you ? " + nameQueryParam);
        }
    }
}
