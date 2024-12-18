package com.example.boksoyunu;

public class Fighter {
    String name;
    int health;
    int weight;
    int dodge;
    int critical;
    int minDamage;
    int maxDamage;



    Fighter(String name, int health, int weight, int dodge, int critical,int minDamage,int maxDamage){

        this.name = name;
        if (minDamage >= 0 && maxDamage >= minDamage) {
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
        }
        this.health = health;
        this.weight = weight;
        if (this.dodge >= 0 && this.dodge <= 100){
            this.dodge = dodge;
        }
        if (this.critical >= 0 && this.critical <= 100){
            this.critical = critical;
        }

    }
    int hit(Fighter foe){

        int actualDamage = getRandomDamage();

        System.out.println(this.name + "  =>  " + foe.name + " " + actualDamage + " hasar vurdu. ");
          if (foe.isDodge()){
              System.out.println(foe.name + "  GELEN HASARI BLOKLADI!!");
              return foe.health;
          }
        if (foe.isCrit()) {
            int criticalDamage = actualDamage + (actualDamage * this.critical / 100);
            System.out.println(this.name + "   Kritik Vuruş Yaptı! Hasar: " + criticalDamage);
            if (foe.health - criticalDamage < 0) {
                return 0;
            }
            return foe.health - criticalDamage;
        }
           if (foe.health - actualDamage < 0){
               return 0;
           }

        return foe.health - actualDamage;
    }

    boolean isDodge(){
        double randomNumber = Math.random() * 100;

     return randomNumber <= this.dodge;
    }

    boolean isCrit(){
        double randomNumber = Math.random() * 100;

        return randomNumber <= this.critical;
    }
    int getRandomDamage(){
        return (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
    }
}
