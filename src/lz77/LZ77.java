
package lz77;

import java.util.ArrayList;


public class LZ77 {
    
    public static String Source,Temp;
    public static ArrayList<Tag> tags=new ArrayList<>();
    public void Compress(String str){
        LZ77.Source=str;
        tags.clear();
        for(int i=0;i<Source.length();++i){
            int j=i;
            Temp=""+Source.charAt(i);
            while(Source.substring(0, i).lastIndexOf(Temp)!=-1 && j+1<Source.length()){//abadssssssssssssb
                ++j;
                Temp+=Source.charAt(j);
            }
            if(i==j){
                tags.add(new Tag(0, 0, Temp.charAt(Temp.length()-1)));
            }
            else{
                int p=i-Source.substring(0, i).lastIndexOf(Temp.substring(0,Temp.length()-1));
                tags.add(new Tag(p, Temp.length()-1, Temp.charAt(Temp.length()-1)));
            }
            i=j;
        }
    }
    public String Decompress(){
        String tmp="";
        int p,l,r;
        for(Tag tag:tags){
            p=tag.getPointer();
            l=tag.getLength();
            r=tmp.length()-p;
            for(int i=0;i<l;++i){
                tmp+=tmp.charAt(r);
                ++r;
            }
            tmp+=tag.getnextchar();
        }
        return tmp;
    }
//    public static void main(String[] args) {
//        // TODO code application logic here
////        LZ77 lz=new LZ77();
////        System.out.println(LZ77.Source);
////        lz.Compress();
////        tags.forEach((tag) -> {
////            System.out.println("<"+tag.getPointer()+","+tag.getLength()+","+tag.getnextchar()+">");
////        });
////        lz.Decompress();
//    }
    
}
