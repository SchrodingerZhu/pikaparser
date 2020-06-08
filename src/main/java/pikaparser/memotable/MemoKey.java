//
// This file is part of the pika parser reference implementation:
//
//     https://github.com/lukehutch/pikaparser
//
// The pika parsing algorithm is described in the following paper: 
//
//     Pika parsing: reformulating packrat parsing as a dynamic programming algorithm solves the left recursion
//     and error recovery problems. Luke A. D. Hutchison, May 2020.
//     https://arxiv.org/abs/2005.06444
//
// This software is provided under the MIT license:
//
// Copyright 2020 Luke A. D. Hutchison
//  
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
// documentation files (the "Software"), to deal in the Software without restriction, including without limitation
// the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
// and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all copies or substantial portions
// of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
// THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
// CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
// DEALINGS IN THE SOFTWARE.
//
package pikaparser.memotable;

import pikaparser.clause.Clause;

/** A memo table key, consisting of a {@link Clause} and a match start position. */
public class MemoKey {
    /** The {@link Clause}. */
    public final Clause clause;

    /** The start position. */
    public final int startPos;

    public MemoKey(Clause clause, int startPos) {
        this.clause = clause;
        this.startPos = startPos;
    }

    @Override
    public int hashCode() {
        return clause.hashCode() ^ startPos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof MemoKey)) {
            return false;
        }
        MemoKey other = (MemoKey) obj;
        return this.clause == other.clause && this.startPos == other.startPos;
    }

    public String toStringWithRuleNames() {
        return clause.toStringWithRuleNames() + " : " + startPos;
    }

    @Override
    public String toString() {
        return clause + " : " + startPos;
    }
}
