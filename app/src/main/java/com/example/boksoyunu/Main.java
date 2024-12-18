package com.example.boksoyunu;

public class Main {
    public static void main(String args[]){

        Fighter f1 = new Fighter("Mike Tyson", 100,80,20,
                20,1,30);
        Fighter f2 = new Fighter("Anthony Joshua",100,75,20,
                20,1,30);

        Match match = new Match(f1,f2,70,90);
        match.start();


   }
}
