import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
   Write a program that checks whether a sequence of HTML tags
   is properly nested. For each opening tag, such as <p>, there
   must be a closing tag </p>. A tag such as <p> may have other
   tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>

   The inner tags must be closed before the outer ones.
   Your program should process a file containing tags.
   For simplicity, assume that the tags are separated by
   spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
   public static void main(String[] args)
   {
      String filename = "TagSample3.html";

      try (Scanner in = new Scanner(new File(filename)))
      {
         
         System.out.println(isBalanced(in));




      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename);
      }

   }
   
   public static boolean isBalanced (Scanner in)
   {
      Stack<String> stacc = new Stack<>();
         while (in.hasNext())
         {
            String temp = in.next();
            if(temp.charAt(1) != '/')
            {
               stacc.add(temp);
            }
            else
            {
               if (!temp.substring(2).equals(stacc.pop().substring(1)))
               {
                  return false;
               }
            }
         }
         if (stacc.isEmpty())
         {
            return true;
         }
         return false;
   }
}
