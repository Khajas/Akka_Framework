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
package com.khajas.messageactors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import java.io.Serializable;
import java.util.Date;

/**
 *  Message actor class
 * @author Anwar
 */
public class MessageActor extends UntypedActor{
    @Override
    public void onReceive(Object message) {
        if(message instanceof Message){
            Message m= (Message) message;
            System.out.printf("Message [%s] received at %s%n From: %s %nTo: %s%n",
                    m.getMessage(),
                    new Date().toString(),
                    this.getSender(),
                    this.getSelf());
        }
    }
}
