package net.leawind.mc.util.smoothvalue;


import net.leawind.mc.util.Vectors;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("unused")
public class ExpSmoothVec3 extends ExpSmoothValue<Vec3> {
	public ExpSmoothVec3 () {
		value        = Vec3.ZERO;
		target       = Vec3.ZERO;
		smoothFactor = Vec3.ZERO;
	}

	public ExpSmoothVec3 setTarget (double x, double y, double z) {
		this.target = new Vec3(x, y, z);
		return this;
	}

	public ExpSmoothVec3 setValue (double x, double y, double z) {
		this.value = new Vec3(x, y, z);
		return this;
	}

	@Override
	public ExpSmoothVec3 update (double tickTime) {
		super.preUpdate();
		value = Vectors.lerp(value, target, Vectors.pow(smoothFactor, tickTime).reverse().add(1, 1, 1));
		return this;
	}

	@Override
	public Vec3 get (float delta) {
		return Vectors.lerp(lastValue, value, delta);
	}

	@Override
	public ExpSmoothVec3 setSmoothFactor (double smoothFactor) {
		return setSmoothFactor(smoothFactor, smoothFactor, smoothFactor);
	}

	private ExpSmoothVec3 setSmoothFactor (double x, double y, double z) {
		this.smoothFactor = new Vec3(x, y, z);
		return this;
	}

	@Override
	public ExpSmoothVec3 setSmoothFactor (Vec3 k, Vec3 t) {
		this.smoothFactor = new Vec3(Math.pow(k.x, 1 / t.x), Math.pow(k.y, 1 / t.y), Math.pow(k.z, 1 / t.z));
		return this;
	}
}
