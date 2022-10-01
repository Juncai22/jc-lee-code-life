package 数学思维2;


/**
 * 1616. 分割两个字符串得到回文串
 * LeeCode 1616
 * 难度 ： 中等
 */
public class LeeCode1616TOCHANGE {

    public static void main(String[] args) {
        checkPalindromeFormation("khekdvakkkggbopatnbtcbbqkntplzoqectgexifhinhsjohplfebkynpxkraayuythwgbwvzqzprhapxgevfnmexkkutaybuspnmkztgxryipgxlowdsnmqlsslnxupsvsbttxdlgvjvrbxnqezowacfplqkzubwduirbgmjzkdmpwctoowzcsjbaoiumsthvgcagvsihjqgbfjejhtspyrdsmoabvmrgmtshraxgmwknmijgypvgmgfqcytumqcqhgiuihbkcrcehnglsoxegdailsjlibsfnyeoejeltxsvtubakuvskokudtgkbhaab",
                "baahbkgtdukoksvukabutvsxtlejeoeynfsbilqwuqnbpyzmlttjzewwcgvcmaqlsosagpztvpbbxkxsclcashgzstktuuernbmymfkfpalyprnmzeakyyruodavblsyxohctqzcknefhucfdpsntixoczieytxeaqaextyeizcoxitnspdfcuhfenkczqtchoxyslbvadouryykaezmnrpylapfkfmymbnreuutktszghsaclcsxkxbbpvtzpgasoslqamcvgcwwezjttlmzypbnquwqhgcqjqzjrfhcfloqdrpvggnupsizifdzeqpvbz");

    }

    public static boolean checkPalindromeFormation(String a, String b) {
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();
        int left = 0;
        int length = stra.length;
        while (left<=length/2){
            if (stra[left]==strb[length-1-left])
                left++;
            else
                break;
        }
        //如果超过一半都是相等的，直接返回true
        if (left>=length/2)
            return true;
        //否则判断中间未遍历的部分是否是回文
        if (isPa(a.substring(left,length-left)) || isPa(b.substring(left,length-left)))
            return true;
        return false;
    }

    //判断是否回文
    private static boolean isPa(String string){
        char[] str  =string.toCharArray();
        for (int i=0;i<str.length/2;i++){
            if (str[i]!=str[str.length-1-i])
                return false;
        }
        return true;
    }
}
