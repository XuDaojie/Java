package io.github.xudaojie.springboot.rabbitmq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xdj on 2017/5/22.
 */
@RestController
public class RabbitController {

    @RequestMapping("/rabbit/setmsg")
    public String setMessage(@RequestParam("routing_key") String routingKey,
                           @RequestParam("msg") String msg) {
        return "setMsg";
    }
}
