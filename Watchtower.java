package passwordmanager;

import java.net.*;
import java.io.*;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.validator.routines.*;

/**
 * @author jayeon
 * The Watchtower class models the methods found in the Watchtower page
 * of 1Password
 * 
 * The class contains three methods with the goal of checking repeat logins
 * and checking that the website for which the login is stored is secure
 * (whether it starts with https://)
 *  
 */

public class Watchtower {
	private Map<String, Integer> repeatPasswords = new HashMap<>();
	
	
	/**
	 * Identifies the number of times that a password is used twice or more
	 * If password "Password123" is used three times,
	 * then the method would return three.
	 * 
	 * The method stores passwords (or its encrypted version)
	 * in a String-integer key everytime a login is added to the program
	 * The integer increases by one if it is a repeat password
	 * 
	 * @param password
	 * @return integer
	 */
	public int lookForRepeats(String password) {
		repeatPasswords.put(password, repeatPasswords.getOrDefault(password, 0) + 1);
		int repeats = 0;
		for (String key : repeatPasswords.keySet()){
			 if (repeatPasswords.get(key) > 1) {
				 repeats += repeatPasswords.get(key);
			 }
		 }
		return repeats;
	}
	
	/**
	 * The method adds a protocol (http://) or returns a redirect
	 * if the entered website is missing a protocol or redirects 
	 * (including redirect from http:// to https://)
	 * 
	 * @param website
	 * @return URL
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	private URL standardiseWebsite(String website) throws IOException, MalformedURLException {	
		//check whether the website has a protocol
		//adds protocol if it is missing
		if (!(website.startsWith("https://") && website.startsWith("http://"))) {
			website = "http://" + website;
		}
		
		URL site = new URL(website);
		
		//checks whether the url is valid
	    UrlValidator urlValidator = new UrlValidator();
	    if (!urlValidator.isValid(website)) {
	    	return site;
	    }
		
	    //updates site with possible redirects
		if (site.getProtocol().equals("http")) {
			HttpURLConnection connect = (HttpURLConnection) site.openConnection();
			int code = connect.getResponseCode();
			if ((code == HttpURLConnection.HTTP_MOVED_TEMP
					|| code == HttpURLConnection.HTTP_MOVED_PERM
					|| code == HttpURLConnection.HTTP_SEE_OTHER)) {
				site = new URL(connect.getHeaderField("Location"));
			}
	    }
	    
	    if (site.getProtocol().equals("https")) {
	    	HttpsURLConnection connects = (HttpsURLConnection) site.openConnection();
			int code2 = connects.getResponseCode();
			if ((code2 == HttpsURLConnection.HTTP_MOVED_TEMP
					|| code2 == HttpsURLConnection.HTTP_MOVED_PERM
					|| code2 == HttpsURLConnection.HTTP_SEE_OTHER)) {
				site = new URL(connects.getHeaderField("Location"));
			}
	    }
	    
		return site;
	}
	
	/**
	 * After a website is entered into standardiseWebsite() 
	 * and has the right format, the method checks whether
	 * the protocol equals "http://" or "https://"
	 * 
	 * @param website
	 * @return
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public boolean checkUnsecure(String website) throws IOException, MalformedURLException {
	    URL site = standardiseWebsite(website);
		
		UrlValidator urlValidator = new UrlValidator();
	    if (!urlValidator.isValid(site.toString())) {
	    	return true;
	    }
		
		if (site.getProtocol().equals("http")) {
			return false;
		}
		return true;
	}
}
