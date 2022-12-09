/**
 * 枚举源码
 * @author bin
 * @date 2022-11-29-15:40
 */
public class _Enum {

    public static void main(String[] args) {
        System.out.println(City.BEIJING.name);
        System.out.println(MyCity.BEIJING.name);
    }
}
/**
 * 枚举是一个特殊的类
 */
class MyCity {
    public String name;
    public int code;

    private MyCity(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static final MyCity BEIJING = new MyCity("北京", 1001);
    public static final MyCity SHANGHAI = new MyCity("上海", 1002);
}


enum City {
    BEIJING("北京", 1001), SHANGHAI("上海", 1002);

    public String name;
    public int code;

    City(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
