package mrPang.hobbyWeb.testfile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mrPang.hobbyWeb.core.dto.Summoner;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@Controller
public class GetApi {

    ObjectMapper objectMapper = new ObjectMapper();
    Summoner summoner = null;
    @ResponseBody
    @RequestMapping("/getapi")
    public String callAPI() throws JsonProcessingException {

        String name = "20171228";
        String api_key = "RGAPI-e68c05a4-c16d-4af7-b8af-e3823c53d11f";
        String SummonerName = name.replaceAll(" ", "%20");
        String requestURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ SummonerName + "?api_key=" + api_key;


        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100) // connection pool 적용
                .setMaxConnPerRoute(5) // connection pool 적용
                .build();

        HttpGet getRequest = new HttpGet(requestURL); //GET 메소드 URL 생성
        try {
            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                summoner = objectMapper.readValue(body, Summoner.class);   // String to Object로 변환
                log.info(summoner.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "ok";
    }
}
