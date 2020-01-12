import com.itw.learn.MyAppDemo;
import com.itw.learn.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAppDemo.class)
public class SimpleTest {

    @Resource
	UserMapper userMapper ;

    @Test
	public  void test(){
		userMapper.selectOne("10");
	}
}