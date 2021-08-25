package club.codemata.paydemo.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");
        return id;
    }
}
