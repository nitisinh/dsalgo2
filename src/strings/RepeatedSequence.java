package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class RepeatedSequence {




// input will be Strings of DNA sequences
// A, T, C, G
// find the substrings or subsequences of the string that are 10 characters long and appears at least twice

// examples
// input: "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// output: ["AAAAACCCCC","CCCCCAAAAA"]

// input: "AAAAAAAAAAAAA"
// output: ["AAAAAAAAAA"]



        static int addNumbers(int a, int b) {
            return a+b;
        }

        public List<String> findRepeatedSubsequence(String s){
            //this is a list of all the substrings whose length is 10 and is atleast repeated once.
            ArrayList<String> result = new ArrayList<String>();
            //boundary condition
            if(s.length() <10 || s == null || s.isEmpty()){
                return result;
            }
            //This set will make sure that the unique substring is taken.
            HashSet<String> subStringMarker = new HashSet<String>();
            int i = 0, j = 0;
            while(j<s.length()){
                j = i + 10;
                //Take substring of  length 10
                String currectSubs = s.substring(i++,j);
                //If a substring is not able to add up to set , it means it is already there.
                if(!subStringMarker.add(currectSubs)){
                    //if result does not contain the succeeded substring , add it up.
                    if(!result.contains(currectSubs))
                        result.add(currectSubs);
                }
            }
            return result;
        }

        public static void main(String[] args) {
            // input: "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
            // output: ["AAAAACCCCC","CCCCCAAAAA"]

            // input: "AAAAAAAAAAAAA"
            // output: ["AAAAAAAAAA"]

            // input : ""
            //output : []

            // input : "ABCSDFJKERTUIOWS"
            //output : []

            //input : "AAAAAAAAA"
            //output : []

            //input : null
            //output : []


        }
    }


