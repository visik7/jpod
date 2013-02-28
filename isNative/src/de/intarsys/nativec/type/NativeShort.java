/*
 * Copyright (c) 2008, intarsys consulting GmbH
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * - Neither the name of intarsys nor the names of its contributors may be used
 *   to endorse or promote products derived from this software without specific
 *   prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package de.intarsys.nativec.type;

import de.intarsys.nativec.api.INativeHandle;
import de.intarsys.nativec.api.NativeTools;

/**
 * A wrapper for a primitive short.
 * 
 */
public class NativeShort extends NativeNumber {

	/** The meta class instance */
	public static final NativeShortType META = new NativeShortType();

	static {
		NativeType.register(NativeShort.class, META);
	}

	static public NativeShort createFromAddress(long address) {
		return (NativeShort) NativeShort.META.createNative(NativeTools
				.toHandle(address));
	}

	/**
	 * Create a new wrapper
	 */
	public NativeShort() {
		allocate();
	}

	protected NativeShort(INativeHandle handle) {
		super(handle);
	}

	/**
	 * Create a new wrapper
	 */
	public NativeShort(short value) {
		allocate();
		setValue(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.intarsys.tools.nativec.NativeNumber#byteValue()
	 */
	@Override
	public byte byteValue() {
		return (byte) shortValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.intarsys.graphic.freetype.NativeObject#getMetaClass()
	 */
	@Override
	public INativeType getNativeType() {
		return META;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.intarsys.tools.nativec.NativePrimitive#getValue()
	 */
	public Object getValue() {
		return new Short(shortValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.intarsys.tools.nativec.NativeNumber#intValue()
	 */
	@Override
	public int intValue() {
		return shortValue();
	}

	@Override
	public long longValue() {
		return shortValue();
	}

	public void setValue(Object value) {
		setValue(((Number) value).shortValue());
	}

	public void setValue(short value) {
		handle.setShort(0, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.intarsys.tools.nativec.NativeNumber#shortValue()
	 */
	@Override
	public short shortValue() {
		return handle.getShort(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (getNativeHandle().getAddress() == 0) {
			return "nope - null pointer"; //$NON-NLS-1$
		}
		return String.valueOf(shortValue());
	}
}
