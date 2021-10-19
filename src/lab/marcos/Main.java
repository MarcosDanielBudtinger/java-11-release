package lab.marcos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        connectAndPrintUrlJavaOracle();
    }

    private static void connectAndPrintUrlJavaOracle() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response =  httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code : " + response.statusCode());
        System.out.println("Headers : " + response.headers());
        System.out.println("body : " + response.body());
    }
}
