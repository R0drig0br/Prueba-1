/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

/**
 *
 * @author Marcelo
 */
public class Generala {
    
    
    

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    
    // se separo en 2 metodos para no tener 2 for en uno solo
    public static int generala(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        return validateAccounts(counts);
    }
    
    public static int validateAccounts(int counts[]){
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }
    
public static int sum(int d1, int d2, int d3, int d4, int d5, int condicion){
        int[] counts = new int[6];
        
        counts[0]=d1;
        counts[1]=d2;
        counts[2]=d3;
        counts[3]=d4;
        counts[4]=d5;
        int suma=0;
        for (int i = 0; i < counts.length; i++) {
            if(counts[i]==condicion){
                suma++;
            }
        }
        return suma;
    }
    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int condicion=1;
        int sum = sum(d1, d2, d3, d4, d5,condicion);
        return sum;
    }
    
    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int condicion=2;
        int sum = sum(d1, d2, d3, d4, d5,condicion);
        return sum*2;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int condicion=3;
        int sum = sum(d1, d2, d3, d4, d5,condicion);
        return sum*3;
    }

    protected int[] dice;
    public Generala(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }
    
    public int validateFor_five_six(int condition){
        int suma=0;
        int i;
        for ( i = 0; i < dice.length; i++) {
            suma+=validate_Four_five_six(condition, i);
        }
        
        return suma;
    }
        public int validate_Four_five_six(int condition, int i){
        int suma=0;
        if (dice[i] == condition) {
                suma += condition;
            }
        return suma;
    }

    public int fours()
    {
        int suma=0;
        int condition=4;
        
        for (int at = 0; at != 5; at++) {
            suma+=validate_Four_five_six(condition, at);
        }
        return suma;
    }

    public int fives()
    {
        int codition=5;   
        return validateFor_five_six(codition);
    }

    public int sixes()
    {
        int codition=6;
        return validateFor_five_six(codition);
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int counts[] = initializacionCounts(d1, d2, d3, d4, d5);
        for (int at = 0; at != 6; at++)
            if (score_and_two_pair_condition(at, counts))
                return (6-at)*2;
        return 0;
    }
    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int counts[] = initializacionCounts(d1, d2, d3, d4, d5);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (score_and_two_pair_condition(i, counts)) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }
    public static int[] initializacionCounts(int d1, int d2, int d3, int d4, int d5){
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        
        return counts;
    }
    
    public static boolean score_and_two_pair_condition(int at, int counts[]){
        
        if(counts[6-at-1] >= 2)
            return true;
        
        return false;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        

int tallies[] = initializacionCounts(_1, _2, d3, d4, d5);        
for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int t[] = initializacionCounts(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int tallies[] = initializacionCounts(d1, d2, d3, d4, d5);

        return smallStraightConfirmed(tallies);
    }
    
    public static int smallStraightConfirmed(int tallies[]){
        int count= validatecount(tallies);
        if(count==5)
            return 15;
        
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int tallies[] = initializacionCounts(d1, d2, d3, d4, d5);
        int count= validatecount(tallies);
        if(count== 5){
            return 20; 
        }
        return 0;
    }
    
    public static int validatecount(int[] tallies){
        int count=0;
        for (int i = 0; i < tallies.length; i++) {
            if(tallies[i]==1){
                count++;
            }
        }
        return count;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int tallies[] = initializacionCounts(d1, d2, d3, d4, d5);
        boolean _2 = false,_3 = false;
        int i;
        int _2_at = 0,_3_at = 0;
        
        for (i = 0; i != 6; i += 1){
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }
        }
        return validate_Full_House(_2, _3, _2_at, _3_at);
    }
    
    public static int validate_Full_House(boolean _2, boolean _3, int  _2_at, int _3_at){
        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}

