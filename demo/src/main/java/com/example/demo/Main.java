package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Main {
    public static void main(String[] args) throws IOException {
        for (int j = 0; j < 10; j++) {
            StringBuilder sb = new StringBuilder();
            sb.append("""
                    package com.example.demo;

                    import org.springframework.http.MediaType;
                    import org.springframework.web.bind.annotation.GetMapping;
                    import org.springframework.web.bind.annotation.RequestMapping;
                    import org.springframework.web.bind.annotation.RestController;

                    @RestController
                    @RequestMapping("apiNB")
                    public class DemoControllerNB {

                    """.replace("NB", j + ""));

            var a = """
                        @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
                        public String hello() {
                            return "{\\"z\\":\\"hello\\"}";
                        }

                    """;
            for (int i = 0; i < 1000; i++) {
                sb.append(a.replace("hello", "hello" + i));
            }
            sb.append("}");

            Files.writeString(
                    Path.of("/home/damien/eclipse-workspace/demo/src/main/java/com/example/demo/DemoController%s.java"
                            .formatted(j)),
                    sb);
        }
    }
}