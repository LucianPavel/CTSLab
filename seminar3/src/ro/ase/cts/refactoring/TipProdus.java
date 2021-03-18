package ro.ase.cts.refactoring;

public enum TipProdus {
	NOU(0),
	DISCOUNT(.1f),
	STOC_LIMITAT(.25f),
	SFARSIT_DE_SEZON(.35f),
	CATEGORIE_NOUA(.45f);
	
	private float discount;
	TipProdus(float discount) {
		this.discount = discount;
	}
	public float getDiscount() {
		return discount;
	}
}
