/*
 * Copyright (C) 2017 Anwar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.khajas.parallelmessageprocessing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 *
 * @author Anwar
 */
public class MultiActor {
    // This is an inefficient approach that doesn't use router
    public static void main(String...args){
        final ActorSystem system = ActorSystem.create("actorSystem");
        final ActorRef ref = system.actorOf(Props.create(LongRunningActor.class));
        System.out.println("Sending M1");
        ref.tell("Message 1",null);
        System.out.println("Sending M2");
        ref.tell("Message 2",null);
        System.out.println("Sending M3");
        ref.tell("Message 3",null);
//        system.terminate();
//      If terminate is called then the system may not wait for threads to exit
//      this could potentially result in dead-letters
    }
}
/////////////////   END OF SOURCE FILE  //////////////////