import java.util.Scanner;

public class BinaryHex{
    
    public static void main(String[] args)
    {
        Scanner binaryReader = new Scanner(System.in);
        System.out.print("Enter Binary: ");
        String x = binaryReader.nextLine();
        x = binaryToHex(x);
        System.out.println(x);
        
    }
    public static String binaryToHex(String bin)
    {
        int len = bin.length();
        double digi = len/4.0;
        boolean isMultFour = true;
        if(digi-(len/4)>0)
        {
            isMultFour = false;
           digi = digi - (digi-(len/4));
        }
        String hexConvert="";
        int step2=0;
        for(int i=0;i<digi;i++)
        {
        String firstFour = bin.substring(len-4,len);
        bin = bin.substring(0,len-4);
        len = bin.length();
        step2 = ((Integer.valueOf(firstFour.substring(0,1))*((int)Math.pow(2,3)))+
                (Integer.valueOf(firstFour.substring(1,2))*((int)Math.pow(2,2)))+
                (Integer.valueOf(firstFour.substring(2,3))*((int)Math.pow(2,1)))+
                (Integer.valueOf(firstFour.substring(3,4))*((int)Math.pow(2,0))));
        hexConvert = decToHex(step2) + hexConvert;
        if(isMultFour == false && len<4)
        {
               if(len==1)
               {
                   step2 =  (Integer.valueOf(bin.substring(0,1))*((int)Math.pow(2,0)));
               }
                else if(len==2)
                {
                    step2 =  (Integer.valueOf(bin.substring(0,1))*((int)Math.pow(2,0)))+
                                (Integer.valueOf(bin.substring(1,2))*((int)Math.pow(2,1)));
                }
                else if(len==3)
                {
                    step2 =  (Integer.valueOf(bin.substring(0,1))*((int)Math.pow(2,0)))+
                                (Integer.valueOf(bin.substring(1,2))*((int)Math.pow(2,1)))+
                                    (Integer.valueOf(bin.substring(2,3))*((int)Math.pow(2,2)));
                }
            hexConvert = decToHex(step2) + hexConvert;
        }
        }
        if(hexConvert.substring(0,1).equals("0"))
        {
            hexConvert = hexConvert.substring(1);
        }

        return hexConvert;
    }
    public static String decToHex(int dec){
        if(dec<10){return Integer.toString(dec);}
        if(dec == 10){return "A";}
        if(dec == 11){return "B";}
        if(dec == 12){return "C";}
        if(dec == 13){return "D";}
        if(dec == 14){return "E";}
        if(dec == 15){return "F";}
        return "Error";
        }
        
}
