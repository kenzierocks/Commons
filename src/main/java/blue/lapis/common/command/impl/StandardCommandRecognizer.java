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
package blue.lapis.common.command.impl;

import blue.lapis.common.command.CommandRecognizer;
import blue.lapis.common.command.LapisCommand;
import org.spongepowered.api.util.command.CommandSource;

import javax.annotation.Nonnull;

/**
 * Straightforward implementation of CommandRecognizer
 */
public class StandardCommandRecognizer implements CommandRecognizer {
    public static final StandardCommandRecognizer INSTANCE = new StandardCommandRecognizer();

    @Override
    public boolean recognize(@Nonnull final CommandSource source,
                             @Nonnull final String inputLine,
                             @Nonnull final LapisCommand command) {

        return inputLine.equalsIgnoreCase(command.getName()) ||
                Parsing.startsWithIgnoreCase(inputLine, command.getName() + " ");
    }
}
