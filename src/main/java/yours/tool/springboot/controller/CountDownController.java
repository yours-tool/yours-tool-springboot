package yours.tool.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import yours.tool.springboot.helper.response.ResultResponse;
import yours.tool.springboot.pojo.dto.CountDownDto;
import yours.tool.springboot.service.CountDownService;

import javax.validation.Valid;

/**
 * @description: 倒计时控制
 * @author：wbh
 * @data 2023/2/2 11:19
 * @version: v1.0
 **/
@Controller
@RequestMapping("countDown")
public class CountDownController {

    @Autowired
    private CountDownService countDownService;

    @PostMapping(value = "add")
    public ResultResponse<Void> addCountDown(@RequestBody @Valid CountDownDto countDownDto) {
        countDownService.addCountDown(countDownDto);
        return ResultResponse.ofSuccess(null);
    }
}
