package yours.tool.springboot.start;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @description: 倒计时start
 * @author：wbh
 * @data 2023/2/8 11:41
 * @version: v1.0
 **/
@Component
public class CountDownStart implements ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(CountDownStart.class);


    @Override
    public void run(ApplicationArguments args) throws Exception {
        doFestival();
    }

    /**
     * 节假日
     */
    private void doFestival() {

    }

    public static void main(String[] args) {
        //今天
        DateTime today = DateUtil.date();
        //明年今天
        DateTime nextYearToday = DateUtil.offsetMinute(today, 12);
        ChineseDate chineseDate = new ChineseDate(DateUtil.parseDate("2015-1-1"));
        String festivals = chineseDate.getFestivals();
        System.err.println(festivals);
    }
}
