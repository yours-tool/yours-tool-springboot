package yours.tool.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yours.tool.springboot.mapper.CountDownMapper;
import yours.tool.springboot.pojo.base.PageVo;
import yours.tool.springboot.pojo.dto.CountDownDto;
import yours.tool.springboot.pojo.dto.CountDownListDto;
import yours.tool.springboot.pojo.dto.CountDownUpdateDto;
import yours.tool.springboot.pojo.entity.CountDown;
import yours.tool.springboot.pojo.vo.CountDownListVo;
import yours.tool.springboot.pojo.vo.CountDownVo;
import yours.tool.springboot.service.CountDownService;

import java.util.List;
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
    public void add(CountDownDto countDownDto) {
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

    @Override
    public PageVo<CountDownListVo> list(CountDownListDto countDownDto) {
        Page<CountDown> countDownListVoPage = new Page<>(countDownDto.getPage(), countDownDto.getSize());
        LambdaQueryWrapper<CountDown> countDownLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(countDownDto.getType())){
            countDownLambdaQueryWrapper.eq(CountDown::getType,countDownDto.getType());
        }
        if (StrUtil.isNotBlank(countDownDto.getContent())){
            countDownLambdaQueryWrapper.and(c->
                    c.like(CountDown::getSubject,countDownDto.getContent())
                    .or().like(CountDown::getLabel,countDownDto.getContent()));
        }
        countDownListVoPage = countDownMapper.selectPage(countDownListVoPage,countDownLambdaQueryWrapper);
        List<CountDownListVo> countDownListVos = BeanUtil.copyToList(countDownListVoPage.getRecords(), CountDownListVo.class);
        return new PageVo<>(countDownListVos, countDownListVoPage.getTotal());
    }

    @Override
    public CountDownVo detail(String countDownId) {
        CountDown countDown = countDownMapper.selectById(countDownId);
        CountDownVo countDownVo = BeanUtil.copyProperties(countDown, CountDownVo.class);
        return countDownVo;
    }

    @Override
    public void update(CountDownUpdateDto countDownUpdateDto) {
        CountDown countDown = new CountDown();
        countDown.setCountDownId(Convert.toLong(countDownUpdateDto.getCountDownId()));
        countDown.setUserId(1L);
        countDown.setSubject(countDownUpdateDto.getSubject());
        countDown.setType(countDownUpdateDto.getType());
        countDown.setDate(countDownUpdateDto.getDate());
        countDown.setLabel(countDownUpdateDto.getLabel().stream().collect(Collectors.joining("|")));
        countDown.setMoney(countDownUpdateDto.getMoney());
        countDownMapper.updateById(countDown);
    }

}
