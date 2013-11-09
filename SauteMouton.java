class SauteMouton extends Program {
   char[] prairie;

	void algorithm() {
		init(prairie);
		while (!victoire(prairie)) {
			print(prairie);
			println("0 1 2 3 4 5 6 ");
			deplace(prairie, saisie());
		}
	}

	// initialisation de la prairie
	void init(char[] p) {
		final char BLANC = '<', NOIR = '>', VIDE = '_';
		prairie = new char[7];

		for (int i = 0; i < length(prairie); i++) {
			prairie[i] = i != 3 ? i < length(prairie) / 2 ? NOIR : BLANC : VIDE;

		}

	}

	// saisie
	int saisie() {
		int indice;
		print("Saisir un indice : ");
		indice = readInt();
		while (indice < 0 || indice > 6 || !estUnMouton(prairie, indice)) {
			print("Mauvais indice : ");
			indice = readInt();
		}
		return indice;
	}

	boolean allowed(char[] p, int currentPos, int nextPos) {
		if (p[currentPos] == '>') {
			if (currentPos < nextPos) {

				return true;
			}
		}
		if (p[currentPos] == '<') {
			if (currentPos > nextPos) {
				return true;
			}
		}
		return false;
	}

	void deplace(char[] p, int x) {
		if (avancer(p, x) || sauter(p, x)) {
			for (int i = 0; i < length(p); i++) {
				if (p[i] == '_' && allowed(p, x, i)) {
					p[i] = p[x];
					p[x] = '_';
					return;
				}
			}
		} else {
			println("Déplacement impossible");
		}
	}

	// contrôle la case avant ou après
	boolean avancer(char[] p, int i) {
		if (i < length(p) - 1 && i > 0) {
			if (!estUnMouton(p, i + 1) || !estUnMouton(p, i - 1)) {
				return true;
			}
		}
		if (i == 0 && !estUnMouton(p, i + 1)) {
			return true;
		}

		if (i == length(p) - 1 && !estUnMouton(p, i - 1)) {
			return true;
		}
		return false;
	}

	// contrôle 2 cases avant et 2 cases après si un déplacement est possible
	boolean sauter(char[] p, int i) {
		if (i > 1 && i < length(p) - 2) {
			if (!estUnMouton(p, i + 2) || !estUnMouton(p, i - 2)) {
				return true;
			}
		}

		if (i < 2 && !estUnMouton(p, i + 2)) {
			return true;
		}
		if (i > length(p) - 3 && !estUnMouton(p, i - 2)) {
			return true;
		}

		return false;
	}

	boolean victoire(char[] p) {
		char[] fin = new char[] { '<', '<', '<', '_', '>', '>', '>' };
		if (p == fin) {
			println("gagné !");
			return true;
		}
		return false;
	}

	// A compléter...
	boolean bloque(char[] p) {
		return false;
	}

	// vérifie si la case à l'indice passé en paramètre contient un mouton
	boolean estUnMouton(char[] p, int i) {
		return p[i] == '>' || p[i] == '<';
	}

	// affiche la prairie
	void print(char[] p) {
		for (int i = 0; i < length(p); i++) {
			print(p[i] + " ");
		}
		println();
	}

	public static void main(String[] args) {
		Program.main(args);
	}
}
