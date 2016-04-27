/*******************************************************************************
 * Copyright (c) 2015
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *******************************************************************************/
package jsettlers.logic.player;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Team implements Serializable {
	private static final long serialVersionUID = 8051219906193296800L;

	private final byte teamId;
	private final LinkedList<Player> members = new LinkedList<Player>();

	public Team(byte teamId) {
		this.teamId = teamId;
	}

	public void registerPlayer(Player player) {
		members.add(player);
	}

	public boolean isMember(byte playerId) {
		for (Player member : members) {
			if (member.playerId == playerId) {
				return true;
			}
		}
		return false;
	}

	public List<Player> getMembers() {
		return members;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Team " + getTeamId() + "\n");
		for (Player curr : members) {
			builder.append(curr.toString());
		}

		return builder.toString();
	}

	public byte getTeamId() {
		return teamId;
	}
}