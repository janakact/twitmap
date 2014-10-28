import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName=DatabaseHelper.tableName)
@XmlRootElement
public class Tweet implements Comparable
{
	private String id;
	private String location;
	private String keyword;
	
	@DynamoDBHashKey(attributeName="Id")
	@DynamoDBAutoGeneratedKey
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	@DynamoDBAttribute(attributeName="Location")
	public String getLocation(){return location;}
	public void setLocation(String location) {this.location = location;}
	
	@DynamoDBAttribute(attributeName="Keyword")
	public String getKeyword() {return keyword;}
	public void setKeyword(String keyword) {this.keyword = keyword;}
	
	
	
	@DynamoDBIgnore
	public Tweet withId(String id)
	{
		this.id = id;
		return this;
	}
	
	
	@DynamoDBIgnore
	public Tweet withLocation(String location){
		this.location = location;
		return this;
	}
	
	@DynamoDBIgnore
	public Tweet withKeyword(String keyword){
		this.keyword = keyword;
		return this;
	}
	
	
	@Override
	@DynamoDBIgnore
	public String toString()
	{
		String str = "{id=" + this.id
			+ ", " + "location=" + this.location
			+ ", " + "keyword=" + this.keyword + "}";
		return str;
	}
	@Override
	@DynamoDBIgnore
	public int compareTo(Object o) {
		return this.keyword.compareTo(((Tweet)o).getKeyword());
	}
}