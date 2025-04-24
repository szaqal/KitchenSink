package jsch.key.auth;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Vector;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * malczyk.pawel@gmail.com
 *
 */
public class App 
{

	/**
	 * Path where public key file can be found
	 * most likely ${HOME}/.ssh/id_rsa.pub
	 */
	private final String publicKeyPath;
	
	/**
	 * Path where public key file can be found
	 * most likely ${HOME}/.ssh/id_rsa
	 */
	private final String privateKeyPath;
	
	/**
	 * User account login on remote server.
	 */
	private final String sshLogin;
	
	/**
	 * Password that grants access to private key file.
	 */
	private final String privateKeyPassword;
	
	/**
	 * URL pointing to remote directory which contents will be listed.
	 */
	private final String sftpUrl;
	
	/**
	 * Constructor.
	 * @param args arguments array passed from command line.
	 */
	public App(String []args) {
		sshLogin = args[0];
		publicKeyPath = args[1];
		privateKeyPath=args[2];
		privateKeyPassword=args[3];
		sftpUrl = args[4];
		System.out.println(String.format("Login %s \npublicKey %s \nprivateKey %s \nkeyPasswd %s \nURL %s", 
				sshLogin, publicKeyPath, privateKeyPath, privateKeyPassword, sftpUrl));
	}
	
	/**
	 * Lists directory files on remote server.
	 * @throws URISyntaxException 
	 * @throws JSchException 
	 * @throws SftpException 
	 */
	private void listFiles() throws URISyntaxException, JSchException, SftpException {
		
		JSch jsch = new JSch();
		JSch.setLogger(new JschLogger());
		setupSftpIdentity(jsch);

		URI uri = new URI(sftpUrl);
		Session session = jsch.getSession(sshLogin, uri.getHost(), 22);
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();
		System.out.println("Connected to SFTP server");

		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftpChannel = (ChannelSftp) channel;
		Vector<LsEntry> directoryEntries = sftpChannel.ls(uri.getPath());
		for (LsEntry file : directoryEntries) {
			System.out.println(String.format("File - %s", file.getFilename()));
		}
		sftpChannel.exit();
		session.disconnect();
	}
	
	private void setupSftpIdentity(JSch jsch) throws JSchException {
		try {
			byte [] privateKey = IOUtils.toByteArray(new FileInputStream(privateKeyPath));
			byte [] publicKey = IOUtils.toByteArray(new FileInputStream(publicKeyPath));
			byte [] passphrase = privateKeyPassword.getBytes();	
			jsch.addIdentity(sshLogin, privateKey, publicKey, passphrase);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main method
	 * @param args arguments passed through commandline.
	 */
	public static void main(String[] args) throws Exception {
		App main = new App(args);
		main.listFiles();
	}
}
