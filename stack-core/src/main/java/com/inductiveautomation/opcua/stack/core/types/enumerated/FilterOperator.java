package com.inductiveautomation.opcua.stack.core.types.enumerated;

import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEnumeration;

public enum FilterOperator implements UaEnumeration {

    Equals(0),
    IsNull(1),
    GreaterThan(2),
    LessThan(3),
    GreaterThanOrEqual(4),
    LessThanOrEqual(5),
    Like(6),
    Not(7),
    Between(8),
    InList(9),
    And(10),
    Or(11),
    Cast(12),
    InView(13),
    OfType(14),
    RelatedTo(15),
    BitwiseAnd(16),
    BitwiseOr(17);

    private final int value;

    private FilterOperator(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static void encode(FilterOperator filterOperator, UaEncoder encoder) {
        encoder.encodeInt32(null, filterOperator.ordinal());
    }

    public static FilterOperator decode(UaDecoder decoder) {
        int value = decoder.decodeInt32(null);

        return value < values().length ? values()[value] : null;
    }

    static {
        DelegateRegistry.registerEncoder(FilterOperator::encode, FilterOperator.class);
        DelegateRegistry.registerDecoder(FilterOperator::decode, FilterOperator.class);
    }

}
