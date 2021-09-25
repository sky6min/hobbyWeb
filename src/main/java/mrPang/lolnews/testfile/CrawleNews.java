package mrPang.lolnews.testfile;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Controller
public class CrawleNews {
    private static String url = "https://game.naver.com/esports/record/lck/team/lck_2021_summer";

    @ResponseBody
    @RequestMapping("/craw")
    public String run(){
        log.info("aaaaaaaaaaaa");
        try {
            Document document = Jsoup.connect(url).get();
            Elements imageUrlElements = document.getElementsByClass("record_list_rank__3mn_o");

            for (Element element : imageUrlElements) {
                System.out.println(element);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
