package org.anddev.andengine.entity;


/**
 * @author Nicolas Gramlich
 * @since 12:06:43 - 11.03.2010
 */
public abstract class BaseStaticEntity extends BaseEntity implements IStaticEntity {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected final float mBaseX;
	protected final float mBaseY;

	protected float mX;
	protected float mY;

	// ===========================================================
	// Constructors
	// ===========================================================

	public BaseStaticEntity(final float pX, final float pY) {
		this.mBaseX = pX;
		this.mBaseY = pY;

		this.mX = pX;
		this.mY = pY;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	@Override
	public float getX() {
		return this.mX;
	}

	@Override
	public float getY() {
		return this.mY;
	}

	@Override
	public float getBaseX() {
		return this.mBaseX;
	}

	@Override
	public float getBaseY() {
		return this.mBaseY;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	protected void onPositionChanged(){
		
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}