//C3 = 2 String
//C17 = 1 Вивести всі речення заданого тексту в порядку зростання кількості слів у них.

public class lab3 {
    public static void main(String[] args) {
        String str = "Hrgknveriugnj, ferg wegfwe gwe. Wgredgbverdgver! Gergregreag, rweg sreth. Ergregserbserdbdv egve?";
        String[] sentences = str.split("[.!&?]+");
        char[] senEnd = new char[sentences.length];
        int[] senLen = new int[sentences.length];
        int pos = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.' || str.charAt(i) == '!' || str.charAt(i) == '&' || str.charAt(i) == '?') {
                senEnd[pos] = str.charAt(i);
                pos++;
            }
        }

        for (int i = 0; i < sentences.length; i++) {
            if (i > 0) {
                senLen[i] = sentences[i].split("[, ]+").length-1;
            } else {
                senLen[i] = sentences[i].split("[, ]+").length;
            }
        }

        for (int i = sentences.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(senLen[j] > senLen[j+1]) {
                    int tmp0 = senLen[j];
                    char tmp1 = senEnd[j];
                    String tmp2 = sentences[j];
                    senLen[j] = senLen[j+1];
                    senLen[j+1] = tmp0;
                    senEnd[j] = senEnd[j+1];
                    senEnd[j+1] = tmp1;
                    sentences[j] = sentences[j+1];
                    sentences[j+1] = tmp2;
                }
            }
        }

        for (int i = 0; i < sentences.length; i++) {
            System.out.print(sentences[i]);
            System.out.print(senEnd[i]);
            System.out.print(" ");
        }

    }
}

