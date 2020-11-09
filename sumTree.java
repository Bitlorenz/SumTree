package es1;

//import java.util.Objects;

import java.util.Objects;

public class sumTree {
    public int key;
    public sumTree left;
    public sumTree right;
    public static sumTree[] arr;

    public sumTree() {
        key = 0;
        left = null;
        right = null;
    }

    public int getKey() {
        return key;
    }

    public sumTree getLeft() {
        return left;
    }

    public sumTree getRight() {
        return right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(sumTree left) {
        this.left = left;
    }

    public void setRight(sumTree right) {
        this.right = right;
    }

    public static void newNode(sumTree nodo){
        nodo.setKey(0);
        nodo.setLeft(null);
        nodo.setRight(null);
    }

    public sumTree makeSumTree(){

        sumTree nullo = new sumTree();
        newNode(nullo);
        arr = new sumTree[7];
        for(int i = 0; i < 7; i++) {
            arr[i] = new sumTree();
            newNode(arr[i]);
        }

       sumTree app = new sumTree();
       int i, j;
       for(i=0, j=1; i<3; i++){//(!(app.equals(nullo)))
          arr[i].setRight(arr[j]);
          j+=1;
          arr[i].setLeft(arr[j]);
          j+=1;
       }
        /*for(i=0; i<3; i++){//(!(app.equals(nullo)))
            System.out.print("nodo: "+i+ ' ' +arr[i].getRight()+"  ");
            System.out.println(arr[i].getLeft());
        }*/
       j = 1;
       for (i = 6; i > 2; i--) {

           app.setLeft(arr[i].getLeft());
           app.setRight(arr[i].getRight());
           arr[i].setKey(j);
           j++;
           //System.out.println("nodo: "+i+' '+arr[i].getKey()+"  ");
       }
        for(i=2; i>=0; i--){
            {
                arr[i].setKey((arr[i].getLeft().getKey())+
                               arr[i].getRight().getKey());
                //System.out.println("nodo: "+i+' '+arr[i].getKey()+"  ");
           }
        }
        sumTree sumTree = arr[0];
        return sumTree;
    }

    public void printSumTree(){

        for(int i=0; i<7;i++){
            System.out.println(arr[i].getKey());
        }
    }

    public static int checkSumTree(sumTree tree){
        sumTree nullo = new sumTree();
        newNode(nullo);

        int val=tree.getKey();
        int valLeft=0;
        int valRight=0;

        if(Objects.equals(tree.getLeft(), nullo.getLeft()) &&
           Objects.equals(tree.getRight(), nullo.getRight())) {
            return val;
        }

        if((!(Objects.equals(tree.getLeft(), nullo.getLeft()))) &&
              Objects.equals(tree.getRight(), nullo.getRight())) {
            valLeft = checkSumTree(tree.getLeft());
            val = valLeft;
            return val;
        }

        if(Objects.equals(tree.getLeft(),nullo.getLeft()) &&
          (!(Objects.equals(tree.getRight(), nullo.getRight())))){
            valRight=checkSumTree(tree.getRight());
            val=valRight;
            return val;
        }

        if(!(Objects.equals(tree.getLeft(), nullo.getLeft()) &&
             Objects.equals(tree.getRight(), nullo.getRight()))){
            valLeft=checkSumTree(tree.getLeft());
            valRight=checkSumTree(tree.getRight());
            val=valLeft+valRight;
            return val;
        }
        //in caso di errore ritorna 1
        return 1;
    }

    public boolean appSumTree(sumTree tree){

        sumTree nullo = new sumTree();
        newNode(nullo);
        if (tree.equals(nullo))
            return false;

        int c = 1;
        boolean check=false;
        c = checkSumTree(tree);
        if(c >= 1)
            check=true;
        return check;
    }
}
