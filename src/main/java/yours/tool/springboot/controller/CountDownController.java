package yours.tool.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yours.tool.springboot.helper.response.ResultResponse;
import yours.tool.springboot.pojo.base.PageVo;
import yours.tool.springboot.pojo.dto.CountDownDto;
import yours.tool.springboot.pojo.dto.CountDownListDto;
import yours.tool.springboot.pojo.vo.CountDownListVo;
import yours.tool.springboot.service.CountDownService;

import javax.validation.Valid;

/**
 * @description: 倒计时控制
 * @author：wbh
 * @data 2023/2/2 11:19
 * @version: v1.0
 **/
@Api(tags = "倒计时")
@RestController
@RequestMapping("countDown")
public class CountDownController {

    @Autowired
    private CountDownService countDownService;

    @PostMapping(value = "add")
    @ApiOperation(value = "添加")
    public ResultResponse<Void> add(@RequestBody @Valid CountDownDto countDownDto) {
        countDownService.add(countDownDto);
        return ResultResponse.ofSuccess();
    }

    @PostMapping(value = "list")
    @ApiOperation(value = "列表")
    public ResultResponse<PageVo<CountDownListVo>> list(@RequestBody @Valid CountDownListDto countDownDto) {
        return ResultResponse.ofSuccess( countDownService.list(countDownDto));
    }
}
