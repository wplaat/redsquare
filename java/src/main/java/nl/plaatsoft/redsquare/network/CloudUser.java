package nl.plaatsoft.redsquare.network;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import nl.plaatsoft.redsquare.tools.Constants;

public class CloudUser {

	final static Logger log = Logger.getLogger( CloudUser.class);
	
	private static int uid=0;
	private static String nickName;
	
	public static void fetch() {

		String parameters = "action=getUser"+
				"&username=" + System.getProperty("user.name") +
				"&nickname=" + System.getProperty("user.name") +
				"&country=" +  CloudGeoCode.getCountry() +
				"&city=" +  CloudGeoCode.getCity();
						
		log.info(Constants.APP_WS_URL+ " "+parameters);
		String json = CloudUtils.executePost(Constants.APP_WS_URL, parameters);
		log.info(json);
		
		try {
			JSONObject obj = new JSONObject(json);
			uid = obj.getInt("uid");
			nickName = obj.getString("nickname");		
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public static int getUid() {
		if (uid==0) {
			fetch();
		}
		return uid;
	}
	
	public static String getNickname() {
		return nickName;
	}
}

