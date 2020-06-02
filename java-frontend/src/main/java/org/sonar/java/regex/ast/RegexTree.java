/*
 * SonarQube Java
 * Copyright (C) 2012-2020 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.java.regex.ast;

public abstract class RegexTree extends RegexSyntaxElement {
  public enum Kind {
    PLAIN_CHARACTER, SEQUENCE, DISJUNCTION, GROUP, REPETITION
  }

  protected RegexTree(RegexSource source, IndexRange range) {
    super(source, range);
  }

  public abstract void accept(RegexVisitor visitor);

  public abstract Kind kind();

  public boolean is(Kind... kinds) {
    Kind thisKind = kind();
    for (Kind kind : kinds) {
      if (thisKind == kind) {
        return true;
      }
    }
    return false;
  }

}