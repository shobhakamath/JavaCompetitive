package collectionsapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlagProblem {
    public static void dutchNationalFlag(int pivotIndex, List<Color> colors){
        Color pivotColor=colors.get(pivotIndex);
        int low=0,mid=0,high=colors.size()-1;
        while(mid<=high){
            if(colors.get(mid).ordinal()<pivotColor.ordinal()){
                Collections.swap(colors,mid++,low++);
            }
            else if(colors.get(mid).ordinal()==pivotColor.ordinal()){
                mid++;
            }else{
                Collections.swap(colors,mid,high--);
            }
        }
    }
    public static void main(String[] args) {
        List<Color> colors=Arrays.asList(Color.RED,Color.BLUE,Color.GREEN,Color.GREEN,
                Color.BLACK,Color.BLUE,Color.RED,Color.RED,Color.WHITE);
      dutchNationalFlag(7,colors);
        System.out.println(colors);
    }
    enum Color{
        RED,GREEN,BLUE,BLACK,WHITE;
    }
}
