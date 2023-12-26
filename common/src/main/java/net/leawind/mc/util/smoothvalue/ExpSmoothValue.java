package net.leawind.mc.util.smoothvalue;


@SuppressWarnings("unused")
public abstract class ExpSmoothValue<T> implements ISmoothValue<T> {
	public    T smoothFactor;
	protected T value;
	protected T target;

	final public ExpSmoothValue<T> setTarget (T target) {
		this.target = target;
		return this;
	}

	/**
	 * @param tickTime 经过的时间（s）
	 */
	abstract public ExpSmoothValue<T> update (double tickTime);

	final public T get () {
		return value;
	}

	final public ExpSmoothValue<T> setValue (T value) {
		this.value = value;
		return this;
	}

	final public ExpSmoothValue<T> setSmoothFactor (T decreaseSpeed) {
		this.smoothFactor = decreaseSpeed;
		return this;
	}

	abstract ExpSmoothValue<T> setSmoothFactor (double decreaseSpeed);

	/**
	 * 每隔 deltaTime 秒，value 变为原来的 multiplier 倍
	 */
	abstract ExpSmoothValue<T> setSmoothFactor (T multiplier, T deltaTime);
}
