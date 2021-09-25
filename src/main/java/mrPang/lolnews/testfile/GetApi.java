package mrPang.lolnews.testfile;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

@Controller
public class GetApi {

    @ResponseBody
    @RequestMapping("/getapi")
    public String callAPI() throws JsonProcessingException {

        String name = "욕하면우물후카톡";
        String SummonerName = name.replaceAll(" ", "%20");
//        String requestURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ SummonerName + "?api_key=" + Key.API_KEY;


        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(5000); // 읽기시간초과, ms
        factory.setConnectTimeout(3000); // 연결시간초과, ms
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100) // connection pool 적용
                .setMaxConnPerRoute(5) // connection pool 적용
                .build();
        factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
        RestTemplate restTemplate = new RestTemplate(factory);
        String url = "http://testapi.com/search?text=1234"; // 예제니까 애초에 때려박음..
//        Object obj = restTemplate.getForObject("요청할 URI 주소", "응답내용과 자동으로 매핑시킬 java object");
//        System.out.println(obj);

        return "ok";
    }
}
