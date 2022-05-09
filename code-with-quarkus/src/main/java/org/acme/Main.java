package org.acme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Main {
    public static void main(String[] args) throws IOException {
        for (int j = 0; j < 10; j++) {
            StringBuilder sb = new StringBuilder();
            sb.append("""
                    package org.acme;

                    import javax.ws.rs.GET;
                    import javax.ws.rs.Path;
                    import javax.ws.rs.Produces;
                    import javax.ws.rs.core.MediaType;

                    @Path("/apiNB")
                    public class GreetingResourceNB {

                            """.replace("NB", j + ""));

            var a = """
                        @Path("/hello")
                        @GET
                        @Produces(MediaType.APPLICATION_JSON)
                        public String hello() {
                            return "{\\"z\\":\\"hello\\"}";
                        }

                    """;
            for (int i = 0; i < 1000; i++) {
                sb.append(a.replace("hello", "hello" + i));
            }
            sb.append("}");

            Files.writeString(Path.of(
                    "/home/damien/source/repos/quarkus/code-with-quarkus/src/main/java/org/acme/GreetingResource%s.java"
                            .formatted(j)),
                    sb);
        }
    }
}