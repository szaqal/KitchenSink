package szaql.demo.tasks.books;

import java.net.http.HttpClient;
import java.time.Duration;

import static java.net.http.HttpClient.Version.HTTP_1_1;

public class PullBookClient {

    final static HttpClient client = HttpClient.newBuilder()
            .version(HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
}
