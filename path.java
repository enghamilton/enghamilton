import java.util.Scanner;

public class Main
{
  public static void main(String[] args) {
  
  
  //Scanner sc = new Scanner(System.in);
        
        int i,j, n;
        boolean pathA,pathB,pathC;
        pathA = false;
        pathB = false;
        pathC = false;
        
        System.out.printf("Informe sequência de números no array A:\n");
        //n = sc.nextInt(); // 3.1 entrada de dados (lendo um valor inteiro)
        
        int[] tmp = new int[4];
        
        Scanner sc=new Scanner(System.in);
        sc.useDelimiter("\\D");
        int a,b,c,d;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        d=sc.nextInt();
        
        System.out.printf("Informe sequência de números no array B:\n");
        int e,f,g,h;
        e=sc.nextInt();
        f=sc.nextInt();
        g=sc.nextInt();
        h=sc.nextInt();
        
        System.out.printf("Informe sequência de números no array C:\n");
        int i1,j1,k,l;
        i1=sc.nextInt();
        j1=sc.nextInt();
        k=sc.nextInt();
        l=sc.nextInt();
        
        System.out.printf("Informe sequência de números no array D:\n");
        int m,n1,o,p;
        m=sc.nextInt();
        n1=sc.nextInt();
        o=sc.nextInt();
        p=sc.nextInt();
        
        System.out.println("Arrays are : \n");
        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println(e + " " + f + " " + g + " " + h);
        System.out.println(i1 + " " + j1 + " " + k + " " + l);
        System.out.println(m + " " + n1 + " " + o + " " + p);

        sc.close();
        
        int arA[] = new int[]{a,b,c,d};
        int arB[] = new int[]{e,f,g,h};
        int arC[] = new int[]{i1,j1,k,l};
        int arD[] = new int[]{m,n1,o,p};
        
        /*
        int[][] array2d = {
                            {1,1,1,0},
                            {1,0,1,0},
                            {0,1,1,0},
                            {0,0,1,1}
        };
        
                        {
                            {1,1,1,0},                  {1,0,0,0},
                            {0,0,1,0},                  {1,0,0,0},
                            {0,0,1,0},                  {0,1,0,0},
                            {0,0,1,1}                   {0,0,1,1},
                                    ^long path has 7           ^short path has 5
                        }
        
        */
        
        int[][] array2d = new int[4][4];
        array2d[0] = arA;
        array2d[1] = arB;
        array2d[2] = arC;
        array2d[3] = arD;
        
        boolean[][] arrayPathA = new boolean[4][4];
        boolean[][] arrayPathB = new boolean[4][4];
        boolean[][] arrayPathC = new boolean[4][4];
        
        for(i=0; i < 4; i++){
            for(j=0; j < 4; j++){
                
                
                if(i==0){
                    switch(j){
                        case 0:
                            if(array2d[i][j] == 1){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = true;
                            } else {
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            break;
                        case 1:
                            if(array2d[i][j] == 1){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            } else {
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            break;
                        case 2:
                            if(arrayPathA[i][j-1] == true && array2d[i][j] == 1){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            } else {
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            break;
                        case 3:
                            if(arrayPathA[i][j-1] == true && array2d[i][j] == 1){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            } else {
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            break;
                    }
                }
                if(i==1){
                    switch(j){
                        case 0:
                            if(array2d[i][j] == 1){
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            } else {
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            break;
                        case 1:
                            if(array2d[i][j] == 1){
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            } else {
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            break;
                        case 2:
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathB[i][j-1] == true){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            } else {
                                
                                if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathA[i][j-1] == false){
                                    arrayPathA[i][j] = true;
                                    arrayPathB[i][j] = false;
                                    arrayPathC[i][j] = false;
                                }
                                if(array2d[i][j] == 1 && arrayPathA[i-1][j] == false && arrayPathB[i][j-1] == true){
                                    arrayPathA[i][j] = false;
                                    arrayPathB[i][j] = true;
                                    arrayPathC[i][j] = false;
                                }
                            }
                            break;
                        case 3:
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathB[i][j-1] == true){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            } else {
                                
                                if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathB[i][j-1] == false){
                                    arrayPathA[i][j] = true;
                                    arrayPathB[i][j] = false;
                                    arrayPathC[i][j] = false;
                                }
                                if(array2d[i][j] == 1 && arrayPathA[i-1][j] == false && arrayPathB[i][j-1] == true){
                                    arrayPathA[i][j] = false;
                                    arrayPathB[i][j] = true;
                                    arrayPathC[i][j] = false;
                                }
                            }
                            break;
                    }
                }
                if(i==2 || i ==3){
                    switch(j){
                        case 0:
                            if(array2d[i][j] == 1 && arrayPathC[i-1][j] == true){
                               
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            } else {
                               
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            break;
                        case 1:
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathB[i-1][j] == true && arrayPathC[i][j-1] == true){
                                
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = true;
                            } else {
                               
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathB[i-1][j] == false && arrayPathC[i][j-1] == false){
                                
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == false && arrayPathB[i-1][j] == true && arrayPathC[i][j-1] == false){
                               
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            } 
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == false && arrayPathB[i-1][j] == false && arrayPathC[i][j-1] == true){
                               
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathB[i-1][j] == true && arrayPathC[i][j-1] == false){
                                
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == false && arrayPathB[i-1][j] == true && arrayPathC[i][j-1] == true){
                                
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = true;
                            }
                            if(array2d[i][j] == 1 && arrayPathA[i-1][j] == true && arrayPathB[i-1][j] == false && arrayPathC[i][j-1] == true){
                                
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            
                            break;
                        case 2:
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == true || arrayPathB[i][j-1] == true) && arrayPathC[i][j-1] == true){
                                
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = true;
                            } else {
                               
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == true || arrayPathB[i][j-1] == true) && arrayPathC[i][j-1] == false){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == true){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == true){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == false){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == false && arrayPathA[i][j-1] == false) && (arrayPathB[i-1][j] == true || arrayPathB[i][j-1] == true) && arrayPathC[i][j-1] == false){
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            } 
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == false || arrayPathA[i][j-1] == false) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == true){
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            break;
                        case 3:
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == true || arrayPathB[i][j-1] == true) && arrayPathC[i][j-1] == true){
                                
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = true;
                            } else {
                               
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == true || arrayPathB[i][j-1] == true) && arrayPathC[i][j-1] == false){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == true){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == true){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == true || arrayPathA[i][j-1] == true) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == false){
                                arrayPathA[i][j] = true;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = false;
                            }
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == false && arrayPathA[i][j-1] == false) && (arrayPathB[i-1][j] == true || arrayPathB[i][j-1] == true) && arrayPathC[i][j-1] == false){
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = true;
                                arrayPathC[i][j] = false;
                            } 
                            if(array2d[i][j] == 1 && (arrayPathA[i-1][j] == false || arrayPathA[i][j-1] == false) && (arrayPathB[i-1][j] == false || arrayPathB[i][j-1] == false) && arrayPathC[i][j-1] == true){
                                arrayPathA[i][j] = false;
                                arrayPathB[i][j] = false;
                                arrayPathC[i][j] = true;
                            }
                            break;
                    }
                }
            }
        }
        
        System.out.println("arrayPathA :");
        for(i=0; i < 4; i++){
            System.out.printf("arrayPathA %d :\n", i);
            for(j=0; j<4; j++){
                System.out.println(arrayPathA[i][j]);
            }
        }
        System.out.println("\n");
        
        System.out.println("arrayPathB :");
        for(i=0; i < 4; i++){
            System.out.printf("arrayPathB %d :\n", i);
            for(j=0; j<4; j++){
                System.out.println(arrayPathB[i][j]);
            }
        }
        System.out.println("\n");
        
        System.out.println("arrayPathC :");
        for(i=0; i < 4; i++){
            System.out.printf("arrayPathC %d :\n", i);
            for(j=0; j<4; j++){
                System.out.println(arrayPathC[i][j]);
            }
        }
        
        /*
        System.out.printf("\n+--Resultado--+\n");
        for (i=1; i<=10; i++) {
          for (i=1; i<=10; i++) {
          System.out.printf("| %2d * %d = %2d |\n", i, n, (i*n));
        }
        }
        System.out.printf("+-------------+\n");
        */
        
        /*
  int[][] array2d = new int[4][4];
  int[] arrayA = {1,0,1,0};
  int[] arrayB = new int[4];
  int arrayC[] = new int[4];
  int arrayD[] = {0,0,0,0};
  arrayB[0] = 0;
  arrayB[1] = 1;
  arrayB[2] = 0;
  arrayB[3] = 1;
  
  arrayC[0] = 1;
  arrayC[1] = 1;
  arrayC[2] = 1;
  arrayC[3] = 1;
  
  array2d[0] = arrayA;
  array2d[1] = arrayB;
  array2d[2] = arrayC;
  array2d[3] = arrayD;
  */
  
 }
}
