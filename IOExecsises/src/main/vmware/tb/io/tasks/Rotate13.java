package main.vmware.tb.io.tasks;

public class Rotate13 {

    /**
     * Shifts each of the Latin letters in a given string by 13 positions if null or black string is
     * provided as input the method throw an @IllegalArgumentException Example: "Test" -> "Grfg" ,
     * "amnz" -> "nzam", "talentboost" -> "   "​
     *
     * @param text the string that will be rotated
     * @return the rotated version of the text
     */
    public String rotate(String text) {
        if(text == null) {
            throw new IllegalArgumentException();
        }

        if(text.strip().equals("")) {
            throw new IllegalArgumentException();
        }
        String result = "";

        for(char c : text.toCharArray()) {
            //if(c >= 'A' && c <= 'M' || c <= 'a')

            int asciiValue = c + 13;
            result += (char)asciiValue;
        }

        return result;
    }
}
