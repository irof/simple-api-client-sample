package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author irof
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${sample.api.url}")
    String apiUrl;

    @Value("${sample.userId}")
    String userId;


    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        Timeline timeline = new RestTemplate()
                .getForObject(apiUrl + "/timeline", Timeline.class);
        model.addAttribute(timeline);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(@RequestParam String text) {
        logger.info("post text: {}", text);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userId", userId);
        map.add("text", text);

        Tweet tweet = new RestTemplate().postForObject(apiUrl + "/post", map, Tweet.class);
        logger.info(tweet.toString());
        return "redirect:/";
    }

    @RequestMapping("icon/{userId}")
    @ResponseBody
    public byte[] icon(@PathVariable("userId") String userId) {
        return new RestTemplate().getForObject(apiUrl + "/icon/" + userId, byte[].class);
    }
}