package nc.tile.internal.inventory;

import net.minecraft.util.IStringSerializable;

public enum ItemSorption implements IStringSerializable {
	IN, OUT, BOTH, NON;
	
	public boolean canReceive() {
		return this == IN || this == BOTH;
	}
	
	public boolean canExtract() {
		return this == OUT || this == BOTH;
	}
	
	public boolean canConnect() {
		return this != NON;
	}
	
	public ItemSorption next() {
		switch (this) {
		case IN:
			return OUT;
		case OUT:
			return BOTH;
		case BOTH:
			return NON;
		case NON:
			return IN;
		default:
			return NON;
		}
	}

	@Override
	public String getName() {
		switch (this) {
		case IN:
			return "in";
		case OUT:
			return "out";
		case BOTH:
			return "both";
		case NON:
			return "non";
		default:
			return "non";
		}
	}
}
