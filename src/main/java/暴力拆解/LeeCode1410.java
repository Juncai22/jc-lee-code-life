package 暴力拆解;


/**
 * 1410. HTML 实体解析器
 * LeeCode 1410
 * 难度 ： 简单
 */
public class LeeCode1410 {

    public String entityParser(String text) {
        //replaAll一把搓
        return text
                .replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/")
                .replaceAll("&amp;", "&");
    }
}
