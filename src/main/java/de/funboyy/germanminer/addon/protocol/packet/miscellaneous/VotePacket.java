package de.funboyy.germanminer.addon.protocol.packet.miscellaneous;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class VotePacket implements Packet {

  private int votes;
  private int maxVotes;

  public VotePacket() {
  }

  public VotePacket(final int votes, final int maxVotes) {
    this.votes = votes;
    this.maxVotes = maxVotes;
  }

  public int getVotes() {
    return votes;
  }

  public int getMaxVotes() {
    return maxVotes;
  }

  @Override
  public void write(@NotNull final PayloadWriter writer) {
    writer.writeVarInt(this.votes);
    writer.writeVarInt(this.maxVotes);
  }

  @Override
  public void read(@NotNull final PayloadReader reader) {
    this.votes = reader.readVarInt();
    this.maxVotes = reader.readVarInt();
  }

}
