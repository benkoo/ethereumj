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
package org.ethereum.sharding.processing;

import org.ethereum.db.DbFlushManager;
import org.ethereum.sharding.processing.consensus.NoTransition;
import org.ethereum.sharding.processing.consensus.NumberAsScore;
import org.ethereum.sharding.processing.consensus.ScoreFunction;
import org.ethereum.sharding.processing.consensus.StateTransition;
import org.ethereum.sharding.processing.db.BeaconStore;
import org.ethereum.sharding.processing.state.StateRepository;
import org.ethereum.sharding.processing.validation.BeaconValidator;
import org.ethereum.sharding.processing.validation.StateValidator;

/**
 * A factory that creates {@link BeaconChain} instance.
 *
 * <p>
 *     Instantiates strategy implementations that beacon chain depends on,
 *     after that creates beacon chain itself.
 *
 * @author Mikhail Kalinin
 * @since 16.08.2018
 */
public class BeaconChainFactory {

    public static BeaconChain create(DbFlushManager beaconDbFlusher, BeaconStore store, StateRepository repository) {

        StateTransition transitionFunction = new NoTransition();
        BeaconValidator beaconValidator = new BeaconValidator(store);
        StateValidator stateValidator = new StateValidator();
        ScoreFunction scoreFunction = new NumberAsScore();

        return new BeaconChainImpl(beaconDbFlusher, store, transitionFunction,
                repository, beaconValidator, stateValidator, scoreFunction);
    }
}