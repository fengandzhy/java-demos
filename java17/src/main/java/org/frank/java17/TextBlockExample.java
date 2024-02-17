package org.frank.java17;

/**
 * 使用文本块之前，多行字符串常常需要使用转义序列和字符串连接，这既繁琐又容易出错。
 * 文本块通过三个双引号（"""）标记开始和结束，允许字符串跨越多行，无需额外的转义，保留了字符串的格式。
 * */
public class TextBlockExample {
    public static void main(String[] args) {
        String json = """
              {
                "name": "John",
                "age": 30,
                "car": null
              }
              """;
        System.out.println(json);
    }
}
