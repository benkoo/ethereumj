/*
 * Copyright (c) [2016] [ <ether.camp> ]
 * This file is part of the ethereumJ library.
 *
 * The ethereumJ library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ethereumJ library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the ethereumJ library. If not, see <http://www.gnu.org/licenses/>.
 */
package org.ethereum.sharding.pubsub;

import org.ethereum.sharding.domain.Beacon;

/**
 * Event that is triggered when beacon chain is just loaded.
 *
 * <p>
 *     Shares beacon chain head that is loaded from database.
 *
 * @author Mikhail Kalinin
 * @since 28.08.2018
 */
public class BeaconChainLoaded extends Event<BeaconChainLoaded.Data> {

    public static class Data {
        private final Beacon head;

        public Data(Beacon head) {
            this.head = head;
        }

        public Beacon getHead() {
            return head;
        }
    }

    public BeaconChainLoaded(Beacon head) {
        super(new Data(head));
    }
}