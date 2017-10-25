import java.lang.reflect.Array;
import java.util.Arrays;

public class Spielbrett {
	static int anzK = 52;
	static Karte Hand[];
	static Karte KartenStapel[];
	static int wertDerKarte = 2;
	static int farbeDerKarte = 1;
	static int anzPaar = 0;
	static int anz2Paar = 0;
	static int anzTriple = 0;
	static int anzPoker = 0;
	static int anzStrasse = 0;
	static int anzFlush = 0;
	static int anzStraightFlush = 0;
	static int anzRoyalFlush = 0;
	static int anzFullHouse = 0;

	static boolean royalFlush() {
		int zaehler = 0;
		int Werte[] = new int[Hand.length];
		for (int i = 0; i < Hand.length; i++) {
			Werte[i] = Hand[i].getWert();
		}
		Arrays.sort(Werte);
		if (flush() == true && Werte[0] == 10) {
			for (int i = 1; i < Hand.length; i++) {
				if (Werte[i] == Werte[i - 1] + 1) {
					zaehler++;
				}//halloer01
			}
		} else {
			return false;
		}
		if (zaehler == Hand.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	static boolean straightFlush() {
		if (flush() == true && strasse() == true) {
			return true;
		} else {
			return false;
		}
	}

	static boolean flush() {
		int zaehler = 0;
		int Werte[] = new int[Hand.length];
		for (int i = 0; i < Hand.length; i++) {
			Werte[i] = Hand[i].getFarbe();
		}
		Arrays.sort(Werte);
		for (int i = 1; i < Hand.length; i++) {
			if (Werte[i] == Werte[i - 1]) {
				zaehler++;
			}
		}

		if (zaehler == Hand.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	static boolean strasse() {
		int zaehler = 0;
		int Werte[] = new int[Hand.length];
		for (int i = 0; i < Hand.length; i++) {
			Werte[i] = Hand[i].getWert();
		}
		Arrays.sort(Werte);
		for (int i = 1; i < Hand.length; i++) {
			if (Werte[i] == Werte[i - 1] + 1) {
				zaehler++;
			}
		}

		if (zaehler == Hand.length - 1) {
			return true;
		} else {
			return false;
		}

	}

	static boolean fullHouse() {
		int back = Hand.length - 1;
		Karte karte;
		for (int i = 0; i < Hand.length; i++) {
			for (int j = 0; j < Hand.length; j++) {
				if (j == i) {
					j++;
				}
				if (j != Hand.length) {
					for (int k = 0; k < Hand.length; k++) {
						while (k == i || k == j) {
							k++;
						}
						if (k != Hand.length) {
							if (Hand[k].getWert() == Hand[i].getWert() && Hand[k].getWert() == Hand[j].getWert()) {
								if (Hand[back].getWert() == Hand[i].getWert()) {
									if (Hand[back - 1].getWert() == Hand[i].getWert()) {
										karte = Hand[back - 2];
										Hand[back - 2] = Hand[i];
										Hand[i] = karte;
									} else {
										karte = Hand[back - 1];
										Hand[back - 1] = Hand[i];
										Hand[i] = karte;
									}
								} else {
									karte = Hand[back];
									Hand[back] = Hand[i];
									Hand[i] = karte;
								}
								if (Hand[back - 1].getWert() == Hand[j].getWert()) {
									karte = Hand[back - 2];
									Hand[back - 2] = Hand[j];
									Hand[j] = karte;
								} else {
									karte = Hand[back - 1];
									Hand[back] = Hand[j];
									Hand[j] = karte;
								}
								karte = Hand[back - 2];
								Hand[back] = Hand[k];
								Hand[k] = karte;
								i = 0;
								j = 1;
								if (Hand[i].getWert() == Hand[j].getWert()) {
									return true;
								} else {
									return false;
								}

							}
						}

					}

				}
			}

		}
		return false;
	}

	static boolean zweiPaar() {
		int back = Hand.length - 1;
		Karte k;
		int zaehler = 0;
		for (int i = 0; i < Hand.length; i++) {
			for (int j = 0; j < Hand.length; j++) {
				if (j == i) {
					j++;
				}
				if (j == Hand.length) {
					return false;
				}
				if (Hand[j].getWert() == Hand[i].getWert() && zaehler == 0) {
					k = Hand[back];
					Hand[back] = Hand[j];
					Hand[j] = k;
					k = Hand[back - 1];
					Hand[back - 1] = Hand[i];
					Hand[i] = k;
					i = 0;
					j = 1;
					zaehler = 1;
				}

				if (i <= 3 && j <= 3 && zaehler == 1) {
					if (Hand[j].getWert() == Hand[i].getWert()) {
						return true;
					}
				} else {
					if (zaehler == 1) {
						return false;
					}
				}
			}

		}
		return false;
	}

	static boolean poker() {
		for (int i = 0; i < Hand.length; i++) {
			for (int j = 0; j < Hand.length; j++) {
				if (j == i) {
					j++;
				}
				if (j != Hand.length) {
					for (int k = 0; k < Hand.length; k++) {
						while (k == i || k == j) {
							k++;
						}
						if (k != Hand.length) {
							for (int l = 0; l < Hand.length; l++) {
								while (l == k || l == j || l == i) {
									l++;
								}
								if (l != Hand.length) {
									if (Hand[k].getWert() == Hand[i].getWert() && Hand[k].getWert() == Hand[j].getWert()
											&& Hand[l].getWert() == Hand[k].getWert()) {
										return true;
									}
								}

							}
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
				if (j != Hand.length) {
					for (int k = 0; k < Hand.length; k++) {
						while (k == i || k == j) {
							k++;
						}
						if (k != Hand.length) {
							if (Hand[k].getWert() == Hand[i].getWert() && Hand[k].getWert() == Hand[j].getWert()) {
								return true;
							}
						}

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

		return Hand;
	}

	public static void main(String[] args) {
		for (int j = 0; j <= 999999; j++) {
			if (farbeDerKarte > 4) {
				farbeDerKarte = 1;
			}
			KartenStapel = new Karte[52];
			for (int i = 0; i < KartenStapel.length; i++) {
				if (wertDerKarte < 15) {
					KartenStapel[i] = new Karte(wertDerKarte, farbeDerKarte);
					wertDerKarte++;
				} else {

					wertDerKarte = 2;
					farbeDerKarte++;
					i--;

				}

			}

			karteZiehen(5);
			if (poker() == true) {
				anzPoker++;
			} else if (fullHouse() == true) {
				anzFullHouse++;
			} else if (triple() == true) {
				anzTriple++;
			} else if (zweiPaar() == true) {
				anz2Paar++;
			} else if (paar() == true) {
				anzPaar++;
			} else if (royalFlush() == true) {
				anzRoyalFlush++;
			} else if (straightFlush() == true) {
				anzStraightFlush++;
			} else if (flush() == true) {
				anzFlush++;
			} else if (strasse() == true) {
				anzStrasse++;
			}

		}

		System.out.println("Anzahl der Royal Flush: " + anzRoyalFlush);
		System.out.println("Anzahl der Straight Flush: " + anzStraightFlush);
		System.out.println("Anzahl der Flush: " + anzFlush);
		System.out.println("Anzahl der Full House: " + anzFullHouse);
		System.out.println("Anzahl der Straßen: " + anzStrasse);
		System.out.println("Anzahl der Poker: " + anzPoker);
		System.out.println("Anzahl der Triple: " + anzTriple);
		System.out.println("Anzahl der DoppelPaare: " + anz2Paar);
		System.out.println("Anzahl der Paare: " + anzPaar);
	}

}
