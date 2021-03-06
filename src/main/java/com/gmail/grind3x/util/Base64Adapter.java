package com.gmail.grind3x.util;

import org.apache.commons.codec.binary.Base64;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public final class Base64Adapter extends XmlAdapter<String, byte[]> {
    public byte[] unmarshal(String s) {
        if (s == null)
            return null;
        return Base64.decodeBase64(s);
    }

    public String marshal(byte[] bytes) {
        if (bytes == null)
            return null;
        return Base64.encodeBase64String(bytes);
    }
}
