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

/**
 *
 * @author Anwar
 */
public class MessagingSystem {
    private final ActorSystem messageSystem;
    private final ActorRef msg_sender;
    private final ActorRef msg_recepient;
    public MessagingSystem(){
        messageSystem=ActorSystem.create("messaging_system");
        msg_sender=messageSystem.actorOf(Props.create(MessageActor.class), "msg_sender");
        msg_recepient=messageSystem.actorOf(Props.create(MessageActor.class), "msg_recepient");
    }
    public static void main(String[] args){
        MessagingSystem ms=new MessagingSystem();
        ms.msg_recepient.tell(new Message("Hello world!"), ms.msg_sender);
        ms.messageSystem.stop(ms.msg_recepient);
        ms.messageSystem.terminate();
    }
}