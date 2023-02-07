package yours.tool.springboot.helper.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: mapper 拓展
 * @Author： wbh
 * @Data 2021/9/9 10:59
 * @Version: v1.0
 **/
public interface EasyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 批量插入 仅适用于mysql
     * @param entityList 实体列表
     * @return 影响行数
     */
    Integer insertBatchSomeColumn(List<T> entityList);
}
