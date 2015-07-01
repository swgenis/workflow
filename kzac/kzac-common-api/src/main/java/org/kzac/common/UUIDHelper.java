package org.kzac.common;

public class UUIDHelper {

    public static String genStringUUID() {
	return java.util.UUID.randomUUID().toString();
    }

    public static String genStringUUID(String originalUUID) {
	if (originalUUID != null && !originalUUID.isEmpty()) {
	    try {
		return java.util.UUID.fromString(originalUUID).toString();
	    } catch (IllegalArgumentException e) {
		return originalUUID;
	    }
	}
	return genStringUUID();
    }
}
