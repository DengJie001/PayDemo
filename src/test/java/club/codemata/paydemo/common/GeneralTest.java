package club.codemata.paydemo.common;

import club.codemata.paydemo.utils.UUIDUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class GeneralTest {
    @Test
    public void testUUID() {
        System.out.println(UUIDUtils.getId());
    }
}
