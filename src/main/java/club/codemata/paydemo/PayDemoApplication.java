package club.codemata.paydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("club.codemata.paydemo.**.mapper")
public class PayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayDemoApplication.class, args);
    }

}
