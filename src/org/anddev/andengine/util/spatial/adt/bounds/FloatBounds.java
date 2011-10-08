package org.anddev.andengine.util.spatial.adt.bounds;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 23:12:02 - 07.10.2011
 */
public class FloatBounds implements IBounds {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public final float mLeft;
	public final float mRight;
	public final float mTop;
	public final float mBottom;
	public final float mWidth;
	public final float mHeight;

	// ===========================================================
	// Constructors
	// ===========================================================

	public FloatBounds(final float pLeft, final float pRight, final float pTop, final float pBottom) {
		this.mLeft = pLeft;
		this.mRight = pRight;
		this.mTop = pTop;
		this.mBottom = pBottom;

		this.mWidth = this.mRight - this.mLeft;
		this.mHeight = this.mBottom - this.mTop;

// this.left < this.right && this.top < this.bottom
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public float getLeft() {
		return this.mLeft;
	}

	public float getRight() {
		return this.mRight;
	}

	public float getTop() {
		return this.mTop;
	}

	public float getBottom() {
		return this.mBottom;
	}

	public float getWidth() {
		return this.mWidth;
	}

	public float getHeight() {
		return this.mHeight;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	@Override
	public boolean intersects(final IBounds pBounds) {
		if(!(pBounds instanceof FloatBounds)) {
			throw new IllegalArgumentException("pBounds must be an instance of '" + FloatBounds.class.getSimpleName() + "'.");
		}

		final FloatBounds other = (FloatBounds) pBounds;

		return (this.mLeft < other.mRight) && (other.mLeft < this.mRight) && (this.mTop < other.mBottom) && (other.mTop < this.mBottom);
	}

	@Override
	public boolean contains(final IBounds pBounds) {
		if(!(pBounds instanceof FloatBounds)) {
			throw new IllegalArgumentException("pBounds must be an instance of '" + FloatBounds.class.getSimpleName() + "'.");
		}

		final FloatBounds other = (FloatBounds) pBounds;

		return (this.mLeft <= other.mLeft) && (this.mTop <= other.mTop) && (this.mRight >= other.mRight) && (this.mBottom >= other.mBottom);
	}

	@Override
	public boolean isEmpty() {
		return this.mLeft >= this.mRight || this.mTop >= this.mBottom;
	}

	@Override
	public FloatBounds split(final BoundsSplit pBoundsSplit) {
		// TODO Does split work properly, when "mWidth % 2 != 0" or "mHeight % 2 != 0"

		final float halfWidth = this.mWidth / 2;
		final float halfHeight = this.mHeight / 2;

		switch(pBoundsSplit) {
			case TOP_LEFT:
				return new FloatBounds(this.mLeft, this.mLeft + halfWidth, this.mTop, this.mTop + halfHeight);
			case TOP_RIGHT:
				return new FloatBounds(this.mLeft + halfWidth, this.mRight, this.mTop, this.mTop + halfHeight);
			case BOTTOM_LEFT:
				return new FloatBounds(this.mLeft, this.mLeft + halfWidth, this.mTop + halfHeight, this.mBottom);
			case BOTTOM_RIGHT:
				return new FloatBounds(this.mLeft + halfWidth, this.mRight, this.mTop + halfHeight, this.mBottom);
			default:
				throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}