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

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

/**
 *
 * @author Anwar
 */
public class DividingActor extends UntypedActor{

    @Override
    public void onReceive(Object message) {
        if(message instanceof Integer){
            Integer number=(Integer)message;
            try{
                int result = 10/number;
                this.getSender().tell(result, getSelf());
            }catch(Exception e){
                this.getSender().tell(e.getLocalizedMessage(),getSelf());
            }            
        }
    }
    
    @Override
    public SupervisorStrategy supervisorStrategy(){
        return new OneForOneStrategy(
            10, Duration.Inf(),
            new Function<Throwable, SupervisorStrategy.Directive>(){
                @Override
                public SupervisorStrategy.Directive apply(Throwable t){
                    return SupervisorStrategy.restart();
                }
            });
    }
}
//////////////////  END OF SOURCE FILE  ////////////////////////