package sportiveapp.compubase.com.sportiveapp.ui.model;//
//  UserActivity.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on August 21, 2019

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class UserActivity{

	@SerializedName("Datee")
	private String datee;
	@SerializedName("id")
	private int id;
	@SerializedName("id_receive")
	private int idReceive;
	@SerializedName("id_send")
	private int idSend;
	@SerializedName("message")
	private String message;
	@SerializedName("type")
	private String type;

	public void setDatee(String datee){
		this.datee = datee;
	}
	public String getDatee(){
		return this.datee;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setIdReceive(int idReceive){
		this.idReceive = idReceive;
	}
	public int getIdReceive(){
		return this.idReceive;
	}
	public void setIdSend(int idSend){
		this.idSend = idSend;
	}
	public int getIdSend(){
		return this.idSend;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getMessage(){
		return this.message;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */

}