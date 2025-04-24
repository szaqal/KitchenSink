package jsch.key.auth;

import com.jcraft.jsch.Logger;

/**
 * Wraps up logging information from JSCH library.
 * 
 * @author malczyk.pawel@gmail.com
 *
 */
public class JschLogger implements Logger {

	public boolean isEnabled(int arg0) {
		return true;
	}

	public void log(int arg0, String arg1) {
		System.out.println(String.format("[SFTP/SSH -> %s]", arg1));
	}
}
