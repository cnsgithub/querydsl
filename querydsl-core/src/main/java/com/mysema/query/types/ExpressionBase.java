/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.types;

import javax.annotation.Nullable;

/**
 * ExpressionBase is the base class for Expression implementations
 * 
 * @author tiwe
 *
 * @param <T> expression type
 */
public abstract class ExpressionBase<T> implements Expression<T>{

    private static final long serialVersionUID = -8862014178653364345L;

    private final Class<? extends T> type;
    
    @Nullable
    private volatile String toString;

    public ExpressionBase(Class<? extends T> type) {
        this.type = type;
    }
    
    public final Class<? extends T> getType() {
        return type;
    }
    
    @Override
    public final String toString() {
        if (toString == null) {            
            toString = accept(ToStringVisitor.DEFAULT, Templates.DEFAULT);
        }
        return toString;
    }
    
}
