class SauteMouton extends Program{
    
    char[] prairie;

    void algorithm(){
	init();
	print(prairie);
	saisie();
    }

    //initialisation de la prairie
    char[] init(){
	final char BLANC = '<', NOIR = '>', VIDE = '_';
	prairie = new char[7];

	for(int i = 0 ; i < length(prairie) ; i++){
	    prairie[i] = i!=3?(i < length(prairie)/2?NOIR:BLANC):VIDE;
	    
	}
	return prairie;
    }
    
    //saisie
    void saisie(){
	int indice;
	print("Saisir un indice : ");
	indice = readInt();
	while(!estValide(prairie, indice)){
	    print("Mauvais indice : ");
	    indice = readInt();
	}
    }

    boolean avancer(char[] p, int i){
	if(i < length(p)-2){
	    if(estValide(p, i+1)){
		
	    }
	}
    }
    
    //vérifie si la case à l'indice passé en paramètre contient un mouton
    boolean estValide(char[] p, int i){
	return p[i] == '>' || p[i] == '<';
    }

    //affiche la prairie
    void print(char[] p){
	for(int i = 0 ; i < length(p) ; i++){
	    print(p[i]);
	}
	println();
    }
}
