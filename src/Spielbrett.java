import java.lang.reflect.Array;

public class Spielbrett {
	static int anzK = 52;
	static Karte Hand[];
	static Karte KartenStapel[] = new Karte[52];
	static Karte k1 = new Karte("2", "Herz");
	static Karte k2 = new Karte("3", "Herz");
	static Karte k3 = new Karte("4", "Herz");
	static Karte k4 = new Karte("5", "Herz");
	static Karte k5 = new Karte("6", "Herz");
	static Karte k6 = new Karte("7", "Herz");
	static Karte k7 = new Karte("8", "Herz");
	static Karte k8 = new Karte("9", "Herz");
	static Karte k9 = new Karte("10", "Herz");
	static Karte k10 = new Karte("Prince", "Herz");
	static Karte k11 = new Karte("Queen", "Herz");
	static Karte k12 = new Karte("King", "Herz");
	static Karte k13 = new Karte("Ass", "Herz");

	static Karte k14 = new Karte("2", "Kreuz");
	static Karte k15 = new Karte("3", "Kreuz");
	static Karte k16 = new Karte("4", "Kreuz");
	static Karte k17 = new Karte("5", "Kreuz");
	static Karte k18 = new Karte("6", "Kreuz");
	static Karte k19 = new Karte("7", "Kreuz");
	static Karte k20 = new Karte("8", "Kreuz");
	static Karte k21 = new Karte("9", "Kreuz");
	static Karte k22 = new Karte("10", "Kreuz");
	static Karte k23 = new Karte("Prince", "Kreuz");
	static Karte k24 = new Karte("Queen", "Kreuz");
	static Karte k25 = new Karte("King", "Kreuz");
	static Karte k26 = new Karte("Ass", "Kreuz");

	static Karte k27 = new Karte("2", "Karo");
	static Karte k28 = new Karte("3", "Karo");
	static Karte k29 = new Karte("4", "Karo");
	static Karte k30 = new Karte("5", "Karo");
	static Karte k31 = new Karte("6", "Karo");
	static Karte k32 = new Karte("7", "Karo");
	static Karte k33 = new Karte("8", "Karo");
	static Karte k34 = new Karte("9", "Karo");
	static Karte k35 = new Karte("10", "Karo");
	static Karte k36 = new Karte("Prince", "Karo");
	static Karte k37 = new Karte("Queen", "Karo");
	static Karte k38 = new Karte("King", "Karo");
	static Karte k39 = new Karte("Ass", "Karo");

	static Karte k40 = new Karte("2", "Piek");
	static Karte k41 = new Karte("3", "Piek");
	static Karte k42 = new Karte("4", "Piek");
	static Karte k43 = new Karte("5", "Piek");
	static Karte k44 = new Karte("6", "Piek");
	static Karte k45 = new Karte("7", "Piek");
	static Karte k46 = new Karte("8", "Piek");
	static Karte k47 = new Karte("9", "Piek");
	static Karte k48 = new Karte("10", "Piek");
	static Karte k49 = new Karte("Prince", "Piek");
	static Karte k50 = new Karte("Queen", "Piek");
	static Karte k51 = new Karte("King", "Piek");
	static Karte k52 = new Karte("Ass", "Piek");

	static boolean poker() {
		for (int i = 0; i < Hand.length; i++) {
			for (int j = 0; j < Hand.length; j++) {
				if (j == i) {
					j++;
				}
				for (int k = 0; k < Hand.length; k++) {
					while (k == i || k == j) {
						k++;
					}
					if (k == Hand.length) {
						return false;
					}
					for (int l = 0; l < Hand.length; l++) {
						while (l == k || l == j || l == i) {
							l++;
						}
						if (l == Hand.length) {
							return false;
						}
						if (Hand[k].getWert() == Hand[i].getWert() && Hand[k].getWert() == Hand[j].getWert()) {
							return true;
						}
					}

				}

			}

		}
		return false;
	}

	static boolean triple() {
		for (int i = 0; i < Hand.length; i++) {
			for (int j = 0; j < Hand.length; j++) {
				if (j == i) {
					j++;
				}
				for (int k = 0; k < Hand.length; k++) {
					while (k == i || k == j) {
						k++;
					}
					if (k == Hand.length) {
						return false;
					}

					if (Hand[k].getWert() == Hand[i].getWert() && Hand[k].getWert() == Hand[j].getWert()) {
						return true;
					}
				}

			}

		}
		return false;
	}

	static boolean paar() {
		for (int i = 0; i < Hand.length; i++) {
			for (int j = 0; j < Hand.length; j++) {
				if (j == i) {
					j++;
				}
				if (j == Hand.length) {
					return false;
				}
				if (Hand[j].getWert() == Hand[i].getWert()) {
					return true;
				}
			}

		}
		return false;
	}

	static Karte[] karteZiehen(int anzGezogeneKarten) {
		Hand = new Karte[anzGezogeneKarten];
		Karte k;
		int back = KartenStapel.length - 1;
		for (int i = 0; i < anzGezogeneKarten; i++) {
			int zug = (int) (Math.random() * (back + 1));
			Hand[i] = KartenStapel[zug];
			k = KartenStapel[back];
			KartenStapel[back] = KartenStapel[zug];
			KartenStapel[zug] = k;
			back--;

		}
		for (int j = 0; j < anzGezogeneKarten; j++) {
			System.out.println(Hand[j].getFarbe() + "  " + Hand[j].getWert());
		}

		return Hand;
	}

	public static void main(String[] args) {
		KartenStapel[0] = k1;
		KartenStapel[1] = k2;
		KartenStapel[2] = k3;
		KartenStapel[3] = k4;
		KartenStapel[4] = k5;
		KartenStapel[5] = k6;
		KartenStapel[6] = k7;
		KartenStapel[7] = k8;
		KartenStapel[8] = k9;
		KartenStapel[9] = k10;
		KartenStapel[10] = k11;
		KartenStapel[11] = k12;
		KartenStapel[12] = k13;
		KartenStapel[13] = k14;
		KartenStapel[14] = k15;
		KartenStapel[15] = k16;
		KartenStapel[16] = k17;
		KartenStapel[17] = k18;
		KartenStapel[18] = k19;
		KartenStapel[19] = k20;
		KartenStapel[20] = k21;
		KartenStapel[21] = k22;
		KartenStapel[22] = k23;
		KartenStapel[23] = k24;
		KartenStapel[24] = k25;
		KartenStapel[25] = k26;
		KartenStapel[26] = k27;
		KartenStapel[27] = k28;
		KartenStapel[28] = k29;
		KartenStapel[29] = k30;
		KartenStapel[30] = k31;
		KartenStapel[31] = k32;
		KartenStapel[32] = k33;
		KartenStapel[33] = k34;
		KartenStapel[34] = k35;
		KartenStapel[35] = k36;
		KartenStapel[36] = k37;
		KartenStapel[37] = k38;
		KartenStapel[38] = k39;
		KartenStapel[39] = k40;
		KartenStapel[40] = k41;
		KartenStapel[41] = k42;
		KartenStapel[42] = k43;
		KartenStapel[43] = k44;
		KartenStapel[44] = k45;
		KartenStapel[45] = k46;
		KartenStapel[46] = k47;
		KartenStapel[47] = k48;
		KartenStapel[48] = k49;
		KartenStapel[49] = k50;
		KartenStapel[50] = k51;
		KartenStapel[51] = k52;

		karteZiehen(5);
		if (paar() == true) {
			System.out.println("Sie haben ein Paar");
		}
		if (triple() == true) {
			System.out.println("Sie haben ein Triple");
		}
		
		if (poker() == true){
			System.out.println("Sie haben einen Poker");
		}
	}

}
