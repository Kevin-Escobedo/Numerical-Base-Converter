package convert;

import java.util.HashMap;

public class Converter
{
    Converter()
    {

    }
    
    String reverseString(String s)
    {
        String reversed = "";

        int stringLength = s.length();

        for(int i = stringLength - 1; i >= 0; i--)
        {
            reversed += s.charAt(i);
        }

        return reversed;
    }

    HashMap<String, String> makeAlphabetValues()
    {
        HashMap<String, String> values = new HashMap<String, String>();
        
        final int alphabetLength = 26;
        String[] alphabet = new String[alphabetLength];

        for(int i = 0; i < alphabetLength; i++)
        {
            String index = String.valueOf(i + 10);
            values.put(index, alphabet[i]);
        }

        return values;
    }

    String decimalToBase(int num, int base)
    {
        HashMap<String, String> alphabetValues = makeAlphabetValues();
        String result = "";
        int modResult = 0;
        int divResult = 0;

        while(divResult != 1)
        {
            modResult = num % base;
            divResult = num / base;

            String stringValue = String.valueOf(modResult);

            if(base >= 11 && 9 < modResult && modResult < 36)
            {
                String actualValue = alphabetValues.get(stringValue);
                result += actualValue;
            }

            else
            {
                result += stringValue;
            }

            divResult = num / base;
            num = divResult;

            if(divResult == 0)
            {
                return reverseString(result);
            }
        }
        
        result += String.valueOf(divResult);
        return reverseString(result);
    }
}
