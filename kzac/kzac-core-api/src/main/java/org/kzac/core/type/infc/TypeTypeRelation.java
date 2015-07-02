/*
 * Copyright 2011 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at
 *
 *  http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kzac.core.type.infc;

import org.kzac.common.infc.Relationship;

public interface TypeTypeRelation 
    extends Relationship {
    
    /**
     * The key for the type that is the controlling or "main" type in
     * this type-type relationship.
     *
     * @name Owner Type Key
     * @readOnly
     * @required
     */
    public String getOwnerTypeKey();
    
    /**
     * The key for the type that is the controlled or "secondary" type in
     * this type-type relationship.
     *
     * @name Related Type Key
     * @readOnly
     * @required
     */
    public String getRelatedTypeKey ();
    
    /**
     * The rank or ordering of this relationship as compared to other
     * relationships of the same type and same owner type.
     *
     * @name Rank
     * @readOnly
     */    
    public Integer getRank();
}
