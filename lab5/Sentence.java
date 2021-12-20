public class Sentence {
    private static String punctuationSymbols = ",.!?;-—";
    private static String sentence;
    private SentenceMember[] sentenceMembers;

    public Sentence(String s) {
        sentence = s;
        String[] split = s.split("(?=,|\\.|!|\\?)|\\s");
        sentenceMembers = new SentenceMember[split.length];
        for (int i = 0; i < split.length; i++) {
            if (punctuationSymbols.contains(split[i])) {
                sentenceMembers[i] = new Punctuation(split[i]);
            } else {
                sentenceMembers[i] = new Word(split[i]);
            }
        }
    }

    public int countOfWords() {
        int i = 0;
        String[] split = sentence.split("(?=,|\\.|!|\\?)|\\s");
        for (int j = 0; j < split.length; j++) {
            if (punctuationSymbols.contains(split[j])) {
                i++;
            }
        }
        return split.length - i;
    }

    public String toString() {
        String result = "";
        SentenceMember currentSentenceMember;
        for (int i = 0; i < sentenceMembers.length; i++) {
            currentSentenceMember = sentenceMembers[i];
            result +=
                    (currentSentenceMember instanceof Word && i != 0 ?
                            " " : "") +
                            sentenceMembers[i].toString();
        }
        return result;
    }
}