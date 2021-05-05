public class Shiritori {

    public String[] words;
    private int length = 0;
    public boolean gameOver = false;

    public Shiritori(int n){
        words = new String[n];
    }

    public String play(String word){

        if(gameOver || length == 20){
            return "game over";
        }

        // 2nd rule: unique word
        for(int i = 0; i < length; i++){
            if(words[i].equals(word)){
                gameOver = true;
                return "game over";
            }
        }

        // 1st rule: First character of next word must match last character of previous word
        if(length == 0){
            words[0] = word;
            length++;
        } else {
            System.out.println(length);
            String lastWord = words[length-1];
            Character lastChar = lastWord.charAt(lastWord.length()-1);
            Character firstChar = word.charAt(0);
            if(lastChar.equals(firstChar) == false){
                gameOver = true;
                return "game over";
            } else {
                words[length] = word;
                length++;
            }
        }

        return getWords();
    }


    public void restart(){
        gameOver = false;
        length = 0;
        words = new String[20];

    }

    public String getWords(){
        String result = "";
        for(int i = 0; i < length; i++){
            result = result + " " + words[i];
        }
        return result;

    }
}
