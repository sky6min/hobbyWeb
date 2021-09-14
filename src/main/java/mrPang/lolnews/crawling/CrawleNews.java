package mrPang.lolnews.crawling;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;


@Controller
@EnableScheduling
public class CrawleNews {

    @SneakyThrows
    @Scheduled(cron = "10 * * * * *")
    public void run() {
        String url = "https://game.naver.com/esports/record/lck/team/lck_2021_summer";
        Document document = Jsoup.connect(url).get();
        Elements listTeamElements = document.getElementsByClass("record_list_wrap_team__215Gz");
        for (Element element : listTeamElements) {
            System.out.println(element);
        }
    }
}
