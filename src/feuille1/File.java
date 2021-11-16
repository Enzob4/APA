package feuille1;

public class File {
    private int [] tab;
    private int premier;
    private int dernier;

    public File(int n) {
        tab = new int[n];
        premier=0;
        dernier=0;
    }

    private boolean empty(){
        return premier == dernier;
    }

    private boolean full(){
        return(premier == (dernier+1)%tab.length);
    }

    public boolean enqueue(int i){
        if(full()){
            return false;
        }
        tab[dernier]=i;
        dernier=(dernier+1)%tab.length;
        return true;

    }

    public int dequeue(){
        assert (!empty());
        int oldPremier = premier;
        premier = (premier + 1)%tab.length;
        return tab[oldPremier];
    }
}
