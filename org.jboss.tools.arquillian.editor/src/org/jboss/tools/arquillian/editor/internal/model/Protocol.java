/*************************************************************************************
 * Copyright (c) 2014 Red Hat, Inc. and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     JBoss by Red Hat - Initial implementation.
 ************************************************************************************/
package org.jboss.tools.arquillian.editor.internal.model;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Enablement;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.NoDuplicates;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * 
 * @author snjeza
 * 
 */
public interface Protocol extends Element {

	ElementType TYPE = new ElementType(Protocol.class);

	@Label(standard = "Type")
	@XmlBinding(path = "@type")
	@Type(base = ProtocolType.class)
	@NoDuplicates
	ValueProperty PROP_TYPE = new ValueProperty(TYPE, "Type"); //$NON-NLS-1$

	Value<String> getType();
	void setType(String type);

	@Type(base = Property.class)
	@Label(standard = "Property")
	@Enablement( expr = "${ Type != null }" )
	@XmlListBinding(mappings = @XmlListBinding.Mapping(element = "property", type = Property.class))
	ListProperty PROP_PROPERTY = new ListProperty(TYPE, "Property"); //$NON-NLS-1$

	ElementList<Property> getProperties();
}
