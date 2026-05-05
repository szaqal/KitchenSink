package szaql.demo.tasks.books;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.Callable;

import static java.net.http.HttpClient.Version.HTTP_1_1;


public class PullBookTask implements Callable<String> {

    private final Book book;
    public PullBookTask(Book book) {
        this.book = book;
    }


    @Override
    public String call() throws Exception {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(book.url())).build();
        HttpResponse<byte[]> send = PullBookClient.client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        byte[] body = send.body();
        System.out.printf("Pulled %d bytes\n", body.length);
        return new String(body);
    }
}
