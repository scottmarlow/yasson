/*******************************************************************************
 * Copyright (c) 2016, 2017 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * Roman Grigoriadi
 ******************************************************************************/

package org.eclipse.yasson.internal.serializer;

import org.eclipse.yasson.internal.Unmarshaller;
import org.eclipse.yasson.internal.model.JsonBindingModel;

import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonString;
import java.lang.reflect.Type;

/**
 * Deserializer for {@link JsonString} type.
 * 
 * @author David Kral
 */
public class JsonStringTypeDeserializer extends AbstractValueTypeDeserializer<JsonString> {

    /**
     * Creates a new instance.
     *
     * @param model Binding model.
     */
    public JsonStringTypeDeserializer(JsonBindingModel model) {
        super(JsonString.class, model);
    }

    @Override
    protected JsonString deserialize(String jsonValue, Unmarshaller unmarshaller, Type rtType) {
        final JsonBuilderFactory factory = unmarshaller.getJsonbContext().getJsonProvider().createBuilderFactory(null);
        final JsonObject jsonObject = factory.createObjectBuilder()
                .add("json", jsonValue)
                .build();
        return jsonObject.getJsonString("json");
    }
}
