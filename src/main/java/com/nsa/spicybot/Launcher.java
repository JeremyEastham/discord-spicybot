package com.nsa.spicybot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class Launcher
{
	public static void main( String[] args )
	{
		JDABuilder builder = new JDABuilder( AccountType.BOT );
    	builder.setToken( args[0] );
    	SpicyBot.init( args[0], args[1], args[2] );
    	builder.addEventListener( new SpicyBot() );
    	try {
    		SpicyBot.discord = builder.buildBlocking();
    		SpicyBot.discord.getGuildById( args[1] ).getTextChannelById( args[2] ).sendMessage( "I'm online! Hello @everyone!" );
		} catch( LoginException e )
    	{
			e.printStackTrace();
        } catch( InterruptedException e )
    	{
			e.printStackTrace();
		}
	}
}
