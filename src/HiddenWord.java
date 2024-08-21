public class HiddenWord {
    private String word;

    public HiddenWord(String word) {
        this.word = word.toUpperCase();
    }

    public String getHiddenWord(){
        return this.word;
    }

    public void setHiddenWord(String new_word){
        this.word = new_word.toUpperCase();

    }

    public String getHint(String guess) throws IllegalArgumentException{
        if (!guess.equals(guess.toUpperCase())){
            throw new IllegalArgumentException("Your guess ( "+ guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }
        if (guess.length() != this.word.length()){
            throw new IllegalArgumentException("Your guess ( "+guess+" ) has 7 characters. The hidden word has 9 characters. Your guess must be a word with 9 characters!");

        }

        String returned = "";
        for (int i=0; i<guess.length(); i++){
            if (guess.charAt(i) == this.word.charAt(i)){
                returned += guess.charAt(i);
            }
            else{
                boolean in_word = false;
                for (char c: this.word.toCharArray()){
                    if (c==guess.charAt(i)) in_word=true;
                }
                if (in_word) returned += '+';
                else returned += '*';
            }
        }
        return returned;
    }

}
