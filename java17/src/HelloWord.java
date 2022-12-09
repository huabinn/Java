/**
 * @author bin
 * @date 2022-11-28-10:24
 */
public class HelloWord {

    public static void main(String[] args) {
        Person person = new Person();
        person.test();

        System.out.println("Hello World!");

        test("binn", "bin");

        byte a = 1;

        test(a);
    }

    static void test(String ...names) {
        for (String name : names) {
            name = "inns";
            System.out.println(name);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }

    static void test(int a) {
        System.out.println("iii");
    }

    static void test(short a) {
        System.out.println("sss");
    }

}

class Person {
    public String name = "zhangsan";

    public void test() {
        String name = "lisi";

        System.out.println(this.name);
    }
}
