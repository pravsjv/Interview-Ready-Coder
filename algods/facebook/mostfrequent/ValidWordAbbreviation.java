package algods.facebook.mostfrequent;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int wordLen = word.length();
        int abbrLen = abbr.length();

        int wordIndex = 0;
        int abbrIndex = 0;

        while(wordIndex<wordLen && abbrIndex<abbrLen){
            char wordChar = word.charAt(wordIndex);
            char abbrChar = abbr.charAt(abbrIndex);

            if(Character.isDigit(abbrChar)){
                if(abbrChar == '0')
                    return false;
                int start = abbrIndex;
                while(abbrIndex<abbrLen && Character.isDigit(abbr.charAt(abbrIndex))){
                    abbrIndex++;
                }
                int val = Integer.parseInt(abbr.substring(start,abbrIndex));
                wordIndex += val;
            } else {
                if(wordChar != abbrChar)
                    return false;
            }
            wordIndex++;
            abbrIndex++;
        }
        return wordIndex==wordLen && abbrIndex==abbrLen;
    }

    public static void main(String[] args) {
        String word = "substitution";
        String abbr = "s10n";

        ValidWordAbbreviation obj = new ValidWordAbbreviation();
        System.out.println(obj.validWordAbbreviation(word, abbr));
    }
}
