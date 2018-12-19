import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sys.oauth2.TokenGenerator;
import net.chenlin.dp.modules.tyb.entity.HandanPaiHangEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class Tokentest {
    private final static Logger logger = LoggerFactory.getLogger(Tokentest.class);

    @Test
    public void contextLoads() {
        String token = TokenGenerator.generateValue();
        logger.debug("token验证===" + token);
//      new  OAuth2Token()
    }

    @Test
    public void JSONTest() {
        HandanPaiHangEntity entity = new HandanPaiHangEntity(1, "老师", "现货银", "2018年10月2号", "219.4", "56%", null, null);
        R data = CommonUtils.DataMsg(entity,"获取老师数据成功");

        logger.debug("token验证===" + data.toString());
    }
}
