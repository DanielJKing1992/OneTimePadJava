package onetimepad;

    import java.io.*;
    import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class cryptMethod
{
    public static void crypt(boolean choice) throws IOException
    {
        Scanner sourceFile;
        Scanner keyFile;
        PrintWriter outputFile;
        if (choice)
        {
            sourceFile = new Scanner(new File("TestPlain.txt")); 
            keyFile = new Scanner(new File("Key.txt"));
            outputFile = new PrintWriter("TestCipher.txt");
        }
        else
        {
            sourceFile = new Scanner(new File("TestCipher.txt")); 
            keyFile = new Scanner(new File("Key.txt"));
            outputFile = new PrintWriter("TestDecoded.txt");
        }
        
        
        {
            String sourceStringMixed = sourceFile.nextLine();
            String sourceString = sourceStringMixed.toUpperCase();
            int length = sourceString.length();
            
            String keyStringMixed = keyFile.nextLine();
            String keyString = keyStringMixed.toUpperCase();
            
            int[] sourceInt = new int[length];
            int[] keyInt = new int[length + length];
            
            int outputInt;
            
            int sourceAscii;
            int keyAscii;
            char[] outputChar = new char[length];
            
            
            for (int n = 0; n < length; n++)
            {
                //make each char in plain[] and key[] into an integer
                char s = sourceString.charAt(n);
                char k = keyString.charAt(n);
                
                sourceAscii = (int)s;
                if (sourceAscii == 32)
                {
                    sourceInt[n] = 36;
                }
                else if (sourceAscii < 58)
                {
                    sourceInt[n] = sourceAscii - 48;
                }
                else
                {
                    sourceInt[n] = sourceAscii - 55;
                }
                
                keyAscii = (int)k;
                if (keyAscii == 32)
                {
                    keyInt[n] = 36;
                }
                else if (keyAscii < 58)
                {
                    keyInt[n] = keyAscii - 48;
                }
                else
                {
                    keyInt[n] = keyAscii - 55;
                }
                
                
            }
            
            char kLast = keyString.charAt(length);
            keyAscii = (int)kLast;
            if (keyAscii == 32)
            {
                keyInt[length] = 36;
            }
            else if (keyAscii < 58)
            {
                keyInt[length] = keyAscii - 48;
            }
            else
            {
                keyInt[length] = keyAscii - 55;
            }
            
            for (int n = 0; n < length; n++)
            {
                if (choice)
                {
                    outputInt = (sourceInt[n]+keyInt[n]+keyInt[2*n+1])%37;
                }
                else
                {
                    outputInt = (sourceInt[n]-(keyInt[n]+keyInt[2*n+1]));
                    do
                    {
                        if (outputInt < 0)
                        {
                            outputInt = outputInt + 37;
                        }
                    } while (outputInt <0);
                }
                
                if (outputInt == 36)
                {
                    outputChar[n] = ' ';
                }
                else if (outputInt < 10)
                {
                    outputChar[n] = (char)(outputInt + 48);
                }
                else
                {
                    outputChar[n] = (char)(outputInt + 55);
                }
                
                outputFile.write(outputChar[n]);
                
            }
            
            outputFile.close();
        }
    }
}