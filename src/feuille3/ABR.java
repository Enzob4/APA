package feuille3;
/*
        1. l’ordre préfixe : on liste chaque sommet la première fois qu’on le rencontre dans la balade.
        2. l’ordre postfixe : on liste chaque sommet la dernière fois qu’on le rencontre.
        3. l’ordre infixe : on liste chaque sommet ayant un fils gauche la seconde fois qu’on le voit et chaque
        sommet sans fils gauche la première fois qu’on le voit.

        http://math.univ-lyon1.fr/irem/IMG/pdf/parcours_arbre_avec_solutions-2.pdf
*/
public class ABR {
        private int info;
        private ABR gauche;
        private ABR droite;

        public ABR(int i){
                info=i;
                gauche=null;
                droite=null;

        }

        public ABR(int[] tab){
                info=tab[0];
                for(int i=1;i<tab.length;i++)
                        this.insert(tab[i]);

        }

        public void insert(int i){
                if (i<=info) {
                        if (gauche == null)
                                this.gauche = new ABR(i);
                        else gauche.insert(i);
                }else {
                        if (droite == null)
                                this.droite = new ABR(i);
                        else droite.insert(i);
                }

        }

        public int maximum(){
                int maximum=info;
                while (droite!=null)
                        maximum= droite.maximum();
                return maximum;
        }

        public  int minimum(){
                int minimum=info;
                while (gauche!=null)
                        minimum= gauche.minimum();
                return minimum;
        }

        public int size(){
                int taille=1;
                if(droite!=null)
                        taille+=droite.size();
                if (gauche!=null)
                        taille+= gauche.size();
                return taille;
        }

        public int hauteur(){
                int highD=0;
                int highG=0;
                if (droite!=null)
                        highD = droite.hauteur();

                if (gauche!=null)
                        highG = gauche.hauteur();
                if (highD>highG){
                        return highD+1;
                }else return highG+1;
        }

        public boolean equilibre(){
                if(gauche == null && droite==null){
                        return true;
                }
                if (droite != null && gauche==null){
                        return droite.hauteur() == 1;
                }
                if (droite == null){
                        return gauche.hauteur()==1;
                }
                return Math.abs(gauche.hauteur()- droite.hauteur())<=1;
        }

        public boolean equals(ABR a){
                boolean sortie=true;
                if(info!=a.info){return false;}
                if (gauche==null && a.gauche!=null)return false;
                if (droite==null && a.droite!=null)return false;
                if (a.gauche==null && gauche!=null)return false;
                if (a.droite==null && droite!=null)return false;
                if (gauche!= null){
                        sortie=gauche.equals(a.gauche);
                }
                if (sortie && droite!=null){
                        sortie = droite.equals(a.droite);
                }
                return sortie;

        }

        @Override
        public String toString() {
                return "ABR{" +
                        "info=" + info +
                        ", gauche=" + gauche +
                        ", droite=" + droite +
                        '}';
        }

        public static void main(String[] args) {
                int[] a ={9,3,10,2,4,8};
                ABR abr=new ABR(a);
                System.out.println(abr.hauteur());
                System.out.println(abr.toString());

        }





}
