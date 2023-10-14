package model;

public class Data {
    public boolean gameplay=false;
    protected static boolean[][] gridStatus;
    protected int gridSize;
    public Data(int size){
        this.gridSize=size;
        gridStatus=new boolean[size][size];
    }
    public boolean get(int i,int i1){
        return gridStatus[i][i1];
    }
    public void set(int i,int i1){
        gridStatus[i][i1]=true;
    }
    public void setGameplay(){
        gameplay=true;
    }

}
