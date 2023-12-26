package com.vker.weblog.web.controller;

import com.vker.weblog.common.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Vker
 * @Date: 2023-12-26
 * @Description:
 */
@RestController
public class OneWordController {

    /**
     * one 一言
     *
     * @return
     */
    @GetMapping("/one")
    public Response<String> one() {
        return Response.success(new RestTemplate().getForObject(
                "https://v1.hitokoto.cn?c=d&c=h&c=i&c=k&c=j&encode=text", String.class));
    }

}
