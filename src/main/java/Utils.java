import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.concurrent.Executor;

public class Utils {


    // настраиваем наш HTTP клиент, который будет отправлять запросы
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    private static ObjectMapper mapper = new ObjectMapper();

    public static String getUrl(String uri) throws IOException {
        CloseableHttpResponse response = httpClient.execute(new HttpGet(uri));
        NasaObject nasaObject = mapper.readValue(response.getEntity().getContent(), NasaObject.class);
        return nasaObject.getUrl();
    }

}