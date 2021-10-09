package mrPang.hobbyWeb.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mrPang.hobbyWeb.core.dto.Summoner;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {
    ObjectMapper objectMapper = new ObjectMapper();
    Summoner summoner = null;

    @Override
    public void getSummonerInfo(String name) {

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

    }

    @Override
    public String setSummonerPid() {
        return null;
    }

    @Override
    public String setSummonerEid() {
        return null;
    }
}
