package com.tas.springmvc.demo.common;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDUtils {

	private static final long NUM_100NS_INTERVALS_SINCE_UUID_EPOCH = 0x01b21dd213814000L;

	public static UUID randomUUID() {
		return UUID.randomUUID();
	}

	public static byte[] randomUUIDAsBytes() {
		return uuidToBytes(randomUUID());
	}

	public static String randomUUIDAsString() {
		return randomUUID().toString();
	}

	/**************************************************************
	 * TIME BASED UUID
	 **************************************************************/

	public static long getTimeFromUUID(UUID uuid) {
		return (uuid.timestamp() - NUM_100NS_INTERVALS_SINCE_UUID_EPOCH) / 10000;
	}

	public static boolean isTimeBaseUUID(UUID uuid) {
		return uuid.version() == 1;
	}

	public static byte[] uuidToBytes(UUID uuid) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());
		return bb.array();
	}

	public static byte[] uuidToBytes(String uuidString) {
		return uuidToBytes(UUID.fromString(uuidString));
	}

	public static UUID bytesToUUID(byte[] bytes) {
		if (bytes.length != 16) {
			throw new IllegalArgumentException();
		}
		int i = 0;
		long msl = 0;
		for (; i < 8; i++) {
			msl = (msl << 8) | (bytes[i] & 0xFF);
		}
		long lsl = 0;
		for (; i < 16; i++) {
			lsl = (lsl << 8) | (bytes[i] & 0xFF);
		}
		return new UUID(msl, lsl);
	}

	public static String bytesToUUIDString(byte[] bytes) {
		return bytesToUUID(bytes).toString();
	}
	public string (){
		gsdlfs;p
}
