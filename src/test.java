public class test {
    int a = 30;
    char ch[] = {'a','b','c'};
    public static void main(String[] args) {
        test t = new test();
        test.exchange(t.a, t.ch);
        System.out.println(t.a);
        System.out.println(t.ch);
    }
    public static void exchange(int str, char[] ch){
        str = 20;
        ch[0] = 'g';
    }

}
