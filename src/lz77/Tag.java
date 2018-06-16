
package lz77;


public class Tag {
    
    private int Pointer;
    private  int length;
    private  char nextchar;

    public Tag() {
    }

    public Tag(int Pointer, int length, char nextchar) {
        this.Pointer = Pointer;
        this.length = length;
        this.nextchar = nextchar;
    }
    
    public int getPointer(){
        return this.Pointer;
    }
    public int getLength(){
        return this.length;
    }
    public char getnextchar(){
        return this.nextchar;
    }
    public void setPointer(int pointer){
        this.Pointer=pointer;
    }
    public void setLength(int length){
        this.length=length;
    }
    public void setNextchar(char nextchar){
        this.nextchar=nextchar;
    }
}
