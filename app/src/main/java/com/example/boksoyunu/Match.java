package com.example.boksoyunu;

public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    boolean isF1Turn;



    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight){
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.isF1Turn = Math.random() < 0.5;
    }

    void start(){
        if (isCheck()){
            double randomStart = Math.random();
            boolean starts = randomStart < 0.5;

            System.out.println("İlk vuruşu " + (starts ? f1.name : f2.name) + " yapıyor!");
            System.out.println("--------------------------------------");
            if (starts) {
                this.f1.health = this.f1.hit(this.f2);
            }
            else
            {
                this.f1.health = this.f2.hit(this.f1);

            }
            while(this.f1.health > 0 && this.f2.health > 0){
                System.out.println("============= YENİ ROUND ==============");
               this.f2.health = this.f1.hit(f2);
               if (isWin()){
                   break;
               }
                this.f1.health = this.f2.hit(f1);
                if (isWin()){
                    break;
                }
                System.out.println(this.f1.name + " \t\t" + " HP:  " + this.f1.health);
                System.out.println(this.f2.name + " \t" + " HP:  " + this.f2.health);
            }
        }
        else {
            System.out.println("Sporcuların sikletleri eşleşmiyor.");
        }
    }

    boolean isCheck(){
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) &&
                (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println("Kazanan: " + this.f2.name);
            return true;
        }
     if (this.f2.health == 0) {
         System.out.println("Kazanan: " + this.f1.name);
         return true;
     }
         return false;
    }












}
