package mrPang.lolnews.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rank")
public class rankController {

    @GetMapping("/lck")
    public String postLckRank() {


        return "index";
    }
}
