package org.araymond.joal.core.client.emulated.generator.peerid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.turn.ttorrent.common.protocol.TrackerMessage.AnnounceRequestMessage.RequestEvent;
import org.araymond.joal.core.ttorent.client.MockedTorrent;

/**
 * Created by raymo on 16/07/2017.
 */
public class NeverRefreshPeerIdGenerator extends PeerIdGenerator {

    private final String peerId;
    @JsonCreator
    NeverRefreshPeerIdGenerator(
            @JsonProperty(value = "prefix", required = true) final String prefix,
            @JsonProperty(value = "pattern", required = true) final String pattern,
            @JsonProperty(value = "shouldUrlEncode", required = true) final boolean isUrlEncoded
    ) {
        super(prefix, pattern, isUrlEncoded);

        this.peerId = generatePeerId();
    }

    @Override
    public String getPeerId(final MockedTorrent torrent, final RequestEvent event) {
        return peerId;
    }

}
