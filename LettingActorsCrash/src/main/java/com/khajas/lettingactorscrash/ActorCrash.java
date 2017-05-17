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
package com.khajas.lettingactorscrash;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
/**
 *
 * @author Anwar
 */
public class ActorCrash extends UntypedActor{
    public static void main(String...args){
        final ActorSystem system = ActorSystem.create("actorSystem");
        final ActorRef crashRef = system.actorOf(Props.create(ActorCrash.class));
        final ActorRef dividingActorRef = system.actorOf(Props.create(DividingActor.class));
        
        dividingActorRef.tell(5,crashRef);
        dividingActorRef.tell(0, crashRef);
        dividingActorRef.tell(1, crashRef);
        dividingActorRef.tell(10, crashRef);
        dividingActorRef.tell(2, crashRef);
        
        system.terminate();
    }
    
    @Override
    public void onReceive(Object message){
        System.out.printf("Recevied result: "+message+"\n");
    }
}
