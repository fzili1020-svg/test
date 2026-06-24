import java.util.Scanner;

public class stringtostring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取字符串长度
        int n = Integer.parseInt(scanner.nextLine().trim());

        // 读取字符串 s 和 t，确保使用 nextLine() 来读取整行
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        // 检查长度是否匹配
        if (s.length() != n || t.length() != n) {
            System.out.println("Error: The lengths of s and t do not match the specified length n.");
            return;
        }

        // 调用转换方法
        String result = transformStrings(s, t);

        // 输出结果
        System.out.println(result);

        // 关闭扫描器
        scanner.close();
    }

    public static String transformStrings(String s, String t) {
        StringBuilder result = new StringBuilder();
        int n = s.length(); // 使用 s 的实际长度

        for (int i = 0; i < n; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (Character.isUpperCase(charS)) {
                // 大写字母，输出 t 中对应字符的大写形式
                result.append(Character.toUpperCase(charT));
            } else if (Character.isLowerCase(charS)) {
                // 小写字母，输出 t 中对应字符的小写形式
                result.append(Character.toLowerCase(charT));
            } else if (Character.isDigit(charS)) {
                // 数字，输出 t 中对应字符的 ASCII 码
                result.append((int) charT);
            } else {
                // 其他字符，输出下划线
                result.append('_');
            }
        }

        return result.toString();
    }
}
