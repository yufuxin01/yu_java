import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Classname AopApplication
 * @Date 2021/4/6 15:40
 * @Created by yufx
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class EasyExcelApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class, args);
    }

}
