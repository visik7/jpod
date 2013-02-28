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
package de.intarsys.cwt.freetype.nativec;

import de.intarsys.nativec.api.INativeHandle;
import de.intarsys.nativec.type.INativeObject;
import de.intarsys.nativec.type.INativeType;
import de.intarsys.nativec.type.NativeStaticStruct;
import de.intarsys.nativec.type.NativeStructType;
import de.intarsys.nativec.type.StructMember;

/**
 * A structure used to model the metrics of a single glyph. The values are
 * expressed in 26.6 fractional pixel format; if the flag FT_LOAD_NO_SCALE is
 * used, values are returned in font units instead.
 */
public class FTGlyphMetrics extends NativeStaticStruct {
	/**
	 * The meta class implementation
	 */
	public static class MetaClass extends NativeStructType {
		protected MetaClass(Class instanceClass) {
			super(instanceClass);
		}

		@Override
		public INativeObject createNative(INativeHandle handle) {
			return new FTGlyphMetrics(handle);
		}

	}

	/** The meta class instance */
	public static final MetaClass META = new MetaClass(MetaClass.class
			.getDeclaringClass());
	
	private static final StructMember Height;
	private static final StructMember HoriAdvance;
	private static final StructMember VeriAdvance;
	private static final StructMember Width;

	static {
		Width= META.declare("width", FTPos.META); //$NON-NLS-1$
		Height = META.declare("height", FTPos.META); //$NON-NLS-1$
		META.declare("horiBearingX", FTPos.META); //$NON-NLS-1$
		META.declare("horiBearingY", FTPos.META); //$NON-NLS-1$
		HoriAdvance = META.declare("horiAdvance", FTPos.META); //$NON-NLS-1$
		META.declare("veriBearingX", FTPos.META); //$NON-NLS-1$
		META.declare("veriBearingY", FTPos.META); //$NON-NLS-1$
		VeriAdvance = META.declare("veriAdvance", FTPos.META); //$NON-NLS-1$
	}

	public FTGlyphMetrics() {
		super();
	}

	protected FTGlyphMetrics(INativeHandle handle) {
		super(handle);
	}

	public long getHeight() {
		return Height.getCLong(this, 0);
	}

	public long getHoriAdvance() {
		return HoriAdvance.getCLong(this, 0);
	}

	@Override
	public INativeType getNativeType() {
		return META;
	}

	public long getVeriAdvance() {
		return VeriAdvance.getCLong(this, 0);
	}

	public long getWidth() {
		return Width.getCLong(this, 0);
	}

}
