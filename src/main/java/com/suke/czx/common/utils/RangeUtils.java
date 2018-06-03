package com.suke.czx.common.utils;

final public class RangeUtils {

	private RangeUtils() {
		super();
	}

	// 按推荐人的锁仓币 返还60天
	public static double getRange(double d) {
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
		}
		return range;
	}
	
	public static double lockRange(double d){
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
		}
		return range;
	}
}
