package es1;

public class Solution{
    public static void main(String[]args){
        sumTree tree=new sumTree();
        System.out.println("Creazione Sum Tree... ");
        tree = tree.makeSumTree();
        //tree.printSumTree();
        boolean check;
        check=tree.appSumTree(tree);
        System.out.println("Zero se SumTree, Uno altrimenti: "+check);

    }


}