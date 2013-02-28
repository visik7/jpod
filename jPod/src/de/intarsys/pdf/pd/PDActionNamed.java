/*
 * Copyright (c) 2007, intarsys consulting GmbH
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
package de.intarsys.pdf.pd;

import de.intarsys.pdf.cos.COSBasedObject;
import de.intarsys.pdf.cos.COSName;
import de.intarsys.pdf.cos.COSObject;

/**
 * A named action.
 * <p>
 * When executed the action performs one of the defined named actions within the
 * document.
 * 
 */
public class PDActionNamed extends PDAction {
	/**
	 * The meta class implementation
	 */
	static public class MetaClass extends PDAction.MetaClass {
		protected MetaClass(Class instanceClass) {
			super(instanceClass);
		}

		@Override
		protected COSBasedObject doCreateCOSBasedObject(COSObject object) {
			return new PDActionNamed(object);
		}
	}

	/** The meta class instance */
	static public final MetaClass META = new MetaClass(MetaClass.class
			.getDeclaringClass());

	static public final COSName CN_ActionType_Named = COSName.constant("Named"); //$NON-NLS-1$ 

	public static final COSName DK_Name = COSName.constant("N"); //$NON-NLS-1$

	public static final COSName CN_Name_NextPage = COSName.constant("NextPage"); //$NON-NLS-1$

	public static final COSName CN_Name_PrevPage = COSName.constant("PrevPage"); //$NON-NLS-1$

	public static final COSName CN_Name_FirstPage = COSName
			.constant("FirstPage"); //$NON-NLS-1$

	public static final COSName CN_Name_LastPage = COSName.constant("LastPage"); //$NON-NLS-1$

	static public PDActionNamed createNew(String name) {
		PDActionNamed result = (PDActionNamed) PDActionNamed.META.createNew();
		result.cosSetName(COSName.create(name));
		return result;
	}

	protected PDActionNamed(COSObject object) {
		super(object);
	}

	@Override
	public COSName cosGetExpectedActionType() {
		return CN_ActionType_Named;
	}

	public COSName cosGetName() {
		return cosGetField(DK_Name).asName();
	}

	public COSName cosSetName(COSName name) {
		return cosSetField(DK_Name, name).asName();
	}
}