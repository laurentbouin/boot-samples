package com.github.laurentbouin;

import com.github.javafaker.Faker;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * author lbouin
 * Date: 06/02/2016
 * Time: 11:38
 */
@RestController("/samples")
public class HiController {

    private static final String template = "Hello %s, I'm %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "hi", nickname = "hi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Buddy")
          })
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name, new Faker().name().firstName());
    }


}
