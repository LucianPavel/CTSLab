package ro.ase.cts.refactoring;

public class StrategieMarketing {
	
	public static final int VECHIME_MAXIMA = 10;
	public static final float DISCOUNT_VECHIME_MAXIMA = 0.15f;
	
	public static float getDiscount(int vechime) {
		return (vechime > VECHIME_MAXIMA) ? DISCOUNT_VECHIME_MAXIMA : (float)vechime/100;
	}
	
	public static float aplicaDiscount(float pretInitial, float valoareDiscount, float discountExtra) {
		return (1 - valoareDiscount) * ((1- discountExtra) * pretInitial);
	}
	
	public float calculeazaPretFinal(TipProdus tipProdus, float pretInitial, int vechime) {
		return (tipProdus != TipProdus.NOU) ? aplicaDiscount(pretInitial, getDiscount(vechime), tipProdus.getDiscount()) : pretInitial;
	}
	
}
