public class Text {
    private Sentence[] sentences;
    private int[] counts;

    public Text(String s) {
        String[] split = s.split("(?<=[?!.]) ");
        sentences = new Sentence[split.length];
        counts = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            sentences[i] = new Sentence(split[i]);
            counts[i] = sentences[i].countOfWords();
            //System.out.println(sentences[i].countOfWords());
        }
    }

    public void sorting() {
        for (int i = counts.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (counts[j] > counts[j+1]) {
                    int tmp1 = counts[j];
                    Sentence tmp2 = sentences[j];
                    counts[j] = counts[j+1];
                    counts[j+1] = tmp1;
                    sentences[j] = sentences[j+1];
                    sentences[j+1] = tmp2;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.toString()).append(" ");
        }
        return result.toString();
    }
}