package yours.tool.springboot.service;

import yours.tool.springboot.pojo.base.PageVo;
import yours.tool.springboot.pojo.dto.CountDownDto;
import yours.tool.springboot.pojo.dto.CountDownListDto;
import yours.tool.springboot.pojo.vo.CountDownListVo;

/**
 * @description: 接口
 * @author：wbh
 * @data 2023/2/2 16:16
 * @version: v1.0
 **/
public interface CountDownService {

    /**
     * 添加倒计时
     * @param countDownDto
     */
    void add(CountDownDto countDownDto);

    /**
     * 查询列表
     * @param countDownDto
     * @return
     */
    PageVo<CountDownListVo> list(CountDownListDto countDownDto);
}
