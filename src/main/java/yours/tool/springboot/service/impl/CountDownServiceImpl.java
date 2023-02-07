package yours.tool.springboot.service.impl;

import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yours.tool.springboot.mapper.CountDownMapper;
import yours.tool.springboot.pojo.dto.CountDownDto;
import yours.tool.springboot.pojo.entity.CountDown;
import yours.tool.springboot.service.CountDownService;

import java.util.stream.Collectors;

/**
 * @description: 倒计时
 * @author：wbh
 * @data 2023/2/2 16:16
 * @version: v1.0
 **/
@Service
public class CountDownServiceImpl implements CountDownService {

    private static Logger logger = LoggerFactory.getLogger(CountDownServiceImpl.class);
    @Autowired
    private CountDownMapper countDownMapper;

    @Override
    public void addCountDown(CountDownDto countDownDto) {
        CountDown countDown = new CountDown();
        countDown.setCountDownId(IdUtil.getSnowflakeNextId());
        countDown.setUserId(1L);
        countDown.setSubject(countDownDto.getSubject());
        countDown.setType(countDownDto.getType());
        countDown.setDate(countDownDto.getDate());
        countDown.setLabel(countDownDto.getLabel().stream().collect(Collectors.joining("|")));
        countDown.setMoney(countDownDto.getMoney());
        countDownMapper.insert(countDown);
    }
}
