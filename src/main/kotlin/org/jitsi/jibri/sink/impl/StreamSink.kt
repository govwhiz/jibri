/*
 * Copyright @ 2018 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.jitsi.jibri.sink.impl

import org.jitsi.jibri.sink.Sink

/**
 * [StreamSink] represents a sink which will write to a network stream
 */
class StreamSink(val url: String, val streamingMaxBitrate: Int, val streamingBufSize: Int, val videoStreamId: String) : Sink {
    override val path: String = url
    override val format: String = "mpegts"
    override val options: Array<String> = arrayOf(
        "-maxrate", "${streamingMaxBitrate}k",
        "-minrate", "${streamingMaxBitrate}k",
        "-bt", "${streamingMaxBitrate}k",
        "-b", "${streamingMaxBitrate}k",
        "-bufsize", "${streamingBufSize}k",
        "-vcodec", "libx264",
        "-streamid", "0:0x$videoStreamId"
    )
}
