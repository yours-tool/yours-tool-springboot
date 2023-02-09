package yours.tool.springboot.service;

import yours.tool.springboot.pojo.base.PageVo;
import yours.tool.springboot.pojo.dto.CountDownDto;
import yours.tool.springboot.pojo.dto.CountDownListDto;
import yours.tool.springboot.pojo.dto.CountDownUpdateDto;
import yours.tool.springboot.pojo.vo.CountDownListVo;
import yours.tool.springboot.pojo.vo.CountDownVo;

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

    /**
     * 查看倒计时详情
     * @param countDownId
     * @return
     */
    CountDownVo detail(String countDownId);

    /**
     * 修改倒计时
     * @param countDownUpdateDto
     */
    void update(CountDownUpdateDto countDownUpdateDto);

    /**
     * 删除
     * @param countDownId
     */
    void delete(String countDownId);
}
