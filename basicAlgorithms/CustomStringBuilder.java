import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class CustomStringBuilder{
    private List<Character> characterBuffer;

    public CustomStringBuilder(){
        characterBuffer = new ArrayList<Character>();
    }

    public void append(String anotherString){
        if(anotherString != null){
            for(int i=0; i < anotherString.length(); i++){
                char c = anotherString.charAt(i);
                characterBuffer.add(c);
        }
    }
    }

    public String toString(){
        char [] charArray = new char[characterBuffer.size()];
        for(int i=0; i < charArray.length; i++)
            charArray[i] = characterBuffer.get(i);
        return new String(charArray);
    }
}

class CustomStringBuilder2{
    private char[] characterBuffer;
    private int curIndex;

    public CustomStringBuilder2(){
        characterBuffer = new char[5];
        curIndex = 0;
    }

    public void append(String anotherString){
        if(anotherString  != null){
            int anotherStringLength = anotherString.length();
            if(overflow(anotherStringLength))
                characterBuffer = Arrays.copyOf(characterBuffer, newLength(anotherStringLength)); 
            for(int i=0; i<anotherStringLength; i++){
                characterBuffer[curIndex++] = anotherString.charAt(i);
            }
        }
    }

    public String toString(){
        return new String(characterBuffer, 0, curIndex);
    }

    private boolean overflow(int stringLength){
        return (stringLength + curIndex) > characterBuffer.length;
    }

    private int newLength(int stringLength){
        return (characterBuffer.length + stringLength) *2 ;
    }
}
