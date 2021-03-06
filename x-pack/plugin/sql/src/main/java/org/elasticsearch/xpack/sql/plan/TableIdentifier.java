/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.sql.plan;

import org.elasticsearch.xpack.sql.tree.Location;

import java.util.Objects;

public class TableIdentifier {

    private final Location location;

    private final String cluster;
    private final String index;

    public TableIdentifier(Location location, String catalog, String index) {
        this.location = location;
        this.cluster = catalog;
        this.index = index;
    }

    public String cluster() {
        return cluster;
    }

    public String index() {
        return index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cluster, index);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        TableIdentifier other = (TableIdentifier) obj;
        return Objects.equals(index, other.index) && Objects.equals(cluster, other.cluster);
    }

    public Location location() {
        return location;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (cluster != null) {
            builder.append(cluster);
        }
        builder.append("][index=");
        builder.append(index);
        builder.append("]");
        return builder.toString();
    }
}
