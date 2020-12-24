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
    
    // en los metodos fiver y sixer se usa un for con el mismo largo, se hace el for para no tener que repetir el mismo proceso 
    // ademas se le hace el llamado a otro metodo que es el validate_Four_five_six
    
    public int validateFor_five_six(int condition){
        int suma=0;
        int i;
        for ( i = 0; i < dice.length; i++) {
            suma+=validate_Four_five_six(condition, i);
        }
        
        return suma;
    }
    
    // la funcion del validate_Four_five_six es compara los valores de un arreglo para ver si es igual a un numero especifico 
    // el unico metodo que usa este metodo por si solo es el fours ya que el for tiene una codicion diferente al de los demas 
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

    
    // este metodo se usa para validar una codicion de los metodos score_pair y two_pair
    
    public static boolean score_and_two_pair_condition(int at, int counts[]){
        
        if(counts[6-at-1] >= 2)
            return true;
        
        return false;
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
            return score * n;
        else
            return 0;
    }
    
    // se instancia un arreglo numerico, esto se hace por que en varios metodos se hace un llamdo igual de los valores que contiene el arreglo.
    //los metodos en los que se llama son 
    //two_pair - score_pair - four_of_a_kind - three_of_a_kind - smallStraight - largeStraight - fullHouse
    public static int[] initializacionCounts(int d1, int d2, int d3, int d4, int d5){
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        
        return counts;
    }
    
    

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5){    
int tallies[] = initializacionCounts(_1, _2, d3, d4, d5);       
int codition=4;

        return three_and_four_of_a_king_For(tallies, codition);
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int t[] = initializacionCounts(d1, d2, d3, d4, d5);
        int codition=3;
        
        return three_and_four_of_a_king_For(t, codition);
    }
    
    // este metodo se hizo para recorrer el arreglo creado en los 2 metodos anteriores y comparar si alguno de los valores que contiene el arreglo 
    // es igual a de las condiciones de cada metodo 
    // como el proceso era el mismo y solo cambia el valor se la condion del if, se hizo un solo metodo para despues ser llamado
    public static int three_and_four_of_a_king_For(int[] tallies, int condition){
        for (int i = 0; i < 6; i++) {
            if(tallies[i] >= condition){
                return(i+1)*condition;
            }
        }   
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int tallies[] = initializacionCounts(d1, d2, d3, d4, d5);

        return smallStraightConfirmed(tallies);
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
    public static int smallStraightConfirmed(int tallies[]){
        int count= validatecount(tallies);
        int retorno=15;
        return smallStraight_and_large_Straight_Condition(count, retorno);
    }
        
    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int tallies[] = initializacionCounts(d1, d2, d3, d4, d5);
        int count= validatecount(tallies);
        int retorno=20;
        return smallStraight_and_large_Straight_Condition(count, retorno);
    }
    
    // este metodo se hizo para hacer una comparacion de count con 5 y como los 2 metodos que estan arriba hacian lo mismo 
    // entonces se hizo un metodo para hacer esta comparacion pero lo diferente es el retorno que se crea en los respectivos metodos
    public static int smallStraight_and_large_Straight_Condition(int count,int retorno){
        if(count==5){
            return retorno;
        }
        return 0;
    }
           
    // se hizo un refactoring con los 2 metodos de abajo 
    
    
    
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

