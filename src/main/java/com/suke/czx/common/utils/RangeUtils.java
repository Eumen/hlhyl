package com.suke.czx.common.utils;

final public class RangeUtils {

	public static final double fee = 0.15d;

	private RangeUtils() {
		super();
	}

	// 按推荐人的锁仓币 一次性返还
	public static double recRange(double d) {
		double range = 0d;
		if (d >= 1 && d <= 4999) {
			range = 0.1d;
		} else if (d >= 5000 && d <= 9999) {
			range = 0.12d;
		} else if (d >= 10000 && d <= 49999) {
			range = 0.15d;
		} else if (d > 50000 && d <= 99999) {
			range = 0.18d;
		} else if (d >= 100000) {
			range = 0.20d;
		} else {
			range = 0;
		}
		return range;
	}

	public static double lockRange(double d) {
		double range = 0d;
		if (d >= 1 && d <= 4999) {
			range = 0.001;
		} else if (d >= 5000 && d <= 9999) {
			range = 0.0015d;
		} else if (d >= 10000 && d <= 49999) {
			range = 0.002d;
		} else if (d > 50000 && d <= 99999) {
			range = 0.0025;
		} else if (d >= 100000) {
			range = 0.003;
		} else {
			range = 0;
		}
		return range;
	}
}
