/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avlarbol;

/**
 *
 * @author sncardenas
 */
public class arbol {
    private nodo raiz;
    public arbol() {
        this.raiz = null;
    }
    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
    
    public static int alturaArbol(nodo n1) {
        if (n1 == null) {
            return 0;
        }
        return Math.max(alturaArbol(n1.getIzquierdo()), alturaArbol(n1.getDerecho())) + 1;
    }
      
    public static void printTree(int[][] M, nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = (char) root.getValor();
        printTree(M, root.getIzquierdo(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDerecho(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }
    public void TreePrinter() {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, this.raiz, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(M[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public int alturaNodo(nodo nodo){
        if(nodo==null){
            return 0;
        }
        return nodo.getAltafulla();
    }
    public int factordequilibrio(nodo nodo){
        if (nodo==null){
            return 0;
        }
        return alturaNodo(nodo.getIzquierdo())-alturaNodo(nodo.getDerecho());
    }
    public nodo rotacionderecha(nodo y){
        nodo x=y.getIzquierdo();
        nodo temp=x.getDerecho();
        x.setDerecho(y);
        y.setIzquierdo(temp);
        y.setAltafulla(Math.max(alturaNodo(y.getIzquierdo()), alturaNodo(y.getDerecho()))+1);
        x.setAltafulla(Math.max(alturaNodo(x.getIzquierdo()), alturaNodo(x.getDerecho()))+1);
        return x;
    }
    public nodo rotacionizquierda(nodo x){
        nodo y=x.getDerecho();
        nodo temp=y.getIzquierdo();
        y.setIzquierdo(x);
        x.setDerecho(temp);
        x.setAltafulla(Math.max(alturaNodo(x.getIzquierdo()), alturaNodo(x.getDerecho()))+1);
        y.setAltafulla(Math.max(alturaNodo(y.getIzquierdo()), alturaNodo(y.getDerecho()))+1);
        return y;
    }
    public void insetar(int valor){
        this.raiz=insertar2(this.raiz,valor);
    }
    
    public nodo insertar2(nodo nodo,int valor){
        if(nodo==null){
            nodo nuevonodo=new nodo(valor);
            return nuevonodo;
        }
        if(valor<nodo.getValor()){
            nodo.setIzquierdo(insertar2(nodo.getIzquierdo(),valor));
        }else if (valor>nodo.getValor()){
            nodo.setDerecho(insertar2(nodo.getDerecho(),valor));
        }else {
            return nodo;
        }
        nodo.setAltafulla(1+Math.max(alturaNodo(nodo.getIzquierdo()), alturaNodo(nodo.getDerecho())));
        int fe=factordequilibrio(nodo);
        int valornododerecho=nodo.getDerecho()!=null?nodo.getDerecho().getValor():0;
        int valornodoizquierdo=nodo.getIzquierdo()!=null?nodo.getIzquierdo().getValor():0;
        if(fe>1&&valor<valornodoizquierdo){
            return rotacionderecha(nodo);
        }
        if(fe<-1&&valor>valornododerecho){
            return rotacionizquierda(nodo);
        }
        return nodo;
    }
}