import java.time.ZonedDateTime;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/15 15:34
 * Description:
 */
public class GetDate {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        // 2022-06-15T15:35:02.075+08:00[Asia/Shanghai]
        System.out.println(zonedDateTime);

    }
}
