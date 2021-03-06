/*
 * LapisCommons
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package blue.lapis.common.permission.impl;

import blue.lapis.common.command.impl.Parsing;
import blue.lapis.common.permission.Group;
import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Represents a conditional permission, such as x&y=>{ foo }
 */
public class CompoundGroup extends StandardGroup {

    private IndexedSet<Group> supers;

    public CompoundGroup(@Nonnull String name) {
        super(name);
        List<String> implication = Parsing.split(name, "=>");
        Preconditions.checkArgument(implication.size() == 2,
                "Must have exactly one 'implies' (=>) per compound group.");
        List<String> terms = Parsing.split(implication.get(0), "&");
    }

    @Override
    public boolean grantsPermission(String node, int depth, Group origin) {
        return false;
    }
}
