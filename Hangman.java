import java.util.Random;
 import java.util.ArrayList; 
 import java.util.*;
public class Hangman

 {
   String guessed;
  Integer wordlength;
  Integer word;
  Integer w;
  Integer f;
  public Hangman()
  {
      w=4;
      f=0;
 }
 public void check()
 {
    String[] Ar={"car", "rage","live"};
    Random rand= new Random();
     word= rand.nextInt(2);
     guessed= Ar[word];
     wordlength= guessed.length();
     
}
public void start()
{
ArrayList<String>s1=new ArrayList<String>(); // all values
ArrayList<String>s2=new ArrayList<String>(); // guessed by user
ArrayList<String>s3=new ArrayList<String>(); // original word
ArrayList<String>s4=new ArrayList<String>(); // final 
int v= wordlength;
int y; 
 for(int d=0;d<wordlength;d++){
            s4.add(d,"_");// change will occur
        }
     
    String[] g2=guessed.split("");
    for (String j:g2)
    s3.add(j); //word to e guessed
     
      String ss= "abcdefghijklmnopqrstuvwxyz";// alphabets
      String[] sa=ss.split("");
     for (String j:sa)
      s1.add(j);
       
   System.out.println("welcome to the Hangman");
   System.out.println ("I am thinking of "  +wordlength+  " letter word");
   System.out.println("You have " +w+ " warnings left");
   System.out.println(s4);
   System.out.println("----------");
   double g=wordlength*1.5;
   int r=(int) g;
   int i;
      
   for( i= r; i>0;i--)
   {
       System.out.println("You have " +i+ " guesses left");
       System.out.println("Available guesses are " + s1 + "the warnings left are"  +w);
       System.out.println("Please guess a letter");
       System.out.println(s4);
       Scanner sc=new Scanner(System.in);
       String g1=sc.next();
       g1=g1.toLowerCase();
       char c= g1.charAt(0);
       int l; 
       if(Character.isAlphabetic(c))
       {
           g1=Character.toString(c);
       
        // guessed by user
      
       if(s2.contains(g1))
       {
           System.out.println("you have already entered this alphabet");
           w--;
           i++;
           if(w==0)
           {
               i--;
           }
       }
        else if(s3.contains(g1))
       {
            s1.remove(g1); // all values
            s2.add(g1);
            y=s3.indexOf(g1);
            s4.remove(y);
            s4.add(y,g1);
            System.out.println("the guess is correct");
            System.out.println(s4);
          
           f++;
           if(f==s3.size())
        {
            System.out.println("You won!");
            break;
        }
	   }
		
        else 
        {
           System.out.println ("the guess is not right");
		   s1.remove(g1);
		   
           
        }
    }
       else
        {
        System.out.println("Wrong guess");
          w--;
          i++;
          if(w==0)
          {
              i--;
          }
          
        }
    }
                 
if(i<=0)
{
    System.out.println("tries are finished");
}
}




   public static void main(String[] args)
{
 Hangman hang=new Hangman();
 hang.check();
 hang.start();
}
}
