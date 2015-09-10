/*
 * digitalpetri OPC-UA SDK
 *
 * Copyright (C) 2015 Kevin Herron
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.digitalpetri.opcua.stack.core;

import java.util.Optional;
import javax.annotation.Nullable;

import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.QualifiedName;

public enum BuiltinReferenceType implements ReferenceType {

    References(Identifiers.References, "References", null, true, true, null),
    HierarchicalReferences(Identifiers.HierarchicalReferences, "HierarchicalReferences", null, false, true, References),
    NonHierarchicalReferences(Identifiers.NonHierarchicalReferences, "NonHierarchicalReferences", null, true, true, References),
    HasChild(Identifiers.HasChild, "HasChild", null, false, true, HierarchicalReferences),
    Aggregates(Identifiers.Aggregates, "Aggregates", null, false, true, HasChild),
    Organizes(Identifiers.Organizes, "Organizes", "OrganizedBy", false, false, HierarchicalReferences),
    HasComponent(Identifiers.HasComponent, "HasComponent", "ComponentOf", false, false, Aggregates),
    HasOrderedComponent(Identifiers.HasOrderedComponent, "HasOrderedComponent", "OrderedComponentOf", false, false, HasComponent),
    HasProperty(Identifiers.HasProperty, "HasProperty", "PropertyOf", false, false, Aggregates),
    HasSubtype(Identifiers.HasSubtype, "HasSubtype", "SubtypeOf", false, false, HasChild),
    HasModellingRule(Identifiers.HasModellingRule, "HasModellingRule", "ModellingRuleOf", false, false, NonHierarchicalReferences),
    HasTypeDefinition(Identifiers.HasTypeDefinition, "HasTypeDefinition", "TypeDefinitionOf", false, false, NonHierarchicalReferences),
    HasEncoding(Identifiers.HasEncoding, "HasEncoding", "EncodingOf", false, false, NonHierarchicalReferences),
    HasDescription(Identifiers.HasDescription, "HasDescription", "DescriptionOf", false, false, NonHierarchicalReferences),
    HasEventSource(Identifiers.HasEventSource, "HasEventSource", "EventSourceOf", false, false, HierarchicalReferences),
    HasNotifier(Identifiers.HasNotifier, "HasNotifier", "NotifierOf", false, false, HasEventSource),
    GeneratesEvent(Identifiers.GeneratesEvent, "GeneratesEvent", "GeneratedBy", false, false, NonHierarchicalReferences),
    AlwaysGeneratesEvent(Identifiers.AlwaysGeneratesEvent, "AlwaysGeneratesEvent", "AlwaysGeneratedBy", false, false, GeneratesEvent),
    FromState(Identifiers.FromState, "FromState", "ToTransition", false, false, NonHierarchicalReferences),
    ToState(Identifiers.ToState, "ToState", "FromTransition", false, false, NonHierarchicalReferences),
    HasCause(Identifiers.HasCause, "HasCause", "MayBeCausedBy", false, false, NonHierarchicalReferences),
    HasEffect(Identifiers.HasEffect, "HasEffect", "MayBeEffectedBy", false, false, NonHierarchicalReferences),
    HasSubStateMachine(Identifiers.HasSubStateMachine, "HasSubStateMachine", "SubStateMachineOf", false, false, NonHierarchicalReferences),
    HasTrueSubState(Identifiers.HasTrueSubState, "HasTrueSubState", "IsTrueSubStateOf", false, false, NonHierarchicalReferences),
    HasFalseSubState(Identifiers.HasFalseSubState, "HasFalseSubState", "IsFalseSubStateOf", false, false, NonHierarchicalReferences);


    private final NodeId nodeId;
    private final QualifiedName browseName;
    private final String inverseName;
    private final boolean symmetric;
    private final boolean isAbstract;
    private final BuiltinReferenceType superType;

    BuiltinReferenceType(NodeId nodeId,
                         String browseName,
                         @Nullable String inverseName,
                         boolean symmetric,
                         boolean isAbstract,
                         @Nullable BuiltinReferenceType superType) {

        this.nodeId = nodeId;
        this.browseName = new QualifiedName(0, browseName);
        this.inverseName = inverseName;
        this.symmetric = symmetric;
        this.isAbstract = isAbstract;
        this.superType = superType;
    }

    @Override
    public NodeId getNodeId() {
        return nodeId;
    }

    @Override
    public QualifiedName getBrowseName() {
        return browseName;
    }

    @Override
    public Optional<String> getInverseName() {
        return Optional.ofNullable(inverseName);
    }

    @Override
    public boolean isSymmetric() {
        return symmetric;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public Optional<ReferenceType> getSuperType() {
        return Optional.ofNullable(superType);
    }

}
